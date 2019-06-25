package wechat.wx;

/** 微信平台常量配置
 * className: WeChatConfig
 * author: peishuai.li
 * dateTime: 2019/5/16 14:29
 * version: 1.0
 */
public class WeChatConfig {

    /**
     * 公众号和小程序均可以使用AppID和AppSecret调用本接口来获取access_token
     */
    public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /** jsapi_ticket*/
    public static String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

    /** 微信公众号获取openid */
    public static String WX_OPENID_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    /**  微信公众号获取UnionID */
    public static String WX_UnionID_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    /** access_token在redis中的key */
    public static String ACCESS_TOKEN_REDIS_KEY = "access_token_APPID";
    /** 获取access_token在redis中的key */
    public static String getAccessTokenRedisKey(String appid) {
        return WeChatConfig.ACCESS_TOKEN_REDIS_KEY.replace("APPID", appid);
    }

    /** jsapi_ticket在redis中的key*/
    public static String JSAPI_TICKET_REDIS_KEY = "jsapi_ticket_APPID";
    /** 获取jsapi_ticket在redis中的key */
    public static String getJsapiTicketRedisKey(String appid) {
        return WeChatConfig.JSAPI_TICKET_REDIS_KEY.replace("APPID", appid);
    }

    /**  微信小程序获取openid */
    public static String MINIAPP_GET_OPENID = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    /**
     * 微信小程序appid
     */
    public static String MINIAPP_APPID = "";

    /**
     * 微信小程序secret
     */
    public static String MINIAPP_SECRET = "";


}
