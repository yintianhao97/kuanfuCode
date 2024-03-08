package org.jeecg.smallTools;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import org.checkerframework.checker.units.qual.A;
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
public class FuKuanDingTest {
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


    @Test
    public void C123123aiGouTongBu() {
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

        List<ArapDjzb> unsyDoc = arapDjzbService.getUnsyDoc("1010", qiantian, houtian);
        System.out.println(unsyDoc.size());
        for (ArapDjzb arapDjzb : unsyDoc) {
            ServiceResult<String> stringServiceResult = ServiceResult.failure("初始化");

            /*公司	公司	dwbm
            交易类型名称	交易类型名称	ywbm
            单据号	单据号	djbh
            单据日期	单据日期	djrq
            结算方式	结算方式	pj_jsfs
            原币金额	原币金额	ybje
            备注	备注	scomment*/
            System.out.println("=======================================");
            String dwbm = arapDjzb.getDwbm();
            String gongsi = pkTranslateCodeMapper.gongsi(dwbm);
            System.out.println("公司"+gongsi);
            String ywbm = arapDjzb.getYwbm();
            String danjvleixing = pkTranslateCodeMapper.danjvleixing(ywbm);
            System.out.println("交易类型名称"+danjvleixing);
            String djbh = arapDjzb.getDjbh();
            System.out.println("单据号"+djbh);
            String djrq = arapDjzb.getDjrq();
            System.out.println("单据日期"+djrq);
            String pj_jsfs = arapDjzb.getPjJsfs();
            String jiesuanfangshi = pkTranslateCodeMapper.jiesuanfangshi("1010", pj_jsfs);
            System.out.println("结算方式"+jiesuanfangshi);

            BigDecimal ybje = arapDjzb.getYbje();
            System.out.println("原币金额"+ybje);

            List<ArapDjfb> byVouchid = arapDjfbService.getByVouchid(arapDjzb.getVouchid());

            String hbbm = byVouchid.get(0).getHbbm();

            String jobid = byVouchid.get(0).getJobid();
            if (jobid != null) {
                String xiangmu = pkTranslateCodeMapper.xiangmuFukuan(jobid);
                System.out.println("项目"+xiangmu);
            }
            //表体


            //===================================================================
            try {
                DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/create");
                OapiProcessinstanceCreateRequest req = new OapiProcessinstanceCreateRequest();
                req.setAgentId(1968639597L);
                req.setProcessCode("PROC-61BD5729-3714-41F6-8965-7851B5E63DE4");
                req.setOriginatorUserId("16561548296327766");
                req.setDeptId((long) -1);
                req.setCcPosition("FINISH");

                List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValueVoList = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
                //单行输入框
                OapiProcessinstanceCreateRequest.FormComponentValueVo formComponentValueVo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                formComponentValueVoList.add(formComponentValueVo);
                formComponentValueVo.setName("公司");
                formComponentValueVo.setValue(gongsi);

                OapiProcessinstanceCreateRequest.FormComponentValueVo jiaoyileixing = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                formComponentValueVoList.add(jiaoyileixing);
                jiaoyileixing.setName("交易类型名称");
                jiaoyileixing.setValue(danjvleixing);

                OapiProcessinstanceCreateRequest.FormComponentValueVo danjvhao = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                formComponentValueVoList.add(danjvhao);
                danjvhao.setName("单据号");
                danjvhao.setValue(djbh);

                OapiProcessinstanceCreateRequest.FormComponentValueVo danjvriqi = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                formComponentValueVoList.add(danjvriqi);
                danjvriqi.setName("单据日期");
                danjvriqi.setValue(djrq);



                if (hbbm != null) {
                    String huobibianma = pkTranslateCodeMapper.gonghuoshang(hbbm);
                    System.out.println("客商:"+huobibianma);
                    OapiProcessinstanceCreateRequest.FormComponentValueVo keshang = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(keshang);
                    keshang.setName("客商");
                    keshang.setValue(huobibianma);

                }
                if (jobid != null) {
                    String xiangmu = pkTranslateCodeMapper.xiangmuFukuan(jobid);
                    System.out.println("项目"+xiangmu);
                    OapiProcessinstanceCreateRequest.FormComponentValueVo  xiangmuVo= new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    formComponentValueVoList.add(xiangmuVo);
                    xiangmuVo.setName("项目");
                    xiangmuVo.setValue(xiangmu);
                }

                OapiProcessinstanceCreateRequest.FormComponentValueVo  jieshuanfangshi= new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                formComponentValueVoList.add(danjvriqi);
                jieshuanfangshi.setName("结算方式");
                jieshuanfangshi.setValue(djrq);

                OapiProcessinstanceCreateRequest.FormComponentValueVo  yuanbijine= new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                formComponentValueVoList.add(yuanbijine);
                yuanbijine.setName("原币金额");
                yuanbijine.setValue(ybje.toString());
                String scomment = arapDjzb.getScomment();

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
                    System.out.println("订单号"+ddh);
                    String fph = arapDjfb.getFph();
                    System.out.println("发票号"+fph);
                    String zy = arapDjfb.getZy();
                    System.out.println("摘要"+zy);
                    String bzbm = arapDjfb.getBzbm();
                    String bizi = pkTranslateCodeMapper.bizhong(bzbm);
                    System.out.println("币种"+bizi);
                    BigDecimal bbye = arapDjfb.getBbye();
                    System.out.println("本币金额"+bbye);
                    String shujv = "订单号:"+ddh+",发票号:"+fph+",摘要:"+zy+",币种:"+bizi+",本币金额:"+bbye;
                    OapiProcessinstanceCreateRequest.FormComponentValueVo Item1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
                    Item1.setName("单行输入框");
                    Item1.setValue(shujv);
                    List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list = Collections.singletonList(Item1);
                    asList.add(list);


                }



                String jsonString = JSON.toJSONString(
                        asList
                );
                System.out.println(jsonString);



                formComponentValueVo12.setName("明细");
                formComponentValueVo12.setValue(jsonString);
                formComponentValueVoList.add(formComponentValueVo12);






                String token = AccessTokenUtil.getToken();
                req.setFormComponentValues(formComponentValueVoList);
                OapiProcessinstanceCreateResponse response = client.execute(req, token);
                System.out.println(JSON.toJSONString(response));

                if (response.getErrcode().longValue() != 0) {
                    stringServiceResult = ServiceResult.failure(String.valueOf(response.getErrorCode()), response.getErrmsg());
                }
                stringServiceResult = ServiceResult.success(response.getProcessInstanceId());

            } catch (Exception e) {
                String errLog = LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                        LogFormatter.KeyValue.getNew("processInstance", ""));
                //bizLogger.info(errLog, e);
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





    @Test
    public void CaiGou() {


    }






}
