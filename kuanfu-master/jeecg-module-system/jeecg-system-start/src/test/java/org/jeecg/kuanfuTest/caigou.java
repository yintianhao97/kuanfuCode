package org.jeecg.kuanfuTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiFileUploadSingleRequest;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.taobao.api.ApiException;
import com.taobao.api.FileItem;
import org.jeecg.JeecgSystemApplication;
import org.jeecg.modules.link.entity.*;
import org.jeecg.modules.link.mapper.PkTranslateCodeMapper;
import org.jeecg.modules.link.service.*;
import org.jeecg.modules.link.utils.AccessTokenUtil;
import org.jeecg.modules.link.utils.LogFormatter;
import org.jeecg.modules.link.utils.ServiceResult;
import org.jeecg.modules.link.utils.ServiceResultCode;
import org.jeecg.modules.link.vo.BdInvVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = JeecgSystemApplication.class)
public class caigou {
    @Autowired
    private IPoOrderService poOrderService;
    @Autowired
    private IPoOrderBService poOrderBService;
    @Autowired
    private IPoOrderLinkService poOrderLinkService;
    @Autowired
    private IDocTypeLinkService docTypeLinkService;
    @Autowired
    private PkTranslateCodeMapper pkTranslateCodeMapper;
    @Autowired
    private ILinkDingdingListService linkDingdingListService;
    @Autowired
    private IDingtalkUserInfoService dingtalkUserInfoService;
    @Autowired
    private IFukuanLinkService fukuanLinkService;

    @Test
    public void shenhe(){
        OapiFileUploadSingleRequest oapiFileUploadSingleRequest = new OapiFileUploadSingleRequest();


       // oapiFileUploadSingleRequest.setFile(new FileItem());





    }

    @Test
    public void CaiGouTongBu() {
        //获取前天日期和后天日期yyyy-MM-dd输出
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -6);
        Date time = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String qiantian = sdf.format(time);
        calendar.add(Calendar.DATE, 7);
        Date time2 = calendar.getTime();
        String houtian = sdf.format(time2);

