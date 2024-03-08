package org.jeecg.smallTools;

import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.checkerframework.checker.units.qual.A;
import org.jeecg.JeecgSystemApplication;
import org.jeecg.modules.link.config.U8CConstant;
import org.jeecg.modules.link.entity.*;
import org.jeecg.modules.link.mapper.*;
import org.jeecg.modules.link.service.IPoOrderBService;
import org.jeecg.modules.link.service.IPoOrderService;
import org.jeecg.modules.link.service.IPrmTariffService;
import org.jeecg.modules.link.service.IPrmTariffcurlistService;
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
public class DbTest {
    public static final String F_8100000000000_TM = "1010F8100000000000TM";
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
        String cpricetariffid = null;
        //先获取价目表
        PrmTariff by001 = prmTariffService.getBy001("1010");
        //判断by001是否
        if (by001 != null) {
            //获取价目表ID
            cpricetariffid = by001.getCpricetariffid();
        }else {
            List<PrmTariff> all = prmTariffService.getAll("1010");
            if (all.isEmpty()) {
                System.out.println("没有价目表");
            }else {
                PrmTariff prmTariff = all.get(0);
                cpricetariffid = prmTariff.getCpricetariffid();
            }
        }

        if (cpricetariffid!=null){
            /*
             * pk_invbasdoc 存货档案主键
             * pk_invmandoc 存货管理档案主键
             * */
            List<BdInvmandoc> bdInvmandocs = bdInvmandocMapper.selectByPkCorp("1010");
            for (BdInvmandoc bdInvmandoc : bdInvmandocs) {
                List<IaBillB> iaBillBS = iaBillBMapper.selectByCinvbasid("1010", bdInvmandoc.getPkInvbasdoc(), "2023-01-01", "2025-01-01");
                if (!iaBillBS.isEmpty()) {
                    IaBillB iaBillB = iaBillBS.get(0);
                    System.out.println("存货编码:" + bdInvmandoc.getInvcode() + "价格:" + iaBillB.getNprice());
                    PrmTariffcurlist prmTariffcurlist = prmTariffcurlistService.selectByCinv(cpricetariffid, bdInvmandoc.getPkInvbasdoc());
                    if (prmTariffcurlist != null) {
                        System.out.println("已经存在,直接修改数据库");
                    } else {
                        System.out.println("不存在,调用接口");
                    }


                } else {
                    System.out.println("没有订单存货编码:" + bdInvmandoc.getInvcode() + "价格:" + bdInvmandoc.getCostprice());
                    PrmTariffcurlist prmTariffcurlist = prmTariffcurlistService.selectByCinv(cpricetariffid, bdInvmandoc.getPkInvbasdoc());
                    if (prmTariffcurlist != null) {
                        System.out.println("已经存在,直接修改数据库");
                    } else {
                        System.out.println("不存在,调用接口");
                    }

                }
            }
        }


    }

    @Test
    public void testbom() {
        //获取昨天日期和明天日期yyyy-MM-dd输出
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -5);
        Date time = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String zuotian = sdf.format(time);

        calendar.add(Calendar.DATE, 6);
        Date time2 = calendar.getTime();
        String jintian = sdf.format(time2);

        //先查询没同步的入库单  到时候根据设置的 ID查询
        List<VIaInoutledger> vIaInoutledgers = vIaInoutledgerMapper.selectByPkCode("1010", zuotian, jintian);
        List<BdCalbody> bdCalbodies = bdCalbodyMapper.selectByPkCorp("1010");
        BdCalbody bdCalbody = bdCalbodies.get(0);
        for (VIaInoutledger vIaInoutledger : vIaInoutledgers) {
            System.out.println(vIaInoutledger);
            //根据存货档案ID查询BOM表
            List<BomB> bomBS = bomBMapper.selectBywlbmidAndgcbmV2(vIaInoutledger.getCinvbasid(), bdCalbody.getPkCalbody());
            if (bomBS.isEmpty()) {
                System.out.println("没有BOM表");
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
                String s = bdCalbodyMapper.selectStorNumbet(vIaInoutledger.getCbillid());
                parentvo.setCwarehouseid(s);
                //库存组织
                parentvo.setPk_calbody(bdCalbody.getBodycode());
                //公司id
                parentvo.setPk_corp("0101003");

                generalBillVO.setParentvo(parentvo);

                System.out.println(parentvo);


                List<Childrenvo> childrenvos = new ArrayList<>();

                double nnumber = vIaInoutledger.getNnumber();

                for (BomB bomB : bomBS) {
                    //存货 数量
                    Childrenvo childrenvo = new Childrenvo();
                    childrenvo.setCinventoryid(bomB.getInvcode());
                    BigDecimal sl = bomB.getSl();
                    BigDecimal mul = NumberUtil.mul(sl, nnumber);
                    childrenvo.setNoutnum(mul.toString());
                    childrenvos.add(childrenvo);
                    System.out.println(bomB);
                }

                generalBillVO.setChildrenvo(childrenvos);
                u8cVOMaterialout.setGeneralBillVO(Collections.singletonList(generalBillVO));
                String jsonString = JSONObject.toJSONString(u8cVOMaterialout);
                String tbmimport = tbmimport(jsonString);
                System.out.println(tbmimport);
                JSONObject jsonObject1 = JSONObject.parseObject(tbmimport);
                String string = jsonObject1.getString("status");
                if ("success".equals(string)){
                   //同步成功cbillBid
                    syncDocMapper.uptadeSyncStatus(vIaInoutledger.getCbillBid());

                }

            }
        }


    }

    @Test
    public void test2() {
        //获取上上个月的第一天
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -2);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date time = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(time);
        System.out.println(format);

        //获取上个月的最后一天
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        Date time2 = calendar2.getTime();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String format2 = sdf2.format(time2);
        System.out.println(format2);

    }

    @Test
    public void test3() {
        /*List<BomB> bomBS = bomBMapper.selectBywlbmidAndgcbm("0001F81000000000099X", "1010F8100000000000TM", "2024-02-01", "2024-12-31");
        for (BomB bomB : bomBS) {
            System.out.println(bomB);
        }*/
        vIaInoutledgerMapper.selectByPkCode("1010", "2024-02-01", "2024-02-03").forEach(System.out::println);

    }

    @Test
    public void jsonTest() {
        U8cVOMaterialout u8cVOMaterialout = new U8cVOMaterialout();
        GeneralBillVO generalBillVO = new GeneralBillVO();
        Childrenvo childrenvo = new Childrenvo();
        Parentvo parentvo = new Parentvo();
        parentvo.setCoperatorid("15069754111");
        parentvo.setCwarehouseid("CS0000001");
        parentvo.setPk_calbody("01");
        parentvo.setPk_corp("0101003");
        List<Childrenvo> childrenvos = new ArrayList<>();
        childrenvos.add(childrenvo);
        childrenvo.setCinventoryid("B0047-07");
        childrenvo.setNoutnum("10");
        generalBillVO.setChildrenvo(childrenvos);
        generalBillVO.setParentvo(parentvo);
        List<GeneralBillVO> objects = new ArrayList<>();
        objects.add(generalBillVO);
        u8cVOMaterialout.setGeneralBillVO(objects);

        String jsonString = JSONObject.toJSONString(u8cVOMaterialout);
        String tbmimport = tbmimport(jsonString);
        System.out.println(tbmimport);
        System.out.println(jsonString);

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
