package wechat.exception;

/** 业务异常
 * @className: UnFillStackException
 * @author: need_hug
 * @dateTime: 2019/6/25 14:53
 * @version: 1.0
 */
public class UnFillStackException extends Exception {

	public UnFillStackException() {
		this(null, null);
	}

	public UnFillStackException(String message) {
		this(message, null);
	}

	/**
	 * super()后两个参数设置为false，不调用fillInStackTrace()方法和不添加suppressException
	 * 目的:只关注错误信息，并不在意栈轨迹，禁用他们来提高性能
	 * @param message
	 * @param cause
	 */
	public UnFillStackException(String message, Throwable cause) {
		super(message, cause, false, false);
	}

	public UnFillStackException(Throwable cause) {
		this(null, cause);
	}

}
