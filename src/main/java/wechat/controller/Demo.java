package wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wechat.bean.StatusCode;
import wechat.exception.ApiException;

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

}
