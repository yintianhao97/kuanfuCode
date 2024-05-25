package org.jeecg.modules.link.job;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.jeecg.modules.link.entity.*;
import org.jeecg.modules.link.mapper.PkTranslateCodeMapper;
import org.jeecg.modules.link.service.*;
import org.jeecg.modules.link.utils.AccessTokenUtil;
import org.jeecg.modules.link.utils.LogFormatter;
import org.jeecg.modules.link.utils.ServiceResult;
import org.jeecg.modules.link.utils.ServiceResultCode;
import org.jeecg.modules.link.vo.BdInvVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Component
public class CaiGouJob {
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
    private IBdCorpService bdCorpService;



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

        /*List<LinkDingdingList> list1 = linkDingdingListService.list();
        for (LinkDingdingList linkDingdingList : list1) {
            String corpPk = linkDingdingList.getCorpPk();
        */

            //查询位同步单据
            List<PoOrder> poOrders = poOrderService.dingSync(corpPk, qiantian, houtian);
            if (!poOrders.isEmpty()){
                log.info("公司:{}待同步采购订单数量:{}",corpPk,poOrders.size());
            }

            for (PoOrder poOrder : poOrders) {

                String dingUserIdByU8Pk = dingtalkUserInfoService.getDingUserIdByU8Pk(poOrder.getCoperator());
                //如果dingUserIdByU8Pk为null或空跳出for循环
                if (dingUserIdByU8Pk == null || dingUserIdByU8Pk.equals("")) {
                    log.info("采购订单同步失败:用户ID:{}的DingUserID为空",poOrder.getCoperator());
                    continue;
                }
                ServiceResult<String> stringServiceResult = ServiceResult.failure("初始化");

                log.info("==========采购订单数据");
                //获取表头数据
                /*
                    业务流程	业务流程	cbiztype
                    采购组织	采购组织	cpurorganization
                    供应商	供应商	cvendorbaseid
                    订单编号	订单编号	vordercode
                    采购日期	采购日期	dorderdate
                    采购员	采购员	cemployeeid
                    采购部门	采购部门	cdeptid
                    合计数量	合计数量	ntotalnum
                    合计金额	合计金额	ntotalmny
                    备注	备注	vmemo
                    */

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
                String renyuandangan = pkTranslateCodeMapper.renyuandanganDingCode(cemployeeid);
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
                    req.setOriginatorUserId(dingUserIdByU8Pk);
                    req.setDeptId((long) -1);
                    req.setCcPosition("FINISH");

                    List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValueVoList = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();


                    //如果yewuliucheng的值是成品采购,主材采购,辅材采购,资产采购
                    if (yewuliucheng.equals("成品采购") || yewuliucheng.equals("主材采购") || yewuliucheng.equals("辅材采购") || yewuliucheng.equals("资产采购")){
                        OapiProcessinstanceCreateRequest.FormComponentValueVo yewuliuchengVo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(yewuliuchengVo);
                        yewuliuchengVo.setName("业务流程");
                        yewuliuchengVo.setValue(yewuliucheng);

                    }else {
                        log.info("单据编号{},业务流程不符合同步要求",vordercode);
                        //跳出本次for循环
                        continue;
                    }
                    /*
                    if (yewuliucheng.equals("资产采购")){
                        OapiProcessinstanceCreateRequest.FormComponentValueVo yewuliuchengVo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(yewuliuchengVo);
                        yewuliuchengVo.setName("业务流程");
                        yewuliuchengVo.setValue(yewuliucheng);
                    }else {
                        OapiProcessinstanceCreateRequest.FormComponentValueVo yewuliuchengVo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        formComponentValueVoList.add(yewuliuchengVo);
                        yewuliuchengVo.setName("业务流程");
                        yewuliuchengVo.setValue("采购订单");
                    }
                    */



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
                    caigouyuan.setValue("[\""+renyuandangan+"\"]");
                   // caigouyuan.setValue(renyuandangan);

                    OapiProcessinstanceCreateRequest.FormComponentValueVo hejishuliang = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(hejishuliang);
                    hejishuliang.setName("合计数量");
                    if (ntotalnum!=null){
                        hejishuliang.setValue(ntotalnum.setScale(2,BigDecimal.ROUND_DOWN).toString());
                    }else {
                        hejishuliang.setValue("");
                    }

                    OapiProcessinstanceCreateRequest.FormComponentValueVo hejijine = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(hejijine);
                    hejijine.setName("合计金额（元）");
                    if (ntotalmny!=null) {
                        hejijine.setValue(ntotalmny.setScale(4, BigDecimal.ROUND_DOWN).toString());
                    }else {
                        hejijine.setValue("");
                    }


                    //判断备注是否存在
                    OapiProcessinstanceCreateRequest.FormComponentValueVo beizhu = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(beizhu);
                    beizhu.setName("备注");
                    if (vmemo!=null){
                        beizhu.setValue(vmemo);
                    }else {
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
                        BigDecimal ntaxrate = poOrderB.getNtaxrate();
//                    System.out.println("税率:"+poOrderB.getNtaxrate());
                        String dplanarrvdate = poOrderB.getDplanarrvdate();
//                    System.out.println("计划到货日期:"+dplanarrvdate);
                        String vmemo1 = poOrderB.getVmemo();
                        // String shujv = "存货编码:"+bdInvVo.getInvcode()+",存货名称:"+bdInvVo.getInvname()+"
                        // ,单位:"+bdInvVo.getPkMeasdoc()+",采购数量:"+nordernum+",含税单价:"+norgtaxprice+",价税合计:"+ntaxpricemny+"
                        // ,税率:"+poOrderB.getNtaxrate().toString()+",计划到货日期:"+dplanarrvdate;

                        OapiProcessinstanceCreateRequest.FormComponentValueVo cunhuobianma = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        cunhuobianma.setName("存货编码");
                        cunhuobianma.setValue(bdInvVo.getInvcode());

                        OapiProcessinstanceCreateRequest.FormComponentValueVo cunhuomingcheng = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        cunhuomingcheng.setName("存货名称");
                        cunhuomingcheng.setValue(bdInvVo.getInvname());

                        OapiProcessinstanceCreateRequest.FormComponentValueVo danwei = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        danwei.setName("单位");
                        danwei.setValue(bdInvVo.getPkMeasdoc());

                        OapiProcessinstanceCreateRequest.FormComponentValueVo caigoushuliang = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        caigoushuliang.setName("采购数量");
                        if (nordernum != null){
                            caigoushuliang.setValue(nordernum.setScale(2,BigDecimal.ROUND_DOWN).toString());
                        }else {
                            caigoushuliang.setValue("");
                        }

                        OapiProcessinstanceCreateRequest.FormComponentValueVo hanshuidanjia = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        hanshuidanjia.setName("含税单价");
                        if (norgtaxprice!=null){
                            hanshuidanjia.setValue(norgtaxprice.setScale(4,BigDecimal.ROUND_DOWN).toString());
                        }else {
                            hanshuidanjia.setValue("");
                        }
                        OapiProcessinstanceCreateRequest.FormComponentValueVo jiashuiheji = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        jiashuiheji.setName("价税合计");
                        if (ntaxpricemny!=null){
                            jiashuiheji.setValue(ntaxpricemny.setScale(4,BigDecimal.ROUND_DOWN).toString());
                        }else {
                            jiashuiheji.setValue("");
                        }

                        OapiProcessinstanceCreateRequest.FormComponentValueVo shuilv = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        shuilv.setName("税率");
                        if (ntaxrate!=null){
                            shuilv.setValue(ntaxrate.setScale(2,BigDecimal.ROUND_DOWN).toString());
                        }else {
                            shuilv.setValue("");
                        }

                        OapiProcessinstanceCreateRequest.FormComponentValueVo jihua = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        jihua.setName("计划到货日期");
                        jihua.setValue(dplanarrvdate);

                        OapiProcessinstanceCreateRequest.FormComponentValueVo beizhub = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                        beizhub.setName("备注");
                        beizhub.setValue(vmemo1);

                        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list =
                                Arrays.asList(cunhuobianma,cunhuomingcheng,danwei,caigoushuliang,hanshuidanjia,jiashuiheji,shuilv,jihua,beizhub);

                        //List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list = Collections.singletonList(cunhuobianma)
                        asList.add(list);

                    }


                    String jsonString = JSON.toJSONString(
                            asList
                    );
                    formComponentValueVo12.setName("明细表");
                    formComponentValueVo12.setValue(jsonString);
                    formComponentValueVoList.add(formComponentValueVo12);

                    String token = AccessTokenUtil.getToken();
                    req.setFormComponentValues(formComponentValueVoList);

                    OapiProcessinstanceCreateResponse response = client.execute(req, token);


                    if (response.getErrcode().longValue() != 0) {
                        log.info("采购单传输钉钉失败,json:{}", JSON.toJSONString(req));
                        stringServiceResult = ServiceResult.failure(String.valueOf(response.getErrorCode()), response.getErrmsg());
                    }else {
                        log.info("采购单传输钉钉成功,json:{}", JSON.toJSONString(req));
                        stringServiceResult = ServiceResult.success(response.getProcessInstanceId());
                    }
                    log.info("钉钉返回数据:{}",JSON.toJSONString(response));

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

}
