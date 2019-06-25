package wechat.exception;

import wechat.bean.StatusCode;
import wechat.util.StringUtils;

/** api响应异常
 * @className: ApiException
 * @author: need_hug
 * @dateTime: 2019/6/25 14:58
 * @version: 1.0
 */
public class ApiException extends UnFillStackException {

	private final StatusCode statusCode;

	public ApiException(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public ApiException(StatusCode statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

	public StatusCode getStatusCode() {
		return this.statusCode;
	}

	@Override
	public String getMessage() {
		return StringUtils.defaultIfBlank(super.getMessage(), statusCode.defaultMsg);
	}


}
