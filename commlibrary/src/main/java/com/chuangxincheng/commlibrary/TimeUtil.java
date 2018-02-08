package com.chuangxincheng.commlibrary;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @Author chz
 * @Date 2015-4-28
 * @Desc 日期时间相关工具类
 */

public class TimeUtil {
    public static String refreshTime = "";// 记录刷新时间
    public static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_FORMAT_MM_DD_HH_MM_SS = "MM-dd HH:mm:ss";
    public static String DATE_FORMAT_HH_MM = "HH:mm";
    public static String DATA_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static String DATA_FORMAT_YYYY_MM_DD_point = "yyyy.MM.dd";
    public static String DATE_FORMAT_HH_MM_CHINESE = "MM月dd日";
    public static String DATE_FORMAT_HH_MM_CHINESE_YEAR = "yyyy年MM月dd日";
    public static SimpleDateFormat DATE_FORMAT_TILL_SECOND = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat DATE_FORMAT_TILL_DAY_CURRENT_YEAR = new SimpleDateFormat("MM-dd");
    public static SimpleDateFormat DATE_FORMAT_TILL_ZHONGWEN_YEAR = new SimpleDateFormat("yyyy年M月d日");
    public static SimpleDateFormat DATE_FORMAT_TILL_ZHONGWEN = new SimpleDateFormat("M月d日");
    public static SimpleDateFormat DATE_FORMAT_TILL_DAY_CURRENT_YEAR_POINT = new SimpleDateFormat("MM.dd");
    public static SimpleDateFormat DATE_FORMAT_TILL_DAY_HOUR = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat DATE_FORMAT_TILL_DAY_CH = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取当前时间
     */
    public static String getCurrentTime(String format) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        String currentTime = sdf.format(date);
        return currentTime;
    }

    /**
     * 获取当前时间得long
     *
     * @return
     */
    public static Long getCurrentTimeLong() {
        Date date = new Date();
        return date.getTime();
    }

    public static String getCurrentTimeLongStr() {
        return getCurrentTimeLong() + "";
    }

    /**
     * 格式话long 时间
     *
     * @param time
     * @return
     */
    public static String getTimeForLong(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }

    /**
     * 格式话long 时间
     *
     * @param time
     * @return
     */
    public static String getTimeForLong(long time,String format) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取当前年份
     *
     * @return
     */
    public static String getCurrentYear() {
        String date = getCurrentTime();
        return date.substring(0, 4);
    }

    /**
     * 获取当前月份
     *
     * @return
     */
    public static String getCurrentMonth() {
        String date = getCurrentTime();
        return date.substring(5, 7);
    }

    /**
     * 获取当前日份
     *
     * @return
     */
    public static String getCurrentDay() {
        String date = getCurrentTime();
        return date.substring(8, 10);
    }

    /**
     * 获取当前时间
     */
    public static String getCurrentTime() {
        return getCurrentTime(DATE_FORMAT);
    }

    /**
     * 列表刷新时间
     *
     * @param dateStr
     * @return
     */
    public static String refreshTime(String dateStr) {
        if (StrUtil.isNotBlank(dateStr)) {
            Calendar calendar = Calendar.getInstance();
            calendar.get(Calendar.DAY_OF_MONTH);
            long now = calendar.getTimeInMillis();
            Date date = strToDate(dateStr, "yyyy-MM-dd HH:mm:ss");
            calendar.setTime(date);
            long past = calendar.getTimeInMillis();

            // 相差的秒数
            long time = (now - past) / 1000;

            StringBuffer sb = new StringBuffer();
            if (time > 0 && time < 60) { // 1小时内
                return sb.append("刚刚").toString();
            } else if (time > 60 && time < 3600) {
                return sb.append(time / 60 + "分钟前").toString();
            } else if (time >= 3600 && time < 3600 * 24) {
                return sb.append(time / (3600) + "小时前").toString();
            } else if (time >= 3600 * 24 && time < 3600 * 168) {
                return sb.append(time / (3600 * 24) + "天前").toString();
            } else if (time >= 3600 * 168) {
                return dateToString(dateStr, DATE_FORMAT);
            }
            return "刚刚";
        } else {
            return "";
        }
    }

    /**
     * 日期字符串转换为Date
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date strToDate(String dateStr, String format) {
        Date date = null;

        if (!TextUtils.isEmpty(dateStr)) {
            DateFormat df = new SimpleDateFormat(format);
            try {
                date = df.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * 日期转换为字符串  xx年x月x日
     *
     * @param timeStr
     * @param format
     * @return
     */
    public static String dateToString(String timeStr, String format) {
        if (StrUtil.isNotBlank(timeStr)) {
            // 判断是否是今年
            Date date = strToDate(timeStr, "yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            // 如果是今年的话，才去“xx月xx日”日期格式
            if (calendar.get(Calendar.YEAR) == Integer.parseInt(getCurrentYear())) {
                return DATE_FORMAT_TILL_DAY_CURRENT_YEAR.format(date);
            }
            return DATE_FORMAT_TILL_DAY_CH.format(date);
        } else {
            return "";
        }
    }

    /**
     * 日期转换为字符串
     *
     * @param timeStr
     * @param format
     * @return
     */
    public static String dateToStringtwo(String timeStr, String format) {
        if (StrUtil.isNotBlank(timeStr)) {
            // 判断是否是今年
            Date date = strToDate(timeStr, "yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return DATE_FORMAT_DATE.format(date);
        } else {
            return "";
        }
    }

    /**
     * 日期转换为字符串yyyy.MM.dd
     *
     * @param time
     * @return
     */

    public static String dateToStringPoint(String time) {
        if (StrUtil.isNotBlank(time)) {
            Date date = getTimeFromString(time, "yyyy-MM-dd HH:mm");
            return DATE_FORMAT_DATE.format(date);
        } else {
            return "";
        }
    }

    /**
     * 将日期字符串以指定格式转换为Date
     *
     * @param timeStr 日期字符串
     * @param format  指定的日期格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:MM"
     * @return
     */
    public static Date getTimeFromString(String timeStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        if (format == null || format.trim().equals("")) {
            sdf.applyPattern(DATE_FORMAT);
        } else {
            sdf.applyPattern(format);
        }
        try {
            return sdf.parse(timeStr);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /***
     * 判断日期为上午还是下午 如果value=0表示上午，value为1表示下午
     */

    public static int isAmOrPm(String time) {
        int value = -1;
        GregorianCalendar ca = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            Date date = sdf.parse(time);
            ca.setTime(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch blockA
            e.printStackTrace();
        }
        value = ca.get(GregorianCalendar.AM_PM);
        return value;
    }

    public static String getDateFormatToHHmm(String time) {
        if (StrUtil.isNotBlank(time)) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = getTimeFromString(time, "yyyy-MM-dd HH:mm");
            return sdf.format(date);
        } else {
            return "";
        }
    }

    /**
     * 日期格式转换
     * DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
     * DATE_FORMAT_HH_MM="HH:mm";
     * DATA_FORMAT_YYYY_MM_DD="yyyy.MM.dd";
     * DATE_FORMAT_HH_MM_CHINESE="MM月dd日"
     *
     * @param time       时间
     * @param fromFormat 转换前的时间格式
     * @param ToFormat   转换后的时间格式
     * @return String
     */
    public static String getDateFormatToOtherFormat(String time, String fromFormat, String ToFormat) {
        if (StrUtil.isNotBlank(time)) {
            SimpleDateFormat sdf = new SimpleDateFormat(ToFormat);
            Date date = getTimeFromString(time, fromFormat);
            return sdf.format(date);
        } else {
            return "";
        }
    }

    /**
     * 将yyyy-MM-dd格式转换为m月d日
     *
     * @param dateStr
     * @return
     */
    public static String strToZWDate2(String dateStr) {
        if (StrUtil.isEmpty(dateStr)) {
            return "";
        }
        Date d = null;
        try {
            d = DATE_FORMAT_TILL_DAY_CH.parse(dateStr);   // 将给定的字符串中的日期提取出来
        } catch (Exception e) {            // 如果提供的字符串格式有错误，则进行异常处理
            e.printStackTrace();       // 打印异常信息
        }
        return DATE_FORMAT_TILL_ZHONGWEN.format(d);
    }

    /**
     * 日期字符串转换为MM月dd日
     *
     * @param dateStr
     * @return
     */
    public static String strToZWDate(String dateStr) {
        if (StrUtil.isEmpty(dateStr)) {
            return "";
        }
        Date d = null;
        try {
            d = DATE_FORMAT_TILL_SECOND.parse(dateStr);   // 将给定的字符串中的日期提取出来
        } catch (Exception e) {            // 如果提供的字符串格式有错误，则进行异常处理
            e.printStackTrace();       // 打印异常信息
        }
        return DATE_FORMAT_TILL_ZHONGWEN.format(d);
    }

    /**
     * 选定的时间是否小于当前时间
     *
     * @param str 选定的时间（yyyy-MM-dd）
     * @return true-小于，false-大于
     */
    public static boolean dateCompareToNow(String str) {
        Date date = strToDate(str, DATA_FORMAT_YYYY_MM_DD);
        Date date1 = strToDate(getCurrentTime(DATA_FORMAT_YYYY_MM_DD), DATA_FORMAT_YYYY_MM_DD);
        return date.getTime() <= date1.getTime();
    }

    /**
     * 得到几天前的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getBeforeDate(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 获得给定时间若干秒以前或以后的日期的标准格式。
     *
     * @param curDate
     * @param seconds
     * @return curDate
     */
    public static Date getSpecifiedDateTimeBySeconds(Date curDate, int seconds) {
        long time = (curDate.getTime() / 1000) + seconds;
        curDate.setTime(time * 1000);
        return curDate;
    }

    /**
     * 得到日期的前或者后几小时
     *
     * @param iHour 如果要获得前几小时日期，该参数为负数； 如果要获得后几小时日期，该参数为正数
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几小时
     * @see Calendar#add(int, int)
     */
    public static Date getDateBeforeOrAfterHours(Date curDate, int iHour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.HOUR_OF_DAY, iHour);
        return cal.getTime();
    }

    /**
     * 正则表达式比较时间大小
     *
     * @param dt1
     * @param dt2
     * @return
     */
    public static int compareDate(Date dt1, Date dt2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
