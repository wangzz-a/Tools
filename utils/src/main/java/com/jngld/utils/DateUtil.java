package com.jngld.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author wangzz-a
 * @version $Id: DateUtil.java, v 0.1 2015年11月25日 下午2:23:50 wangzz-a Exp $
 */
public abstract class DateUtil {

    /**
     * 私有构造函数
     */
    private DateUtil() {
    }

    /**
     * 完整时间 yyyy-MM-dd HH:mm:ss
     */
    public static final String simple = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年月日时分秒  yyyyMMddHHmmss
     */
    public static final String dtLong = "yyyyMMddHHmmss";

    /**
     * 年-月-日 小时:分钟 yyyy-MM-dd HH:mm
     */
    public static final String simpleFormat = "yyyy-MM-dd HH:mm";

    /**
     * 年月日时分 yyyyMMddHHmm
     */
    public static final String dtMiddle = "yyyyMMddHHmm";

    /**
     * 年-月-日 yyyy-MM-dd
     */
    public static final String dtSimple = "yyyy-MM-dd";

    /**
     * 年月日 yyyyMMdd
     */
    public static final String dtShort = "yyyyMMdd";

    /**
     * 年-月  yyyy-MM
     */
    public static final String yMFormat = "yyyy-MM";

    /**
     * 年月  yyyyMM
     */
    public static final String yMShort = "yyyyMM";

    /**
     * 时分秒 HH:mm:ss
     */
    public static final String hmsFormat = "HH:mm:ss";

    /**
     * 时分 HH:mm
     */
    public static final String hmFormat = "HHmm";

    /**
     * yyyy年MM月dd日 HH:mm:ss
     */
    public static final String dtSimpleChineseWithTime = "yyyy年MM月dd日 HH:mm:ss";

    /**
     * yyyy年MM月dd日
     */
    public static final String dtSimpleChinese = "yyyy年MM月dd日";

    public static final String WEEK = "EEEE";
    public static final String YEAR = "YEAR";
    public static final String MONTH = "MONTH";
    public static final String DAY = "DAY";
    public static final String QUARTER = "QUARTER";

    //日期
    public static final int YEAR_Z = Calendar.YEAR; //年
    public static final int MONTH_Z = Calendar.MONTH; //月
    public static final int DATE_Z = Calendar.DATE; //日
    //时间
    public static final int HOUR_Z = Calendar.HOUR_OF_DAY; //24小时制，小时
    public static final int MINUTE_Z = Calendar.MINUTE; //分钟
    public static final int SECOND_Z = Calendar.SECOND; //秒
    //周
    public static final int WEEK_OF_YEAR_Z = Calendar.WEEK_OF_YEAR; //当前日期是当前年的第几周
    public static final int WEEK_OF_MONTH_Z = Calendar.WEEK_OF_MONTH; //当前日期是这个月的第几周
    //天
    public static final int DAY_OF_YEAR_Z = Calendar.DAY_OF_YEAR; //获得这个年的第几天 从1开始
    public static final int DAY_OF_MONTH_Z = Calendar.DAY_OF_MONTH; //获得这个月的第几天 从1开始
    public static final int DAY_OF_WEEK_Z = Calendar.DAY_OF_WEEK; //获得这个星期的第几天


    /**
     * 获取日期格式化工具类
     * @param format 日期格式
     * @return DateFormat
     * @author wangzz-a
     * @date 2015年11月26日 上午9:52:38
     */
    public static final DateFormat getFormat(String format) {
        if (format == null) {
            throw new IllegalArgumentException("The format must not be null");
        }
        return new SimpleDateFormat(format);
    }

    /**
     * 日期--->字符串<br>
     * 默认使用yyyy-MM-dd HH:mm:ss
     * @param date 日期
     * @return String 日期的字符串表现形式
     * @author wangzz-a
     * @date 2015年11月26日 上午9:53:11
     */
    public static final String dateToStr(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return getFormat(simple).format(date);
    }

    /**
     * 日期--->字符串
     * @param date 日期
     * @param format 日期格式
     * @return String 日期的字符串表现形式
     * @author wangzz-a
     * @date 2015年11月26日 上午9:54:12
     */
    public static final String dateToStr(Date date, String format) {
        if (date == null || format == null) {
            throw new IllegalArgumentException("The date and format must not be null");
        }
        return getFormat(format).format(date);
    }