        List<LinkDingdingList> list1 = linkDingdingListService.list();
        for (LinkDingdingList linkDingdingList : list1) {
            String corpPk = linkDingdingList.getCorpPk();

            //查询位同步单据
            List<PoOrder> poOrders = poOrderService.dingSync(corpPk, qiantian, houtian);
            //log.info("采购订单数量"+poOrders.size());

            for (PoOrder poOrder : poOrders) {
                ServiceResult<String> stringServiceResult = ServiceResult.failure("初始化");



                //log.info("===============================================采购订单数据");
                //获取表头数据
        /*          业务流程	业务流程	cbiztype
                    采购组织	采购组织	cpurorganization
                    供应商	供应商	cvendorbaseid
                    订单编号	订单编号	vordercode
                    采购日期	采购日期	dorderdate
                    采购员	采购员	cemployeeid
                    采购部门	采购部门	cdeptid
                    合计数量	合计数量	ntotalnum
                    合计金额	合计金额	ntotalmny
                    备注	备注	vmemo*/

                String corderid = poOrder.getCorderid();
                String xiangmu = pkTranslateCodeMapper.xiangmu(corderid);
                // System.out.println("项目"+xiangmu);
                String cbiztype = poOrder.getCbiztype();
                String yewuliucheng = pkTranslateCodeMapper.yewuliucheng(cbiztype);
                //System.out.println("业务流程"+yewuliucheng);
                String cpurorganization = poOrder.getCpurorganization();
                String caigouzuzhi = pkTranslateCodeMapper.caigouzuzhi(cpurorganization);
                // System.out.println("采购组织"+caigouzuzhi);
                String cvendorbaseid = poOrder.getCvendorbaseid();
                String gonghuoshang = pkTranslateCodeMapper.gonghuoshang(cvendorbaseid);
                // System.out.println("供货商"+gonghuoshang);

                String vordercode = poOrder.getVordercode();
                // System.out.println("订单编号"+vordercode);
                String dorderdate = poOrder.getDorderdate();
                // System.out.println("采购日期"+dorderdate);

                String cemployeeid = poOrder.getCemployeeid();
                String renyuandangan = pkTranslateCodeMapper.renyuandangan(cemployeeid);
                // System.out.println("采购员"+renyuandangan);

                String cdeptid = poOrder.getCdeptid();
                String bumendangan = pkTranslateCodeMapper.bumendangan(cdeptid);
                // System.out.println("采购部门"+bumendangan);

                BigDecimal ntotalnum = poOrder.getNtotalnum();
                // System.out.println("合计数量"+ntotalnum.toString());
                BigDecimal ntotalmny = poOrder.getNtotalmny();
                //  System.out.println("合计金额"+ntotalmny.toString());
                String vmemo = poOrder.getVmemo();
                // System.out.println("备注"+vmemo);

                List<PoOrderB> poOrderBS = poOrderBService.selectByCorderId(poOrder.getCorderid());


//            ======================================================================
                try {
                    DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/create");
                    OapiProcessinstanceCreateRequest req = new OapiProcessinstanceCreateRequest();
                    req.setAgentId(1968639597L);
                    req.setProcessCode("PROC-EDB3EF0C-2462-4473-8CF7-B5FA771F7943");
                    req.setOriginatorUserId("16561548296327766");
                    req.setDeptId((long) -1);
                    req.setCcPosition("FINISH");

                    List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValueVoList = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();

                    OapiProcessinstanceCreateRequest.FormComponentValueVo yewuliuchengVo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(yewuliuchengVo);
                    yewuliuchengVo.setName("业务流程");
                    yewuliuchengVo.setValue(yewuliucheng);

                    OapiProcessinstanceCreateRequest.FormComponentValueVo xiangmuVo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(xiangmuVo);
                    xiangmuVo.setName("采购项目");
                    xiangmuVo.setValue(xiangmu);


                    //单行输入框
                    OapiProcessinstanceCreateRequest.FormComponentValueVo formComponentValueVo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(formComponentValueVo);
                    formComponentValueVo.setName("采购组织");
                    formComponentValueVo.setValue(caigouzuzhi);

                    OapiProcessinstanceCreateRequest.FormComponentValueVo gongyinghang = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(gongyinghang);
                    gongyinghang.setName("供应商");
                    gongyinghang.setValue(gonghuoshang);

                    OapiProcessinstanceCreateRequest.FormComponentValueVo dingdanbianhao = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(dingdanbianhao);
                    dingdanbianhao.setName("订单编号");
                    dingdanbianhao.setValue(vordercode);

                    OapiProcessinstanceCreateRequest.FormComponentValueVo caigouriqi = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(caigouriqi);
                    caigouriqi.setName("采购日期");
                    caigouriqi.setValue(dorderdate);



                    OapiProcessinstanceCreateRequest.FormComponentValueVo caigouyuan = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(caigouyuan);
                    caigouyuan.setName("采购员");
                    caigouyuan.setValue(renyuandangan);

                    OapiProcessinstanceCreateRequest.FormComponentValueVo hejishuliang = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(hejishuliang);
                    hejishuliang.setName("合计数量");
                    hejishuliang.setValue(ntotalnum.toString());

                    OapiProcessinstanceCreateRequest.FormComponentValueVo hejijine = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(hejijine);
                    hejijine.setName("合计金额（元）");
                    //String string = ntotalmny.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
                    hejijine.setValue(ntotalmny.toString());

                    //判断备注是否存在
                    if (vmemo!=null){
                        OapiProcessinstanceCreateRequest.FormComponentValueVo beizhu = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(beizhu);
                        beizhu.setName("备注");
                        beizhu.setValue(vmemo);
                    }else {
                        OapiProcessinstanceCreateRequest.FormComponentValueVo beizhu = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(beizhu);
                        beizhu.setName("备注");
                        beizhu.setValue("U8C未填写");
                    }
                    //多行输入框


                    OapiProcessinstanceCreateRequest.FormComponentValueVo formComponentValueVo12 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    List<List<OapiProcessinstanceCreateRequest.FormComponentValueVo>> asList =  new ArrayList<>();
                    for (PoOrderB poOrderB : poOrderBS) {
/*                存货编码	存货编码	cbaseid
                存货名称	存货名称
                对应成品
                计量单位	计量单位
                采购数量	采购数量	nordernum
                        单价
                含税单价	含税单价	norgtaxprice
                金额
                价税合计	价税合计	ntaxpricemny
                税率	税率	ntaxrate
                计划到货日期	计划到货日期	dplanarrvdate
                备注	备注	vmemo*/
                        String cbaseid = poOrderB.getCbaseid();
                        BdInvVo bdInvVo = pkTranslateCodeMapper.chunhuodanganVo(cbaseid);
//                    System.out.println("存货编码:"+bdInvVo);
                        BigDecimal nordernum = poOrderB.getNordernum();
//                    System.out.println("采购数量:"+nordernum);
                        BigDecimal norgtaxprice = poOrderB.getNorgtaxprice();
//                    System.out.println("含税单价:"+norgtaxprice);
                        BigDecimal ntaxpricemny = poOrderB.getNtaxpricemny();
//                    System.out.println("价税合计:"+ntaxpricemny);
                        poOrderB.getNtaxrate();
//                    System.out.println("税率:"+poOrderB.getNtaxrate());
                        String dplanarrvdate = poOrderB.getDplanarrvdate();
//                    System.out.println("计划到货日期:"+dplanarrvdate);

                        String shujv = "存货编码:"+bdInvVo.getInvcode()+",存货名称:"+bdInvVo.getInvname()+",单位:"+bdInvVo.getPkMeasdoc()+",采购数量:"+nordernum+",含税单价:"+norgtaxprice+",价税合计:"+ntaxpricemny+",税率:"+poOrderB.getNtaxrate().toString()+",计划到货日期:"+dplanarrvdate;
                        OapiProcessinstanceCreateRequest.FormComponentValueVo Item1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        Item1.setName("单行输入框");
                        Item1.setValue(shujv);
                        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list = Collections.singletonList(Item1);
                        asList.add(list);

                    }

                /*OapiProcessinstanceCreateRequest.FormComponentValueVo Item4 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                Item4.setName("测试1");
                Item4.setValue("测试4");*/
                    String jsonString = JSON.toJSONString(
                            asList
                    );
                    // log.info(jsonString);
                    formComponentValueVo12.setName("明细表");
                    formComponentValueVo12.setValue(jsonString);

                    String token = AccessTokenUtil.getToken();
                    req.setFormComponentValues(formComponentValueVoList);
                    System.out.println(JSON.toJSONString(req));
                    OapiProcessinstanceCreateResponse response = client.execute(req, token);
                    System.out.println(JSON.toJSONString(response));

                    if (response.getErrcode().longValue() != 0) {
                        stringServiceResult = ServiceResult.failure(String.valueOf(response.getErrorCode()), response.getErrmsg());
                        System.out.println(JSON.toJSONString(stringServiceResult));
                    }else {
                        stringServiceResult = ServiceResult.success(response.getProcessInstanceId());
                    }


                } catch (Exception e) {
                    String errLog = LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                            LogFormatter.KeyValue.getNew("processInstance", ""));

                    stringServiceResult =  ServiceResult.failure(ServiceResultCode.SYS_ERROR.getErrCode(), ServiceResultCode.SYS_ERROR.getErrMsg());
                }
                if(stringServiceResult.isSuccess()) {
                    //审批ID
                    String result = stringServiceResult.getResult();

                    poOrderLinkService.delByErpId(corderid);

                    poOrderLinkService.save(
                            new PoOrderLink().setDingcode(result).setErpcode(corderid).setState("1").setTlastmaketime(poOrder.getTlastmaketime()).setCorp(poOrder.getPkCorp()).setErpcode2(poOrder.getVordercode())
                    );

                    docTypeLinkService.save(
                            new DocTypeLink().setDingcode(result).setErpcode(corderid).setDoctype("01")
                    );

                }




            }

        }





    }


    @Test
    public void CaiGou() {


    }






}
