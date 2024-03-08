package org.jeecg.smallTools;

import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.jeecg.JeecgSystemApplication;
import org.jeecg.modules.link.config.U8CConstant;
import org.jeecg.modules.link.entity.*;
import org.jeecg.modules.link.mapper.*;
import org.jeecg.modules.link.service.*;
import org.jeecg.modules.link.vo.Childrenvo;
import org.jeecg.modules.link.vo.GeneralBillVO;
import org.jeecg.modules.link.vo.Parentvo;
import org.jeecg.modules.link.vo.U8cVOMaterialout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = JeecgSystemApplication.class)
public class JMBTest {
    @Autowired
    private BdInvmandocMapper bdInvmandocMapper;
    @Autowired
    private IaBillBMapper iaBillBMapper;
    @Autowired
    private BomBMapper bomBMapper;
    @Autowired
    private VIaInoutledgerMapper vIaInoutledgerMapper;
    @Autowired
    private BdCalbodyMapper bdCalbodyMapper;
    @Autowired
    private LinkPriceListMapper linkPriceListMapper;
    @Autowired
    private SyncDocMapper syncDocMapper;
    @Autowired
    private IPoOrderService poOrderService;
    @Autowired
    private IPoOrderBService poOrderBService;
    @Autowired
    private IPrmTariffService prmTariffService;
    @Autowired
    private IPrmTariffcurlistService prmTariffcurlistService;
    @Autowired
    private PkTranslateCodeMapper pkTranslateCodeMapper;
    @Autowired
    private IDingtalkUserInfoService dingtalkUserInfoService;

    @Test
    public void dingdinguser(){
        List<DingtalkUserInfo> list = dingtalkUserInfoService.list();
        for (DingtalkUserInfo dingtalkUserInfo : list) {
            String zhanghaoxinxi = pkTranslateCodeMapper.zhanghaoxinxi(dingtalkUserInfo.getU8cPhone());
            dingtalkUserInfo.setU8cUserPk(zhanghaoxinxi);
            dingtalkUserInfoService.updateById(dingtalkUserInfo);


        }
    }

    @Test
    public void CaiGou() {

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

        //查询位同步单据
        List<PoOrder> poOrders = poOrderService.selectUnsync("1010", qiantian, houtian);
        System.out.println("采购订单数量");
        System.out.println(poOrders.size());
        for (PoOrder poOrder : poOrders) {
            System.out.println("采购订单数据：");
            System.out.println(poOrder.toString());
            List<PoOrderB> poOrderBS = poOrderBService.selectByCorderId(poOrder.getCorderid());
            for (PoOrderB poOrderB : poOrderBS) {
                System.out.println("采购订单表体数据：");
                System.out.println(poOrderB.toString());
            }
        }
    }


