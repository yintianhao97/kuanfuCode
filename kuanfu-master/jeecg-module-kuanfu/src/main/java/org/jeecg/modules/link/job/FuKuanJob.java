package org.jeecg.modules.link.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.link.entity.*;
import org.jeecg.modules.link.mapper.BdCalbodyMapper;
import org.jeecg.modules.link.mapper.PkTranslateCodeMapper;
import org.jeecg.modules.link.service.*;
import org.jeecg.modules.link.utils.AccessTokenUtil;
import org.jeecg.modules.link.utils.LogFormatter;
import org.jeecg.modules.link.utils.ServiceResult;
import org.jeecg.modules.link.utils.ServiceResultCode;
import org.jeecg.modules.link.vo.BankVo;
import org.jeecg.modules.link.vo.BdInvVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Component
public class FuKuanJob {
    @Autowired
    private IArapDjzbService arapDjzbService;
    @Autowired
    private IArapDjfbService   arapDjfbService;
    @Autowired
    private PkTranslateCodeMapper pkTranslateCodeMapper;
    @Autowired
    private IFukuanLinkService fukuanLinkService;
    @Autowired
    private IDocTypeLinkService docTypeLinkService;
    @Autowired
    private ILinkDingdingListService linkDingdingListService;
    @Autowired
    private IDingtalkUserInfoService dingtalkUserInfoService;
    @Autowired
    private IBdCorpService bdCorpService;
    @Autowired
    private BdCalbodyMapper bdCalbodyMapper;



    @Scheduled(cron = "0 0/5 * * * ? ")
    public void CaiGouTongBu() {
        //获取前天日期和后天日期yyyy-MM-dd输出
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -30);
        Date time = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String qiantian = sdf.format(time);
        calendar.add(Calendar.DATE, 31);
        Date time2 = calendar.getTime();
        String houtian = sdf.format(time2);


