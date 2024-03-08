package org.jeecg.modules.link.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.jeecg.modules.link.config.Constant;
import org.jeecg.modules.link.entity.DingCallbackCrypto;

import org.jeecg.modules.link.entity.DocTypeLink;
import org.jeecg.modules.link.service.IDocTypeLinkService;
import org.jeecg.modules.link.service.IFukuanLinkService;
import org.jeecg.modules.link.service.IPoOrderLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * E应用回调信息处理
 */
@RestController
public class CallbackController {

    @Autowired
    private IDocTypeLinkService docTypeLinkService;
    @Autowired
    private IPoOrderLinkService poOrderLinkService;
    @Autowired
    private IFukuanLinkService fukuanLinkService;


    private static final Logger bizLogger = LoggerFactory.getLogger("BIZ_CALLBACKCONTROLLER");
    private static final Logger mainLogger = LoggerFactory.getLogger(CallbackController.class);

    /**
     * 创建套件后，验证回调URL创建有效事件（第一次保存回调URL之前）
     */
    private static final String CHECK_URL = "check_url";

    /**
     * 审批任务回调
     */
    private static final String BPMS_TASK_CHANGE = "bpms_task_change";

    /**
     * 审批实例回调
     */
    private static final String BPMS_INSTANCE_CHANGE = "bpms_instance_change";

    /**
     * 相应钉钉回调时的值
     */
    private static final String CALLBACK_RESPONSE_SUCCESS = "success";


    @RequestMapping(value = "/callback/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> callBack(
            @RequestParam(value = "msg_signature", required = false) String msg_signature,
            @RequestParam(value = "timestamp", required = false) String timeStamp,
            @RequestParam(value = "nonce", required = false) String nonce,
            @RequestBody(required = false) JSONObject json) {
        try {
            // 1. 从http请求中获取加解密参数

            // 2. 使用加解密类型
            // Constant.OWNER_KEY 说明：
            // 1、开发者后台配置的订阅事件为应用级事件推送，此时OWNER_KEY为应用的APP_KEY。
            // 2、调用订阅事件接口订阅的事件为企业级事件推送，
            //      此时OWNER_KEY为：企业的appkey（企业内部应用）或SUITE_KEY（三方应用）
            DingCallbackCrypto callbackCrypto = new DingCallbackCrypto(Constant.TOKEN, Constant.ENCODING_AES_KEY, Constant.APPKEY);
            String encryptMsg = json.getString("encrypt");
            String decryptMsg = callbackCrypto.getDecryptMsg(msg_signature, timeStamp, nonce, encryptMsg);

            // 3. 反序列化回调事件json数据
            JSONObject eventJson = JSON.parseObject(decryptMsg);
            String eventType = eventJson.getString("EventType");
            String type = eventJson.getString("type");
            String processInstanceId = eventJson.getString("processInstanceId");
            System.out.println("================================");
            mainLogger.info(decryptMsg);
            System.out.println("=================================");
            // 4. 根据EventType分类处理
            if ("bpms_instance_change".equals(eventType)) {
                if ("start".equals(type)){
                    mainLogger.info("----审批开始----审批流编号:"+processInstanceId);
                }else if("finish".equals(type)){
                    mainLogger.info("----审批关闭----审批流编号:"+processInstanceId);
                    String result = eventJson.getString("result");
                    if ("agree".equals(result)){
                        mainLogger.info("----审批完成----审批流编号:"+processInstanceId);
                        //流程完成所以结束
                        //this.shenhe(processInstanceId);
                    } else {
                        mainLogger.info("----审批拒绝----审批流编号:"+processInstanceId);
                        //修改标注位
                        //this.shenheshibai(processInstanceId);
                    }
                }else if ("terminate".equals(type)) {
                    mainLogger.info("----审批撤回----审批流编号:"+processInstanceId);
                    //this.shenheshibai(processInstanceId);
                }
            }
            // 5. 返回success的加密数据
            Map<String, String> successMap = callbackCrypto.getEncryptedMap("success");
            return successMap;

        } catch (DingCallbackCrypto.DingTalkEncryptException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int shenheshibai(String processInstanceId){
        int i = 0;
        DocTypeLink dingcode = docTypeLinkService.selectDocTypeByDingcode(processInstanceId);
        //判断type不为空
        if (dingcode!=null){
            String type = dingcode.getDoctype();
            if ("01".equals(type)){
                poOrderLinkService.shenheshibai(dingcode.getErpcode());
                i++;
            }else if ("02".equals(type)){
                fukuanLinkService.shenheshibai(dingcode.getErpcode());
                i++;
            }
        }
        return i;
    }


    public int shenhe(String processInstanceId){
        int i = 0;
        DocTypeLink dingcode = docTypeLinkService.selectDocTypeByDingcode(processInstanceId);
        if (dingcode!=null){
            String type = dingcode.getDoctype();
            if ("01".equals(type)){
                poOrderLinkService.shenhe(dingcode.getErpcode());
                i++;
            }else if ("02".equals(type)){
                fukuanLinkService.shenhe(dingcode.getErpcode());
                i++;
            }
        }
        return i;
    }
}