    /**
     * 字符串--->日期
     * @param strDate 日期字符
     * @param format 日期字符的格式
     * @return java.util.Date
     * @throws ParseException
     * @author wangzz-a
     * @date 2015年11月26日 上午9:30:11
     */
    public static final Date strToUtilDate(String strDate, String format) throws ParseException {

        if (strDate == null || format == null) {
            throw new IllegalArgumentException("The strDate or format must not be null");
        }

        try {
            return getFormat(format).parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ParseException("strDate:" + strDate + " format:" + format, 124);
        }
    }

    /**
     * 字符串--->日期
     * @param strDate 日期字符
     * @param format 日期字符的格式
     * @return java.sql.Date
     * @throws ParseException
     * @author wangzz-a
     * @date 2015年11月26日 上午9:30:11
     */
    public static final java.sql.Date strToSqlDate(String strDate, String format) throws ParseException {

        if (strDate == null || format == null) {
            throw new IllegalArgumentException("The strDate or format must not be null");
        }

        try {
            return new java.sql.Date(strToUtilDate(strDate, format).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ParseException("strDate:" + strDate + " format:" + format, 147);
        }
    }

    /**
     * java.util.Date--->java.sql.Date
     * @param date 日期 java.util.Date
     * @return java.sql.Date
     * @throws ParseException
     * @author wangzz-a
     * @date 2015年11月26日 上午9:30:11
     */
    public static final java.sql.Date utilDateToSqlDate(Date date) throws ParseException {

        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }

        return new java.sql.Date(date.getTime());

    }

    /**
     * java.sql.Date--->java.util.Date
     * @param date 日期 java.sql.Date
     * @return java.util.Date
     * @throws ParseException
     * @author wangzz-a
     * @date 2015年11月26日 上午9:30:11
     */
    public static final Date sqlDateToTtilDate(java.sql.Date date) throws ParseException {

        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }

