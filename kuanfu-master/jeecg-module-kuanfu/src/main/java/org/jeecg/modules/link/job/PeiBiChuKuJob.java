package org.jeecg.modules.link.job;

import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.checkerframework.checker.units.qual.A;
import org.jeecg.modules.link.config.U8CConstant;
import org.jeecg.modules.link.entity.BdCalbody;
import org.jeecg.modules.link.entity.BomB;
import org.jeecg.modules.link.entity.LinkPeibiList;
import org.jeecg.modules.link.entity.VIaInoutledger;
import org.jeecg.modules.link.mapper.PkTranslateCodeMapper;
import org.jeecg.modules.link.mapper.SyncDocMapper;
import org.jeecg.modules.link.service.IBdCalbodyService;
import org.jeecg.modules.link.service.IBomBService;
import org.jeecg.modules.link.service.ILinkPeibiListService;
import org.jeecg.modules.link.service.IVIaInoutledgerService;
import org.jeecg.modules.link.vo.Childrenvo;
import org.jeecg.modules.link.vo.GeneralBillVO;
import org.jeecg.modules.link.vo.Parentvo;
import org.jeecg.modules.link.vo.U8cVOMaterialout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Component
public class PeiBiChuKuJob {
    @Autowired
    private IVIaInoutledgerService iVIaInoutledgerService;
    @Autowired
    private IBdCalbodyService iBdCalbodyService;
    @Autowired
    private IBomBService bomBService;
    @Autowired
    private IBdCalbodyService bdCalbodyService;
    @Autowired
    private SyncDocMapper syncDocMapper;
    @Autowired
    private ILinkPeibiListService linkPeibiListService;
    @Autowired
    private PkTranslateCodeMapper pkTranslateCodeMapper;

    @Scheduled(cron = "0 0/5 * * * ? ")
    public void peiBiChuKu() {
        log.info("=====配比出库定时任务开始=====");
        //获取昨天日期和明天日期yyyy-MM-dd输出
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -40);
        Date time = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String zuotian = sdf.format(time);

        calendar.add(Calendar.DATE, 41);
        Date time2 = calendar.getTime();
        String jintian = sdf.format(time2);

        //获取库存组织PK



