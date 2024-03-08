package org.jeecg;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import org.jeecg.modules.link.utils.AccessTokenUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sample {


    public static void main(String[] args_) throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/create");
        OapiProcessinstanceCreateRequest req = new OapiProcessinstanceCreateRequest();
        req.setAgentId(1963776696L);
        req.setProcessCode("PROC-88B01D83-52A3-42D7-AA0D-65E45143B6B6");
        req.setOriginatorUserId("manager3133");
        req.setDeptId((long) -1);
        req.setCcPosition("FINISH");

        //单行输入框
        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValueVoList = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
        OapiProcessinstanceCreateRequest.FormComponentValueVo formComponentValueVo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        formComponentValueVoList.add(formComponentValueVo);
        formComponentValueVo.setName("单行输入框");
        formComponentValueVo.setValue("测试单行输入框");

        //多行输入框

        OapiProcessinstanceCreateRequest.FormComponentValueVo formComponentValueVo1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        formComponentValueVoList.add(formComponentValueVo1);
        formComponentValueVo1.setName("单选框");
        formComponentValueVo1.setValue("选项3");

        OapiProcessinstanceCreateRequest.FormComponentValueVo formComponentValueVo12 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        OapiProcessinstanceCreateRequest.FormComponentValueVo Item1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        Item1.setName("测试1");
        Item1.setValue("测试1");
        OapiProcessinstanceCreateRequest.FormComponentValueVo Item2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        Item2.setName("测试2");
        Item2.setValue("测试2");
        OapiProcessinstanceCreateRequest.FormComponentValueVo Item3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        Item3.setName("测试3");
        Item3.setValue("测试3");


        OapiProcessinstanceCreateRequest.FormComponentValueVo formComponentValueVo13 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        OapiProcessinstanceCreateRequest.FormComponentValueVo Item4 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        Item4.setName("测试1");
        Item4.setValue("测试4");
        OapiProcessinstanceCreateRequest.FormComponentValueVo Item5 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        Item5.setName("测试2");
        Item5.setValue("测试2");
        OapiProcessinstanceCreateRequest.FormComponentValueVo Item6 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        Item6.setName("测试3");
        Item6.setValue("测试3");

        formComponentValueVo12.setName("表格");
        String jsonString = JSON.toJSONString(Arrays.asList(Arrays.asList(Item1, Item2, Item3), Arrays.asList(Item1, Item2, Item3)));
        System.out.println(jsonString);
        formComponentValueVo12.setValue(jsonString);
        formComponentValueVoList.add(formComponentValueVo12);





        String token = AccessTokenUtil.getToken();
        req.setFormComponentValues(formComponentValueVoList);
        OapiProcessinstanceCreateResponse rsp = client.execute(req, token);
        System.out.println(JSON.toJSONString(rsp));
    }
}