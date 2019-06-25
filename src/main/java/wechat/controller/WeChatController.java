package wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wechat.entity.SysConfig;
import wechat.service.SysConfigService;
import wechat.wx.WeChatUtil;

/**
 * className: WeChatController
 * author: peishuai.li
 * dateTime: 2019/6/11 10:40
 * version: 1.0
 */
@RestController
@RequestMapping("/weChat")
public class WeChatController {

    @Autowired
    private SysConfigService sysConfigService;

    @RequestMapping("/getOpenId")
    public Object getOpenId(@RequestParam("code") String code, @RequestParam("appid") String appid) {
        SysConfig sysConfig = sysConfigService.getSysConfig(appid);
        String openid = WeChatUtil.getWxOpenId(code, sysConfig);
        return openid;
    }

}
