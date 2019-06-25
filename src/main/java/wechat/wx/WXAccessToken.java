package wechat.wx;

/** 微信access_token管理实体
 * className: WXBaseToken
 * author: peishuai.li
 * dateTime: 2019/5/16 15:37
 * version: 1.0
 */
public class WXAccessToken {

    private String access_token;
    private String expires;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }
}
