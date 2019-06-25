package wechat.wx;

/** 微信JSTicket对应实体类
 * className: WXJSTicket
 * author: peishuai.li
 * dateTime: 2019/5/16 15:38
 * version: 1.0
 */
public class WXJSTicket {

    private String ticket;
    private String expires;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getExpires() {
        return expires;
    }
    public void setExpires(String expires) {
        this.expires = expires;
    }
}
