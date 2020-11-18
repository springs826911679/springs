package com.springs.demo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String dateFormat(long time, String formatType) {
        SimpleDateFormat format = new SimpleDateFormat(formatType);
        Date date = new Date(time);
        return format.format(date);
    }

    public static Long getLongTime(String date, String formatType) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(formatType);
        return format.parse(date).getTime();
    }

    public static long dateToLong(Date date) {
        return date.getTime();
    }
}
