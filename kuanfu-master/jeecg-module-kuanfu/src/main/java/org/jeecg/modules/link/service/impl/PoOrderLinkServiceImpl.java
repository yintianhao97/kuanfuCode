package org.jeecg.modules.link.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.j2objc.annotations.AutoreleasePool;
import lombok.extern.java.Log;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.checkerframework.checker.units.qual.A;
import org.jeecg.modules.link.config.U8CConstant;
import org.jeecg.modules.link.entity.BdCorp;
import org.jeecg.modules.link.entity.PoOrder;
import org.jeecg.modules.link.entity.PoOrderLink;
import org.jeecg.modules.link.mapper.BdCorpMapper;
import org.jeecg.modules.link.mapper.PoOrderLinkMapper;
import org.jeecg.modules.link.mapper.PoOrderMapper;
import org.jeecg.modules.link.service.IBdCorpService;
import org.jeecg.modules.link.service.IPoOrderLinkService;
import org.jeecg.modules.link.service.IPoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 采购订单同步记录
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */

@Service
public class PoOrderLinkServiceImpl extends ServiceImpl<PoOrderLinkMapper, PoOrderLink> implements IPoOrderLinkService {
    @Autowired
    private PoOrderLinkMapper poOrderLinkMapper;
    @Autowired
    private PoOrderMapper poOrderMapper;
    @Autowired
    private BdCorpMapper bdCorpMapper;

    @Override
    public int syncSave(PoOrderLink poOrderLink) {
        return poOrderLinkMapper.insert(poOrderLink);
    }

    @Override
    public int shenheshibai(String id) {
        PoOrder poOrder = poOrderMapper.selectById(id);

        return poOrderLinkMapper.update(new PoOrderLink().setState("2").setTlastmaketime(poOrder.getTlastmaketime()),
                new QueryWrapper<PoOrderLink>().eq("erpcode",id));

    }

    @Override
    public int shenhe(String id) {
        PoOrderLink erpcode = poOrderLinkMapper.selectOne(new QueryWrapper<PoOrderLink>().eq("erpcode", id));
        String userCode = poOrderMapper.getUserCode(id);
        String corp = erpcode.getCorp();
        BdCorp coprPkByCode = bdCorpMapper.getCoprByPk(corp);
        String pk_corp = coprPkByCode.getUnitcode();
        String erpcode2 = erpcode.getErpcode2();
        String json = "{\"approveinfo\":{\"approvid\":\""+userCode+"\"},\"queryinfo\":{\"code\":\""+erpcode2+"\",\"corp\":\""+pk_corp+"\",\"date_begin\":\"2022-02-27\",\"date_end\":\"2055-02-27\"}}";
        System.out.println(json);
        String tbmimport = this.tbmimport(json);
        System.out.println(tbmimport);
        return 0;
    }

    @Override
    public int delByErpId(String erpId) {
        return poOrderLinkMapper.delete(new QueryWrapper<PoOrderLink>().eq("erpcode",erpId));
    }

    private static String tbmimport(String body){
        // 服务器访问地址及端口,例如 http://ip:port
        String serviceUrl = U8CConstant.URL;
        // 服务名,例如   /u8cloud/api/ic/materialout/insert
        String serviceName = "/u8cloud/api/pu/order/approve";
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
