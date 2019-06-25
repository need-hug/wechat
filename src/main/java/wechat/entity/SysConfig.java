package wechat.entity;

/** 系统配置
 * className: SysConfig
 * author: peishuai.li
 * dateTime: 2019/5/16 15:17
 * version: 1.0
 */
public class SysConfig implements java.io.Serializable {

    private static final long serialVersionUID = 360870370239849817L;

    private Integer id;

    private String wxAppId;

    private String wxSecret;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getWxSecret() {
        return wxSecret;
    }

    public void setWxSecret(String wxSecret) {
        this.wxSecret = wxSecret;
    }

}
