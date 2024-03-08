package org.jeecg.modules.link.config;

/**
 * 项目中的常量定义类
 */
public class Constant {
    /**
     * 企业corpid, 需要修改成开发者所在企业
     */
    public static final String CORP_ID = "ding84ef1642f5c70c37";
    /**
     * 应用的AppKey，登录开发者后台，点击应用管理，进入应用详情可见
     */
    public static final String APPKEY = "ding2rhnailnejlm4qdc";
    /**
     * 应用的AppSecret，登录开发者后台，点击应用管理，进入应用详情可见
     */
    public static final String APPSECRET = "gzqTMZxOKcHtvi4EKLZHX3NIRMH0cH9n7BkESYnuTm4k3sYv4tHgizwv6HqxPfYq";

    /**
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成
     */
    public static final String ENCODING_AES_KEY = "9OSzwGcfax42NzagTXfIXlycLhiFyteQlShIRLNWGLK";

    /**
     * 加解密需要用到的token，企业可以随机填写。如 "12345"
     */
    public static final String TOKEN = "RVIQ5F97LSWunm";

    /**
     * 应用的agentdId，登录开发者后台可查看
     */
    public static final Long AGENTID = 1968639597L;

    /**
     * 审批模板唯一标识，可以在审批管理后台找到
     */
    public static final String PROCESS_CODE = "PROC-39646F85-EA50-4616-96AF-04044BB6560B";

    /**
     * 回调host
     */
    public static final String CALLBACK_URL_HOST = "http://ymhgcx.natappfree.cc/jeecg-boot/callback";
}
