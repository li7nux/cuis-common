package me.olddriver.cuis.common;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2017-12-29 14:21
 * Description: 基于 joda-time 的时间格式化工具类
 */
public class DateUtils {

    /**
     * 一些常见的日期格式化
     */
    public static final String msf = "yyyyMMddHHmmssSSS";
    public static final String sf = "yyyyMMddHHmmss";
    public static final String mf = "yyyyMMddHHmm";
    public static final String hf = "yyyyMMddHH";
    public static final String df = "yyyyMMdd";
    public static final String Mf = "yyyyMM";
    public static final String yf = "yyyy";

    /**
     * 格式化时间
     *
     * @param date    需要格式化的时间
     * @param pattern 时间格式
     * @return 格式化后的字符串
     */
    public static String formatDate(Date date, String pattern) {
        return new DateTime(date).toString(pattern);
    }

    /**
     * 解析时间字符串
     *
     * @param dateStr 时间字符串
     * @param pattern 相应的格式
     * @return 解析后的Date
     */
    public static Date parseDate(String dateStr, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(pattern);
        return DateTime.parse(dateStr, dateTimeFormatter).toDate();
    }

    /**
     * 日期格式化
     *
     * @param timeMillis 时间戳
     * @param pattern    时间格式
     * @return 格式化后的字符串
     */
    public static String formatDate(long timeMillis, String pattern) {
        DateTime dateTime = new DateTime(timeMillis);
        return dateTime.toString(pattern);
    }

    /**
     * 获取两个时间之间的间隔天数
     *
     * @param start 时间
     * @param end   时间
     * @return 两个时间之间的间隔
     */
    public static int diffDays(Date start, Date end) {
        DateTime s = new DateTime(start);
        DateTime e = new DateTime(end);
        return Days.daysBetween(s, e).getDays();
    }

    /**
     * 增加/减少 天数
     *
     * @param date 时间
     * @param days 增加(正整数)或减少(负整数)的天数
     * @return 增加后的时间
     */
    public static Date addDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        DateTime dt = dateTime.plusDays(days);
        return dt.toDate();
    }

    /**
     * 增加/减少 月
     *
     * @param date   时间
     * @param months 增加(正整数)或减少(负整数)的月
     * @return 增加后的时间
     */
    public static Date addMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        DateTime dt = dateTime.plusMonths(months);
        return dt.toDate();
    }


    /**
     * 创建时间
     *
     * @param year   年
     * @param month  月
     * @param day    日
     * @param hour   时
     * @param minute 分
     * @param second 秒
     * @return 时间
     */
    public static Date createDate(int year, int month, int day, int hour, int minute, int second) {
        DateTime dateTime = new DateTime(year, month, day, hour, minute, second);
        return dateTime.toDate();
    }

}
