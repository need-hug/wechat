package wechat.bean;

import wechat.exception.ApiException;

/** 错误响应实体
 * @className: ErrorBody
 * @author: need_hug
 * @dateTime: 2019/6/25 15:37
 * @version: 1.0
 */
public class ErrorBody {

	public ErrorBody() {
	}

	public ErrorBody(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}


	public Integer code;
	public String msg;

	public ErrorBody(ApiException apiException) {
		this.code = apiException.getStatusCode().code;
		this.msg = apiException.getMessage();
	}

	public ErrorBody(StatusCode statusCode) {
		this.code = statusCode.code;
		this.msg = statusCode.defaultMsg;
	}
}
