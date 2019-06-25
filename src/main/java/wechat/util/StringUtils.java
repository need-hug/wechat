package wechat.util;

/** 字符串操作工具类
 * @className: StringUtils
 * @author: need_hug
 * @dateTime: 2019/6/25 15:15
 * @version: 1.0
 */
public class StringUtils {

	/**
	 * 字符串为null返回给定的默认值defaultStr
	 * @param str 指定字符串
	 * @param defaultStr 默认字符串
	 * @return 字符串
	 */
	public static String defaultIfBlank(String str, String defaultStr) {
		return str == null ? defaultStr : str;
	}
}