        List<BdCorp> corpList = bdCorpService.getCorpList();
        for (BdCorp bdCorp : corpList) {
            String corpPk = bdCorp.getPkCorp();

/*            List<BdCalbody> bdCalbodies = bdCalbodyMapper.selectByPkCorp(corpPk);
            //判断bdCalbodies是否为空
            if (bdCalbodies == null || bdCalbodies.size() == 0) {
                log.info();
                //return Result.error("库存组织不存在,请创建库存组织");
                continue;
            }*/

//        List<LinkDingdingList> list1 = linkDingdingListService.list();

            List<ArapDjzb> unsyDoc = arapDjzbService.getUnsyDoc(corpPk, qiantian, houtian);
            if (!unsyDoc.isEmpty()){
                log.info("公司:{}待同步付款单单数量:{}",corpPk,unsyDoc.size());
            }

            for (ArapDjzb arapDjzb : unsyDoc) {
                String dingUserIdByU8Pk = dingtalkUserInfoService.getDingUserIdByU8Pk(arapDjzb.getLrr());
                //如果dingUserIdByU8Pk为null或空跳出for循环
                if (dingUserIdByU8Pk == null || dingUserIdByU8Pk.equals("")) {
                    log.info("付款单同步失败:用户ID:{}的DingUserID为空",arapDjzb.getLrr());
                    continue;
                }
                ServiceResult<String> stringServiceResult = ServiceResult.failure("初始化");

            /*公司	公司	dwbm
            交易类型名称	交易类型名称	ywbm
            单据号	单据号	djbh
            单据日期	单据日期	djrq
            结算方式	结算方式	pj_jsfs
            原币金额	原币金额	ybje
            备注	备注	scomment*/
                //System.out.println("=======================================");
                String dwbm = arapDjzb.getDwbm();
                String gongsi = pkTranslateCodeMapper.gongsi(dwbm);
                //System.out.println("公司"+gongsi);
                String ywbm = arapDjzb.getYwbm();
                String danjvleixing = pkTranslateCodeMapper.danjvleixing(ywbm);
                //System.out.println("交易类型名称"+danjvleixing);
                String djbh = arapDjzb.getDjbh();
                //System.out.println("单据号"+djbh);
                String djrq = arapDjzb.getDjrq();
                //System.out.println("单据日期"+djrq);
                String pj_jsfs = arapDjzb.getPjJsfs();

                String zyx1 = arapDjzb.getZyx1();

                String jiesuanfangshi = pkTranslateCodeMapper.jiesuanfangshi(corpPk, pj_jsfs);
                //System.out.println("结算方式"+jiesuanfangshi);

                BigDecimal ybje = arapDjzb.getYbje();
                //System.out.println("原币金额"+ybje);

                //收款


                List<ArapDjfb> byVouchid = arapDjfbService.getByVouchid(arapDjzb.getVouchid());

                String hbbm = byVouchid.get(0).getHbbm();

                String jobid =  arapDjzb.getZyx2();

                String dfyhzh = byVouchid.get(0).getDfyhzh();


                //表体


                //===================================================================
                try {

                    String token = AccessTokenUtil.getToken();

                    DingTalkClient clientDep = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get");
                    OapiUserGetRequest reqDep = new OapiUserGetRequest();
                    reqDep.setUserid(dingUserIdByU8Pk);
                    reqDep.setHttpMethod("GET");
                    OapiUserGetResponse rsp = clientDep.execute(reqDep, token);
                    String body = rsp.getBody();

                    JSONObject jobj = JSON.parseObject(body);//封装成一个JSON对象\
                    JSONArray department = jobj.getJSONArray("department");
                    Long dep = department.getLong(0);





                    DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/create");
                    OapiProcessinstanceCreateRequest req = new OapiProcessinstanceCreateRequest();
                    req.setAgentId(1968639597L);
                    req.setProcessCode("PROC-61BD5729-3714-41F6-8965-7851B5E63DE4");
                    req.setOriginatorUserId(dingUserIdByU8Pk);
                    req.setDeptId(dep);
                    req.setCcPosition("FINISH");

                    List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValueVoList = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
                    //单行输入框
                    OapiProcessinstanceCreateRequest.FormComponentValueVo faqiren = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(faqiren);
                    faqiren.setName("发起人");
                    faqiren.setValue("[\""+dingUserIdByU8Pk+"\"]");


                    if (jobid != null) {
                        String xiangmu = pkTranslateCodeMapper.xiangmuFukuan(jobid);
                        OapiProcessinstanceCreateRequest.FormComponentValueVo xiangmuVo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(xiangmuVo);
                        xiangmuVo.setName("采购项目");
                        xiangmuVo.setValue(xiangmu);
                    }

                    OapiProcessinstanceCreateRequest.FormComponentValueVo formComponentValueVo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(formComponentValueVo);
                    formComponentValueVo.setName("采购组织");
                    formComponentValueVo.setValue(gongsi);

                    OapiProcessinstanceCreateRequest.FormComponentValueVo jiaoyileixing = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(jiaoyileixing);
                    jiaoyileixing.setName("交易类型名称");
                    jiaoyileixing.setValue(danjvleixing);

                    OapiProcessinstanceCreateRequest.FormComponentValueVo danjvhao = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(danjvhao);
                    danjvhao.setName("单据号");
                    danjvhao.setValue(djbh);

                    if(zyx1!=null){
                        OapiProcessinstanceCreateRequest.FormComponentValueVo zhiyouxiang1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(zhiyouxiang1);
                        zhiyouxiang1.setName("收款名称");
                        zhiyouxiang1.setValue(zyx1);
                    }


                    OapiProcessinstanceCreateRequest.FormComponentValueVo danjvriqi = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(danjvriqi);
                    danjvriqi.setName("单据日期");
                    danjvriqi.setValue(djrq);



                    if (hbbm != null) {
                        String huobibianma = pkTranslateCodeMapper.gonghuoshang(hbbm);
                        //System.out.println("客商:"+huobibianma);
                        OapiProcessinstanceCreateRequest.FormComponentValueVo keshang = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(keshang);
                        keshang.setName("客商");
                        keshang.setValue(huobibianma);

                    }
                    /*if (jobid != null) {
                        String xiangmu = pkTranslateCodeMapper.xiangmuFukuan(jobid);
                        //System.out.println("项目"+xiangmu);
                        OapiProcessinstanceCreateRequest.FormComponentValueVo  xiangmuVo= new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(xiangmuVo);
                        xiangmuVo.setName("项目");
                        xiangmuVo.setValue(xiangmu);
                    }*/

                    OapiProcessinstanceCreateRequest.FormComponentValueVo  jieshuanfangshi= new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(danjvriqi);
                    jieshuanfangshi.setName("结算方式");
                    jieshuanfangshi.setValue(djrq);

                    OapiProcessinstanceCreateRequest.FormComponentValueVo  yuanbijine= new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(yuanbijine);
                    yuanbijine.setName("原币金额（元）");

                    if (ybje!=null){
                        yuanbijine.setValue(ybje.setScale(4,BigDecimal.ROUND_DOWN).toString());
                    }else {
                        yuanbijine.setValue(null);
                    }


                    String scomment = arapDjzb.getScomment();
                    if (dfyhzh!=null){
                        BankVo yinhangzhanghu = pkTranslateCodeMapper.yinhangzhanghu(dfyhzh);

                        OapiProcessinstanceCreateRequest.FormComponentValueVo  shoukuanren= new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(shoukuanren);
                        shoukuanren.setName("收款人名称");
                        shoukuanren.setValue(yinhangzhanghu.getCustname());

                        OapiProcessinstanceCreateRequest.FormComponentValueVo  shoukuanyinhang= new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(shoukuanyinhang);
                        shoukuanyinhang.setName("收款银行名称");
                        shoukuanyinhang.setValue(yinhangzhanghu.getBanktypename());

                        OapiProcessinstanceCreateRequest.FormComponentValueVo  shoukuanzhanghao= new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(shoukuanzhanghao);
                        shoukuanzhanghao.setName("收款账号");
                        shoukuanzhanghao.setValue(yinhangzhanghu.getAccount());
                    }
                    if (scomment != null) {
                        OapiProcessinstanceCreateRequest.FormComponentValueVo  beizhu= new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(beizhu);
                        beizhu.setName("备注");
                        beizhu.setValue(scomment);
                    }

                    OapiProcessinstanceCreateRequest.FormComponentValueVo formComponentValueVo12 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    List<List<OapiProcessinstanceCreateRequest.FormComponentValueVo>> asList =  new ArrayList<>();
                    for (ArapDjfb arapDjfb : byVouchid) {
                    /*订单号	订单号	ddh
                    发票号	发票号	fph
                    摘要	摘要	zy
                    币种	币种	bzbm
                    本币金额	本币金额	bbye*/

                        String ddh = arapDjfb.getDdh();
                       // System.out.println("订单号"+ddh);
                        String fph = arapDjfb.getFph();
                       // System.out.println("发票号"+fph);
                        String zy = arapDjfb.getZy();
                       // System.out.println("摘要"+zy);
                        String bzbm = arapDjfb.getBzbm();
                        String bizi = pkTranslateCodeMapper.bizhong(bzbm);
                       // System.out.println("币种"+bizi);
                        BigDecimal bbye = arapDjfb.getBbye();
                        //System.out.println("本币金额"+bbye);
                       // String shujv = "订单号:"+ddh+",发票号:"+fph+",摘要:"+zy+",币种:"+bizi+",本币金额:"+bbye;
                        OapiProcessinstanceCreateRequest.FormComponentValueVo dingdanhao = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        dingdanhao.setName("订单号");
                        dingdanhao.setValue(ddh);

                        OapiProcessinstanceCreateRequest.FormComponentValueVo fapiaohao = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        fapiaohao.setName("发票号");
                        fapiaohao.setValue(fph);

                        OapiProcessinstanceCreateRequest.FormComponentValueVo zaiyao = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        zaiyao.setName("摘要");
                        zaiyao.setValue(zy);

                        OapiProcessinstanceCreateRequest.FormComponentValueVo bizhong = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        bizhong.setName("币种");
                        bizhong.setValue(bizi);

                        OapiProcessinstanceCreateRequest.FormComponentValueVo benbijine = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        benbijine.setName("本币金额");
                        if (bbye!=null){
                            benbijine.setValue(bbye.setScale(4,BigDecimal.ROUND_DOWN).toString());

                        }else {
                            benbijine.setValue(null);
                        }

                        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list =
                                Arrays.asList(dingdanhao,fapiaohao,zaiyao,bizhong,benbijine);

                        asList.add(list);
                    }
                    String jsonString = JSON.toJSONString(
                            asList
                    );
                    //System.out.println(jsonString);
                    formComponentValueVo12.setName("明细");
                    formComponentValueVo12.setValue(jsonString);
                    formComponentValueVoList.add(formComponentValueVo12);
                    //String token = AccessTokenUtil.getToken();
                    req.setFormComponentValues(formComponentValueVoList);
                    OapiProcessinstanceCreateResponse response = client.execute(req, token);
                    //System.out.println(JSON.toJSONString(response));

                    if (response.getErrcode().longValue() != 0) {
                        log.info("付款单传输钉钉失败,json:{}", JSON.toJSONString(response));
                        stringServiceResult = ServiceResult.failure(String.valueOf(response.getErrorCode()), response.getErrmsg());
                    }else {
                        log.info("付款单传输钉钉成功,json:{}", JSON.toJSONString(response));
                        stringServiceResult = ServiceResult.success(response.getProcessInstanceId());
                    }
                    log.info("钉钉返回数据:{}",JSON.toJSONString(response));


                } catch (Exception e) {
                    String errLog = LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                            LogFormatter.KeyValue.getNew("processInstance", ""));

                    log.info(errLog, e);
                    stringServiceResult =  ServiceResult.failure(ServiceResultCode.SYS_ERROR.getErrCode(), ServiceResultCode.SYS_ERROR.getErrMsg());
                }
                if(stringServiceResult.isSuccess()) {
                    //审批ID
                    String result = stringServiceResult.getResult();
                    fukuanLinkService.delByErpId(arapDjzb.getVouchid());
                    fukuanLinkService.save(
                            new FukuanLink().setDingcode(result).setErpcode(arapDjzb.getVouchid()).setState("1").setTlastmaketime(arapDjzb.getTs()).setCorp(dwbm).setErpcode2(djbh)
                    );
                    docTypeLinkService.save(
                            new DocTypeLink().setDingcode(result).setErpcode(arapDjzb.getVouchid()).setDoctype("02")
                    );
                }
            }
        }






    }

}
