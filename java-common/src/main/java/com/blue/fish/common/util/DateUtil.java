package com.blue.fish.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bluefish 2018/11/19
 * @version 1.0.0
 */
public class DateUtil {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将格式化日期转换为Date
     *
     * @param dateStr
     * @param format
     * @return
     * @throws Exception
     */
    public static Date parseToDate(String dateStr, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateStr);
    }

    /**
     * 按照默认：“yyyy_MM_dd HH:mm:ss”格式转换
     *
     * @param dateStr
     * @return
     * @throws Exception
     */
    public static Date parseToDate(String dateStr) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return sdf.parse(dateStr);
    }

    /**
     * 按照默认：“yyyy_MM_dd HH:mm:ss”格式转换
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static String formatDate(Date date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return sdf.format(date);
    }

    /**
     * 指定格式将日期转换为字符串
     *
     * @param date
     * @param format
     * @return
     * @throws Exception
     */
    public static String formatDate(Date date, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
