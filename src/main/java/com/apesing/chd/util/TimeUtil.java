package com.apesing.chd.util;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