        return new Date(date.getTime());

    }


    /**
     * 当前所属年份是否为闰年
     * @return boolean
     * @author wangzz-a
     * @date 2015年11月26日 上午10:00:50
     */
    public static final boolean isLeapYear() {
        Calendar c = Calendar.getInstance();
        return isLeapYear(c.get(Calendar.YEAR));
    }

    /**
     * 传入日期是否为闰年
     * @param date 日期
     * @return boolean
     * @author wangzz-a
     * @date 2015年11月26日 上午10:01:48
     */
    public static final boolean isLeapYear(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return isLeapYear(c.get(Calendar.YEAR));
    }

    /**
     * 传入年份是否为闰年
     * @param year 年
     * @return boolean
     * @author wangzz-a
     * @date 2015年11月26日 上午10:02:24
     */
    public static final boolean isLeapYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("The year must be greater than zero");
        }
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * 计算两个日期相差的天数
     * @param date1
     * @param date2
     * @return long
     * @author wangzz-a
     * @date 2015年11月26日 上午10:03:08
     */
    public static long getOffsetDays(Date date1, Date date2) {

        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }

        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.set(Calendar.MINUTE, 0);
        c2.set(Calendar.SECOND, 0);
        return Math.abs(c1.getTimeInMillis() - c2.getTimeInMillis()) / (1000 * 60 * 60 * 24);
    }

    /**
     * 根据类别加减日期（年、月、日）
     * @param date 日期
     * @param field （DateUtil.YEAR; DateUtil.MONTH; DateUtil.DAY;）
     * @param index 需要加减的天数，可以为负数，负数为减
     * @return Date
     * @author wangzz-a
     * @date 2015年11月26日 上午10:04:05
     */
    public static final Date addField(Date date, String field, int index) {
        if (date == null || field == null) {
            throw new IllegalArgumentException("The date and field must not be null");
        }
        if (YEAR.equals(field))
            return addYear(date, index);
        if (MONTH.equals(field))
            return addMonth(date, index);
        if (DAY.equals(field))
            return addDay(date, index);
        return date;
    }

    /**
     * 加减年
     * @param date 日期
     * @param year 需要加减的年数
     * @return Date
     * @author wangzz-a
     * @date 2015年11月26日 上午10:04:50
     */
    public static final Date addYear(Date date, int year) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, year);
        return cal.getTime();
    }

    /**
     * 加减月份
     * @param date 日期
     * @param month 需要加减的月数
     * @return Date
     * @author wangzz-a
     * @date 2015年11月26日 上午10:04:50
     */
    public static final Date addMonth(Date date, int month) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

    /**
     * 加减天数
     * @param date 日期
     * @param days 需要加减的天数
     * @return Date
     * @author wangzz-a
     * @date 2015年11月26日 上午10:04:50
     */
    public static final Date addDay(Date date, int days) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    /**
     * 根据传入类型 获取当前时间所属的年、月份、季度等
     * @param field 传入类型（YEAR，MONTH，DAY，QUARTER）
     * @return int
     * @author wangzz-a
     * @date 2015年11月26日 上午10:07:58
     */
    public static final int getField(String field) {
        if (field == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        Calendar cld = Calendar.getInstance();
        if (YEAR.equals(field)) {
            return cld.get(Calendar.YEAR);
        }
        if (MONTH.equals(field)) {
            return cld.get(Calendar.MONTH) + 1;
        }
        if (DAY.equals(field)) {
            return cld.get(Calendar.DAY_OF_MONTH);
        }
        if (QUARTER.equals(field)) {
            return (cld.get(Calendar.MONTH) / 3) + 1;
        }
        return 0;
    }

    /**
     * 获取传入日期和类别所属的年、月份、季度等
     * @param date 日期
     * @param field 传入类型（YEAR，MONTH，DAY，QUARTER）
     * @return int
     * @author wangzz-a
     * @date 2015年11月26日 上午10:10:46
     */
    public static final int getField(Date date, String field) {
        if (date == null || field == null) {
            throw new IllegalArgumentException("The date and field must not be null");
        }
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        if (YEAR.equals(field)) {
            return cld.get(Calendar.YEAR);
        }
        if (MONTH.equals(field)) {
            return cld.get(Calendar.MONTH) + 1;
        }
        if (DAY.equals(field)) {
            return cld.get(Calendar.DAY_OF_MONTH);
        }
        if (QUARTER.equals(field)) {
            return (cld.get(Calendar.MONTH) / 3) + 1;
        }
        return 0;
    }

    /**
     * 当前日期月份的最大天数
     * @return int
     * @author wangzz-a
     * @date 2015年11月26日 上午10:11:56
     */
    public static final int getMaxDay() {
        int maxDay = 0;
        Calendar calendar = Calendar.getInstance();
        maxDay = calendar.getActualMaximum(Calendar.DATE);
        return maxDay;
    }

    /**
     * 传入日期月份的最大天数
     * @param date 日期
     * @return int
     * @author wangzz-a
     * @date 2015年11月26日 上午10:12:17
     */
    public static final int getMaxDay(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        int maxDay = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        maxDay = calendar.getActualMaximum(Calendar.DATE);
        return maxDay;
    }

    /**
     * 获取某年某月的天数
     * @param year 年
     * @param month 月
     * @return int
     * @author wangzz-a
     * @date 2015年11月26日 上午10:12:52
     */
    public static final int getMaxDay(int year, int month) {
        if (year <= 0 || month <= 0) {
            throw new IllegalArgumentException("The year and month must be greater than zero");
        }
        int maxDay = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        maxDay = calendar.getActualMaximum(Calendar.DATE);
        return maxDay;
    }

    /**
     * 根据时间戳计算总时长
     * @param millisecond
     * @return String
     * @author wangzz-a
     * @date 2015年11月26日 上午10:13:22
     */
    public static final String getDuration(long millisecond) {
        if (millisecond <= 0) {
            throw new IllegalArgumentException("The millisecond must be greater than zero");
        }
        long hour = 0;
        long minute = 0;
        long second = 0;
        String hourUnit = "小时";
        String minuteUnit = "分钟";
        String secondUnit = "秒";
        String millisecondUnit = "毫秒";
        if (millisecond < 0)
            return "0秒";
        if (millisecond < 1000)
            return millisecond + millisecondUnit;
        second = millisecond / 1000;
        StringBuilder sb = new StringBuilder();

        if (second >= 3600) {
            hour = second / 3600;
            second = second % 3600;
            sb.append(hour + hourUnit);
        }
        if (second >= 60) {
            minute = second / 60;
            second = second % 60;
            sb.append(minute + minuteUnit);
        }
        sb.append(second + secondUnit);
        return sb.toString();
    }

    /**
     * date1比date2大返回1，相等返回0，date1小于date2返回-1
     * @param date1
     * @param date2 如：
     * date1： 2016-01-01
     * date2：2016-02-02
     * compare(date1,date2) : return -1
     * @return int
     * @author wangzz-a
     * @date 2016年10月8日19:22:31
     */
    public static final int compareTo(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);
        return calendar1.compareTo(calendar2);
    }

    /**
     * 获取Calendar对象
     * @param date
     * @return
     */
    public static final Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 获取Calendar对象
     * @return
     */
    public static final Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }

    public static void main(String[] args) throws ParseException {

        Calendar calendar = getCalendar();

    }
}