        List<LinkPeibiList> list = linkPeibiListService.list();
        for (LinkPeibiList linkPeibiList : list) {
            String corpCode = linkPeibiList.getCorpCode();
            String corpPk = linkPeibiList.getCorpPk();
            List<VIaInoutledger> vIaInoutledgers = iVIaInoutledgerService.selectByPkCode(corpPk, zuotian, jintian);

            BdCalbody bdCalbody = null;
            if (!vIaInoutledgers.isEmpty()){
                log.info("配比出库单据数量：{}", vIaInoutledgers.size());
                List<BdCalbody> bdCalbodies = iBdCalbodyService.selectByPkCorp(corpPk);
                bdCalbody = bdCalbodies.get(0);
            }


            for (VIaInoutledger vIaInoutledger : vIaInoutledgers) {
                log.info("配比出库单据：{}", vIaInoutledger);
                String s = bdCalbodyService.selectStorNumbet(vIaInoutledger.getCbillid());
                //如果s为空或null跳出循环
                if (s == null || "".equals(s)){
                    log.info("CbillBid：{}，仓库为空", vIaInoutledger.getCbillBid());
                    continue;
                }

                //根据存货档案ID查询BOM表
                List<BomB> bomBS = bomBService.selectBywlbmidAndgcbmV2(vIaInoutledger.getCinvbasid(), bdCalbody.getPkCalbody());
                if (bomBS.isEmpty()) {
                    log.info("存货：{}，PkCalbody:{},BOM表为空", vIaInoutledger.getCinvbasid(),bdCalbody.getPkCalbody());
                } else {
                    //JSON最外层表
                    U8cVOMaterialout u8cVOMaterialout = new U8cVOMaterialout();
                /*
                private List<Childrenvo> childrenvo;
                private Parentvo parentvo;
                */
                    GeneralBillVO generalBillVO = new GeneralBillVO();

                    //仓库 制单人 公司
                    Parentvo parentvo = new Parentvo();
                    //操作员
                    parentvo.setCoperatorid("15069754111");
                    //仓库
                    parentvo.setCwarehouseid(s);
                    //库存组织
                    parentvo.setPk_calbody(bdCalbody.getBodycode());
                    //公司id
                    parentvo.setPk_corp(corpCode);
                    //部门
                    parentvo.setCdptid("07");
                    //收发类别
                    parentvo.setCdispatcherid("0202");

                    parentvo.setDbilldate(vIaInoutledger.getDbilldate());

                    generalBillVO.setParentvo(parentvo);


                   // System.out.println(parentvo);


                    List<Childrenvo> childrenvos = new ArrayList<>();

                    double nnumber = vIaInoutledger.getNnumber();

                    for (BomB bomB : bomBS) {
                        //存货 数量
                        Childrenvo childrenvo = new Childrenvo();
                        childrenvo.setCcostobject(pkTranslateCodeMapper.chunhuodangan(vIaInoutledger.getCinvbasid()));
                        childrenvo.setCinventoryid(bomB.getInvcode());
                        BigDecimal sl = bomB.getSl();
                        BigDecimal mul = NumberUtil.mul(sl, nnumber);
                        childrenvo.setNoutnum(mul.toString());
                        childrenvos.add(childrenvo);

                        //System.out.println(bomB);'
                    }

                    generalBillVO.setChildrenvo(childrenvos);
                    u8cVOMaterialout.setGeneralBillVO(Collections.singletonList(generalBillVO));
                    String jsonString = JSONObject.toJSONString(u8cVOMaterialout);
                    log.info("表单请求数据：{}", jsonString);
                    String tbmimport = tbmimport(jsonString);
                    JSONObject jsonObject1 = JSONObject.parseObject(tbmimport);

                    String string = jsonObject1.getString("status");
                    if ("success".equals(string)){
                        log.info("CbillBid：{}，同步成功", vIaInoutledger.getCbillBid());
                        syncDocMapper.uptadeSyncStatus(vIaInoutledger.getCbillBid());

                    }else {
                        log.info("CbillBid：{}同步失败,返回数据：{}", vIaInoutledger.getCbillBid(),jsonObject1);
                    }

                }
            }

        }
        log.info("=====配比出库定时任务结束=====");
    }

    private static String tbmimport(String body){
        // 服务器访问地址及端口,例如 http://ip:port
        String serviceUrl = U8CConstant.URL;
        // 服务名,例如   /u8cloud/api/ic/materialout/insert
        String serviceName = "/u8cloud/api/ic/materialout/save/sign";
        // 各服务的参数设置,具体可参照服务描述页面的请求参数示例
        //String json = "{\"tbmimport\":[{\"calendartime\":\"2023-12-20 14:54:01\",\"pk_corp\":\"09\",\"timecardid\":\"10086\"}]}";

        // 使用U8cloud系统中设置，具体节点路径为：
        // 应用集成 - 系统集成平台 - 系统信息设置
        // 设置信息中具体属性的对照关系如下：
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("trantype", "code"); // 档案翻译方式，枚举值为：编码请录入 code， 名称请录入 name， 主键请录入 pk
        map.put("system", U8CConstant.SYSTEM); // 系统编码
        map.put("usercode", U8CConstant.USERCODE); // 用户
        map.put("password", U8CConstant.PASSWORD); // 密码，需要 MD5 加密后录入

        // 返回结果
        return operator(serviceUrl + serviceName, map, body);

    }


    private static String operator(String url, Map<String, Object> headparams,
                                   String json) {




        HttpClient httpClient = new HttpClient();
        PostMethod httpPost = new PostMethod(url);
        httpPost.setRequestHeader("content-type",
                "application/json;charset=utf-8");
        for (Map.Entry<String, Object> entry : headparams.entrySet()) {
            httpPost.setRequestHeader(entry.getKey(), entry.getValue()
                    .toString());

        }
        try {
            RequestEntity entity = new StringRequestEntity(json,
                    "application/json", "UTF-8");
            httpPost.setRequestEntity(entity);
            httpClient.executeMethod(httpPost);

            return httpPost.getResponseBodyAsString();

        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
