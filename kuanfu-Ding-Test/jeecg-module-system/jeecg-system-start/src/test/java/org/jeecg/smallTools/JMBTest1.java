package org.jeecg.smallTools;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = JeecgSystemApplication.class)
public class JMBTest1 {
    @Autowired
    private ILinkPriceListService iLinkPriceListService;
    @Autowired
    private BdInvmandocMapper bdInvmandocMapper;
    @Autowired
    private IaBillBMapper iaBillBMapper;
    @Autowired
    private IPrmTariffService prmTariffService;
    @Autowired
    private IPrmTariffcurlistService prmTariffcurlistService;
    @Autowired
    private PkTranslateCodeMapper pkTranslateCodeMapper;

    @Test
    public void JiaMu() {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        // 获取上个月的年月
        YearMonth lastMonth = YearMonth.from(currentDate.minusMonths(1));
        // 获取上个月的第一天日期
        LocalDate firstDayOfLastMonth = lastMonth.atDay(1);
        // 获取上个月的最后一天日期
        LocalDate lastDayOfLastMonth = lastMonth.atEndOfMonth();
        // 格式化日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedFirstDay = firstDayOfLastMonth.format(formatter);
        String formattedLastDay = lastDayOfLastMonth.format(formatter);

        //log.info("价目表定时任务开始");
        List<LinkPriceList> list = iLinkPriceListService.list();
        if (!list.isEmpty()){
            for (LinkPriceList linkPriceList : list) {
                String corpPk = linkPriceList.getCorpPk();
                String corpCode = linkPriceList.getCorpCode();
                PrmTariff prmTariff = null;
                String cpricetariffid = null;
                //先获取价目表
                prmTariff = prmTariffService.getBy001(corpPk);
                //判断by001是否
                if (prmTariff != null) {
                    //获取价目表ID
                    cpricetariffid = prmTariff.getCpricetariffid();
                }else {
                    List<PrmTariff> all = prmTariffService.getAll(corpPk);
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

//                    String shiyongjiagexiang = pkTranslateCodeMapper.shiyongjiagexiang(corpPk);
//                    String cny = pkTranslateCodeMapper.getCNY();

                    List<BdInvmandoc> bdInvmandocs = bdInvmandocMapper.selectByPkCorp(corpPk);
                    for (BdInvmandoc bdInvmandoc : bdInvmandocs) {
                        List<IaBillB> iaBillBS = iaBillBMapper.selectByCinvbasid(corpPk, bdInvmandoc.getPkInvbasdoc(), formattedFirstDay, formattedLastDay);
                        if (!iaBillBS.isEmpty()) {
                            IaBillB iaBillB = iaBillBS.get(0);
                            System.out.println("存货编码:" + bdInvmandoc.getInvcode() + "价格:" + iaBillB.getNprice());
                            if (iaBillB.getNprice()!=null){
                                BigDecimal nprice = iaBillB.getNprice();
                                if (nprice.compareTo(BigDecimal.ZERO)>0){
                                    PrmTariffcurlist prmTariffcurlist = prmTariffcurlistService.selectByCinv(cpricetariffid, bdInvmandoc.getPkInvbasdoc());
                                    if (prmTariffcurlist != null) {
                                        System.out.println("已经存在,直接修改数据库");
                                        prmTariffcurlistService.updateByCinv(cpricetariffid, bdInvmandoc.getPkInvbasdoc(), nprice.toString());
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
                                                "                                                  \"nprice0\":  \""+ nprice.toString()+"\",\n" +
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



                        } else {
                            if (bdInvmandoc.getCostprice()!=null){
                                BigDecimal costprice = bdInvmandoc.getCostprice();
                                if (costprice.compareTo(BigDecimal.ZERO)>0){
                                    System.out.println("没有订单存货编码:" + bdInvmandoc.getInvcode() + "价格:" + costprice);
                                    PrmTariffcurlist prmTariffcurlist = prmTariffcurlistService.selectByCinv(cpricetariffid, bdInvmandoc.getPkInvbasdoc());
                                    if (prmTariffcurlist != null) {
                                        System.out.println("已经存在,直接修改数据库");
                                        prmTariffcurlistService.updateByCinv(cpricetariffid, bdInvmandoc.getPkInvbasdoc(), costprice.toString());
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
                                                "                                                  \"nprice0\":  \""+ costprice +"\",\n" +
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


            }
        }
        //log.info("价目表定时任务结束");
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
