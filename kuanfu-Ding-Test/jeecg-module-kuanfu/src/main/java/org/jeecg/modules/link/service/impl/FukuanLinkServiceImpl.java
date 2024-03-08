package org.jeecg.modules.link.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.checkerframework.checker.units.qual.A;
import org.jeecg.modules.link.config.U8CConstant;
import org.jeecg.modules.link.entity.*;
import org.jeecg.modules.link.mapper.*;
import org.jeecg.modules.link.service.IFukuanLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 付款单同步
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Service
public class FukuanLinkServiceImpl extends ServiceImpl<FukuanLinkMapper, FukuanLink> implements IFukuanLinkService {
    @Autowired
    private FukuanLinkMapper fukuanLinkMapper;
    @Autowired
    private ArapDjzbMapper arapDjzbMapper;
    @Autowired
    private BdCorpMapper bdCorpMapper;


    @Override
    public int shenheshibai(String id) {
        ArapDjzb arapDjzb = arapDjzbMapper.selectById(id);

        return fukuanLinkMapper.update(new FukuanLink().setState("2").setTlastmaketime(arapDjzb.getTs()),
                new QueryWrapper<FukuanLink>().eq("erpcode",id));

    }

    @Override
    public int shenhe(String id) {

        String userId = arapDjzbMapper.getUserId(id);

        ArapDjzb arapDjzb = arapDjzbMapper.selectById(id);
        BdCorp coprPkByCode = bdCorpMapper.getCoprByPk(arapDjzb.getDwbm());
        String pk_corp = coprPkByCode.getUnitcode();
        //获取今天日期Yyyy-dd-mm输出
        // 获取今天日期
        LocalDate today = LocalDate.now();
        // 定义日期格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 格式化日期并输出
        String formattedDate = today.format(formatter);
        String json = "{\"bills\":[{\"djbh\":\""+arapDjzb.getDjbh()+"\",\"dwbm\":\""+pk_corp+"\",\"operatedate\":\""+formattedDate+"\",\"operatorid\":\""+userId+"\"}]}";
        //String json = "{\"bills\":[{\"djbh\":\""+arapDjzb.getDjbh()+"\",\"dwbm\":\""+pk_corp+"\",\"operatedate\":\"2024-03-01\",\"operatorid\":\"15069754111\"}]}";

        System.out.println(json);
        String tbmimport = this.tbmimport(json);
        System.out.println(tbmimport);
        return 0;
    }

    @Override
    public int delByErpId(String erpId) {
        return fukuanLinkMapper.delete(new QueryWrapper<FukuanLink>().eq("erpcode",erpId));

    }

    private static String tbmimport(String body){
        // 服务器访问地址及端口,例如 http://ip:port
        String serviceUrl = U8CConstant.URL;
        // 服务名,例如   /u8cloud/api/ic/materialout/insert
        String serviceName = "/u8cloud/api/arap/fk/audit";
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