    @Test
    public void testjiamubiao() {
        PrmTariff prmTariff = null;
        String cpricetariffid = null;
        //先获取价目表
        prmTariff = prmTariffService.getBy001("1010");
        //判断by001是否
        if (prmTariff != null) {
            //获取价目表ID
            cpricetariffid = prmTariff.getCpricetariffid();
        }else {
            List<PrmTariff> all = prmTariffService.getAll("1010");
            if (all.isEmpty()) {
                System.out.println("没有价目表");
            }else {
                prmTariff = all.get(0);
                cpricetariffid = prmTariff.getCpricetariffid();
            }
        }

        if (cpricetariffid!=null){
            /*
             * pk_invbasdoc 存货档案主键
             * pk_invmandoc 存货管理档案主键
             * */

            String shiyongjiagexiang = pkTranslateCodeMapper.shiyongjiagexiang("1010");
            String cny = pkTranslateCodeMapper.getCNY();

            List<BdInvmandoc> bdInvmandocs = bdInvmandocMapper.selectByPkCorp("1010");
            for (BdInvmandoc bdInvmandoc : bdInvmandocs) {
                List<IaBillB> iaBillBS = iaBillBMapper.selectByCinvbasid("1010", bdInvmandoc.getPkInvbasdoc(), "2023-01-01", "2025-01-01");
                if (!iaBillBS.isEmpty()) {
                    IaBillB iaBillB = iaBillBS.get(0);
                    System.out.println("存货编码:" + bdInvmandoc.getInvcode() + "价格:" + iaBillB.getNprice());
                    if (iaBillB.getNprice()!=null){
                        PrmTariffcurlist prmTariffcurlist = prmTariffcurlistService.selectByCinv(cpricetariffid, bdInvmandoc.getPkInvbasdoc());
                        if (prmTariffcurlist != null) {
                            System.out.println("已经存在,直接修改数据库");
                            prmTariffcurlistService.updateByCinv(cpricetariffid, bdInvmandoc.getPkInvbasdoc(),iaBillB.getNprice().toString());
                        } else {
                            System.out.println("不存在,调用接口");
                            String jiliangdanwei = pkTranslateCodeMapper.jiliangdanwei(bdInvmandoc.getPkMeasdoc());
                            String json = "{\n" +
                                    "          \"billvo\":  [\n" +
                                    "                    {\n" +
                                    "                              \"childrenvo\":  [\n" +
                                    "                                        {\n" +
                                    "                                                  \"cdefpricetypeid\":  \"01\",\n" +
                                    "                                                  \"cinventoryid\":  \""+bdInvmandoc.getInvcode()+"\",\n" +
                                    "                                                  \"nprice0\":  \""+iaBillB.getNprice().toString()+"\",\n" +
                                    "                                                  \"ccurrencyid\":  \"CNY\",\n" +
                                    "                                                  \"cmeasdocid\":  \""+jiliangdanwei+"\"\n" +
                                    "                                        }\n" +
                                    "                              ],\n" +
                                    "                              \"parentvo\":  {\n" +
                                    "                                        \"cpricetariffcode\":  \"001\",\n" +
                                    "                                        \"cpricetariffname\":  \""+prmTariff.getCpricetariffname()+"\",\n" +
                                    "                                        \"pk_corp\":  \"0101003\"\n" +
                                    "                              }\n" +
                                    "                    }\n" +
                                    "          ]\n" +
                                    "}";
                            System.out.println(json);
                            String tbmimport = this.tbmimport(json);
                            System.out.println(tbmimport);
                        }
                    }



                } else {
                    if (bdInvmandoc.getCostprice()!=null){
                        System.out.println("没有订单存货编码:" + bdInvmandoc.getInvcode() + "价格:" + bdInvmandoc.getCostprice());
                        PrmTariffcurlist prmTariffcurlist = prmTariffcurlistService.selectByCinv(cpricetariffid, bdInvmandoc.getPkInvbasdoc());
                        if (prmTariffcurlist != null) {
                            System.out.println("已经存在,直接修改数据库");
                            prmTariffcurlistService.updateByCinv(cpricetariffid, bdInvmandoc.getPkInvbasdoc(),bdInvmandoc.getCostprice().toString());
                        } else {
                            System.out.println("不存在,调用接口");
                            String jiliangdanwei = pkTranslateCodeMapper.jiliangdanwei(bdInvmandoc.getPkMeasdoc());
                            String json = "{\n" +
                                    "          \"billvo\":  [\n" +
                                    "                    {\n" +
                                    "                              \"childrenvo\":  [\n" +
                                    "                                        {\n" +
                                    "                                                  \"cdefpricetypeid\":  \"01\",\n" +
                                    "                                                  \"cinventoryid\":  \""+bdInvmandoc.getInvcode()+"\",\n" +
                                    "                                                  \"nprice0\":  \""+bdInvmandoc.getCostprice()+"\",\n" +
                                    "                                                  \"ccurrencyid\":  \"CNY\",\n" +
                                    "                                                  \"cmeasdocid\":  \""+jiliangdanwei+"\"\n" +
                                    "                                        }\n" +
                                    "                              ],\n" +
                                    "                              \"parentvo\":  {\n" +
                                    "                                        \"cpricetariffcode\":  \"001\",\n" +
                                    "                                        \"cpricetariffname\":  \""+prmTariff.getCpricetariffname()+"\",\n" +
                                    "                                        \"pk_corp\":  \"0101003\"\n" +
                                    "                              }\n" +
                                    "                    }\n" +
                                    "          ]\n" +
                                    "}";
                            System.out.println(json);
                            String tbmimport = this.tbmimport(json);
                            System.out.println(tbmimport);
                        }
                    }
                }
            }
        }


    }





    private static String tbmimport(String body){
        // 服务器访问地址及端口,例如 http://ip:port
        String serviceUrl = U8CConstant.URL;
        // 服务名,例如   /u8cloud/api/ic/materialout/insert
        String serviceName = "/u8cloud/api/soprice/primtarff/insert";
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
