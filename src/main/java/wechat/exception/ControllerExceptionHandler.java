package wechat.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import wechat.bean.ErrorBody;
import wechat.bean.StatusCode;

/** 统一的全局异常处理
 * @className: ControllerExceptionHandler
 * @author: need_hug
 * @dateTime: 2019/6/25 15:32
 * @version: 1.0
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

	public static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorBody> handleBusinessException(ApiException apiException){
		return ResponseEntity.status(apiException.getStatusCode().getHttpStatusCode())
				.body(new ErrorBody(apiException));
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorBody handleUnknownException(Exception e){
		log.error("服务器未知异常",e);
		return new ErrorBody(StatusCode.ERROR);
	}
}
