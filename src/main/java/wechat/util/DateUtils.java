package wechat.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 时间工具类
 * className: DateUtils
 * author: peishuai.li
 * dateTime: 2019/5/16 15:45
 * version: 1.0
 */
public class DateUtils {

    /**
     * 获取当前时间
     * @return 当天时间
     */
    public static Date currentTime() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }

    /**
     * 获取date前后amount小时的时间
     * @param date 时间
     * @param amount 数量
     * @return 增加或减少之后的时间
     */
    public static Date addHour(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, amount);
        return c.getTime();
    }

    /**
     * 时间转换成字符串
     * @param date 需转换的时间
     * @param pattern 转换规则
     * @return 转换后的字符串
     */
    public static String date2Str(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void main(String[] args) {

        System.out.println(date2Str(addHour(currentTime(), 2), "yyyy-MM-dd HH:mm:ss"));
        System.out.println(String.valueOf(DateUtils.addHour(new Date(), 2).getTime()));
    }
}
