package com.oceanier.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    //TODO:改成线程安全的工具类，使用ThreadLocal。参照阿里开发手册
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final DateFormat dateFormatWithTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static String dateToString(Date date) {
        return dateFormat.format(date);
    }

    public static Date stringToDate(String dateString) {
        Date date = new Date();
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToStringWithTime(Date date) {
        return dateFormatWithTime.format(date);
    }

    public static Date stringToDateWithTime(String dateString) {
        Date date = new Date();
        try {
            return dateFormatWithTime.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
