package wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wechat.bean.StatusCode;
import wechat.entity.SysConfig;
import wechat.exception.ApiException;
import wechat.wx.WeChatUtil;

/**
 * @className: Demo
 * @author: need_hug
 * @dateTime: 2019/6/25 15:49
 * @version: 1.0
 */
@RestController
@RequestMapping("/demo")
public class Demo {

	@GetMapping("apiException")
	public String test() throws ApiException {
		throw new ApiException(StatusCode.EXPIRED_TOKEN);
	}

	@GetMapping("exception")
	public int testExcetpion() {

		int i = 0;
		int b = i / 0;
		return i/10;
	}

	@GetMapping("getToken")
	public String getToken() {
		SysConfig sysConfig = new SysConfig();
		sysConfig.setWxAppId("wx56ce5ee9a458ceea");
		sysConfig.setWxSecret("fcebf3aaa884ba00207faeb95220ba0e");
		return WeChatUtil.getWhChatAccessToken(sysConfig);
	}

}
