package wechat.util;

import java.util.Base64;

/** 加密工具类
 * @className: EncryptionUtils
 * @author: need_hug
 * @dateTime: 2019/6/25 16:30
 * @version: 1.0
 */
public class EncryptionUtils {

	/**
	 * base64加密
	 * @param str 待加密字符串
	 * @return 加密后字符串
	 */
	public static String base64Encoder(String str) {
		if (str == null) {
			return null;
		}
		return new String(Base64.getEncoder().encode(str.getBytes()));
	}

	/**
	 * base64解密
	 * @param str 待解密字符串
	 * @return 解密后的字符串
	 */
	public static String base64Decoder(String str) {
		if (str == null) {
			return null;
		}
		return new String(Base64.getDecoder().decode(str.getBytes()));
	}
}
