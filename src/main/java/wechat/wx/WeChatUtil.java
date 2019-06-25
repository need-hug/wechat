package wechat.wx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wechat.entity.SysConfig;
import wechat.util.DateUtils;
import wechat.util.HttpUtils;
import wechat.util.JsonUtils;
import wechat.util.RedisUtils;

import java.util.Date;
import java.util.Map;

/** 微信公众平台操作工具类
 * className: WeChatUtil
 * author: peishuai.li
 * dateTime: 2019/5/16 14:45
 * version: 1.0
 */
public class WeChatUtil {

    private static final Logger log = LoggerFactory.getLogger(WeChatUtil.class);

    /**
     * 获取微信accessToken
     * @param sysConfig 系统配置
     * @return 微信access_token
     */
    public static String getWhChatAccessToken(SysConfig sysConfig) {
        WXAccessToken token =  RedisUtils.getObj(WeChatConfig.getAccessTokenRedisKey(sysConfig.getWxAppId()), WXAccessToken.class);

        long now = System.currentTimeMillis();
        if (null == token || now > Long.valueOf(token.getExpires())) {
            return refreshAccessToken(sysConfig);
        }
        return token.getAccess_token();
    }

    /**
     * 刷新缓存中的access_token
     * @param sysConfig 系统配置
     * @return
     */
    private static String refreshAccessToken(SysConfig sysConfig) {
        try {
            WXAccessToken wxAccessToken = new WXAccessToken();
            String expires = String.valueOf(DateUtils.addHour(new Date(), 2).getTime());
            wxAccessToken.setExpires(expires);

            String url = WeChatConfig.ACCESS_TOKEN_URL
                    .replace("APPID", sysConfig.getWxAppId())
                    .replace("APPSECRET", sysConfig.getWxSecret());
            String msg = HttpUtils.sendGetHttp(url);

            Map map = JsonUtils.str2Obj(msg, Map.class);
            String access_token = (String) map.get("access_token");
            wxAccessToken.setAccess_token(access_token);
            RedisUtils.set(WeChatConfig.getAccessTokenRedisKey(sysConfig.getWxAppId()), wxAccessToken);
            return access_token;
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }

    /**
     * 获取jsapi_ticket
     * @param access_token access_token
     * @param sysConfig 系统配置
     * @return jsapi_ticket
     */
    public static String getjsapiTicket(String access_token, SysConfig sysConfig) {
        WXJSTicket wxjsTicket = RedisUtils.getObj(WeChatConfig.getJsapiTicketRedisKey(sysConfig.getWxAppId()), WXJSTicket.class);
        long now = System.currentTimeMillis();
        if (null == wxjsTicket || now > Long.valueOf(wxjsTicket.getExpires())) {
            return refreshJsapiTicket(access_token, sysConfig);
        }
        return wxjsTicket.getTicket();
    }

    /**
     * 刷新jsapi_ticket
     * @param access_token access_token
     * @param sysConfig 系统配置
     * @return jsapi_ticket
     */
    private static String refreshJsapiTicket(String access_token, SysConfig sysConfig) {
        try {
            WXJSTicket wxjsTicket = new WXJSTicket();
            String expires = String.valueOf(DateUtils.addHour(new Date(), 2).getTime());
            wxjsTicket.setExpires(expires);

            String url = WeChatConfig.JSAPI_TICKET_URL.replace("ACCESS_TOKEN", access_token);
            String msg = HttpUtils.sendGetHttp(url);

            Map map = JsonUtils.str2Obj(msg, Map.class);
            String ticket = (String) map.get("ticket");
            wxjsTicket.setTicket(ticket);
            RedisUtils.set(WeChatConfig.getJsapiTicketRedisKey(sysConfig.getWxAppId()), wxjsTicket);
            return ticket;
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }

    public static String getWxOpenId(String code, SysConfig sysConfig) {
        try {
            String url = WeChatConfig.WX_OPENID_URL
                    .replace("APPID", sysConfig.getWxAppId())
                    .replace("SECRET", sysConfig.getWxSecret())
                    .replace("CODE", code);
            log.info(url);
            String msg = HttpUtils.sendGetHttp(url);
            /*
            * access_token	网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
            * expires_in	access_token接口调用凭证超时时间，单位（秒）
            * refresh_token	用户刷新access_token
            * openid	用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
             * scope	用户授权的作用域，使用逗号（,）分隔
             */
            System.out.println("msg:"+msg);
            log.info("获取openid接口响应" + msg);
            Map map = JsonUtils.str2Obj(msg, Map.class);
            String openid = (String) map.get("openid");

            return openid;
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }
}
