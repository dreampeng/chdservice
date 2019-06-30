package com.apesing.chd.util;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    private static String defaultDateFormat = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间的时间戳
     *
     * @return
     */
    public static long getTimestampLong() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 时间转换
     *
     * @param time       时间
     * @param dateformat 格式
     * @return date
     */
    public static Date parseTime(String time, String dateformat) {
        if (dateformat == null || StringUtil.isEmpty(dateformat)) {
            dateformat = defaultDateFormat;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        try {
            return sdf.parse(time);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取星期的数字  1是周日 2是周一 .... 7是周六
     *
     * @param date 时间
     * @return int
     */
    public static int getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取星期几
     *
     * @param date
     * @return
     */
    public static String getWeekStr(Date date) {
        int week = getWeek(date);
        String weekStr = "";
        /*星期日:Calendar.SUNDAY=1
         *星期一:Calendar.MONDAY=2
         *星期二:Calendar.TUESDAY=3
         *星期三:Calendar.WEDNESDAY=4
         *星期四:Calendar.THURSDAY=5
         *星期五:Calendar.FRIDAY=6
         *星期六:Calendar.SATURDAY=7 */
        switch (week) {
            case 1:
                weekStr = "星期日";
                break;
            case 2:
                weekStr = "星期一";
                break;
            case 3:
                weekStr = "星期二";
                break;
            case 4:
                weekStr = "星期三";
                break;
            case 5:
                weekStr = "星期四";
                break;
            case 6:
                weekStr = "星期五";
                break;
            case 7:
                weekStr = "星期六";
                break;
            default:
                break;
        }
        return weekStr;
    }


    /**
     * 时间转换
     *
     * @param time       时间
     * @param dateformat 格式
     * @return LocalDateTime
     */
    public static LocalDateTime parseLocalDateTime(String time, String dateformat) {
        if (dateformat == null || StringUtil.isEmpty(dateformat)) {
            dateformat = defaultDateFormat;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        try {
            Date date = sdf.parse(time);
            Instant instant = date.toInstant();
            ZoneId zone = ZoneId.systemDefault();
            return LocalDateTime.ofInstant(instant, zone);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取当前时间字符串
     */
    public static String getCurrentDate(String dateformat) {
        if (dateformat == null || StringUtil.isEmpty(dateformat)) {
            dateformat = defaultDateFormat;
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        return sdf.format(d);
    }

    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getDate() {
        return new Date();
    }

    /**
     * 将时间戳转换为时间
     *
     * @throws ParseException
     */
    public static String stampToDate(Long s, String dateformat)
            throws ParseException {
        if (StringUtil.isEmpty(dateformat)) {
            dateformat = defaultDateFormat;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        Long time = new Long(s) * 1000;
        Date date = new Date(time);
        return sdf.format(date);
    }

    /**
     * timeStamp 转 Date
     *
     * @param lo long
     * @return
     */
    public static Date stampToDate(long lo) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = null;
        try {
            date = ts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;

    }

    /**
     * 将时间转换为时间戳
     */
    public Long dateToStamp(Date date) {
        Long stamp = date.getTime() / 1000;
        return stamp;
    }

    /**
     * 时间加减
     *
     * @param day
     * @param hour
     * @param min
     * @param sec
     * @return
     */
    public static Long stampAdd(Long stamp, int day, int hour, int min, int sec) {
        stamp = stamp + (day * 24 * 60 * 60) + (hour * 60 * 60) + (min * 60) + sec;
        return stamp;
    }

    public static String praseTime(Date date, String dateformat) {
        if (StringUtil.isEmpty(dateformat)) {
            dateformat = defaultDateFormat;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        return sdf.format(date);
    }
}
