package wechat.bean;

/** 状态码
 * @className: StatusCode
 * @author: need_hug
 * @dateTime: 2019/6/25 14:59
 * @version: 1.0
 */
public enum StatusCode {

	SUCCESS(200000, "成功！"),
	FAIL(404000, "失败！"),
	ERROR(500000, "服务器异常"),

	//授权异常
	DISABLE_ACCOUNT(401001, "账户已被冻结"),
	INVALID_TOKEN(401002, "无效的身份凭证"),
	EXPIRED_TOKEN(401003, "身份凭证已过期"),
	NO_PERMISSION(401004, "无权限进行该操作"),
	BAD_CREDENTIALS(401005, "密码错误"),

	ILLEGAL_OPERATION(400001, "非法操作"),

	NOT_FOUND(404001,"访问的资源不存在"),

	INVALID_PARAM(422001, "参数无效");

	public final int code;
	public final String defaultMsg;

	StatusCode(int code, String defaultMsg) {
		this.code = code;
		this.defaultMsg = defaultMsg;
	}

	/**
	 * 转换为http错误码
	 * @param statusCode 状态码
	 * @return http 错误码
	 */
	public static int convertToHttpStatus(StatusCode statusCode) {
		return statusCode.code / 1000;
	}

	/**
	 * 转换为http错误码
	 * @param code
	 * @return
	 */
	public static int convertToHttpStatus(int code) {
		return convertToHttpStatus(valueOf(code));
	}

	/**
	 * 获得http错误码
	 * @return
	 */
	public int getHttpStatusCode(){
		return convertToHttpStatus(this);
	}

	/**
	 * 根据code获取状态码对象
	 * @param code 错误码
	 * @return 状态码
	 */
	public static StatusCode valueOf(int code) {
		for (StatusCode value : StatusCode.values()) {
			if (value.code == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("没有符合'" + code + "'的StatusCode");
	}
}
