package com.dyu.expression;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

/**
 * @author dyu
 * @date 2018/07/07
 */
public class DateFormatter {

    public DateFormatter(SimpleDateFormat simpleDateFormat) throws ParseException {
        System.out.println(simpleDateFormat.format(new Date()));
    }

    public static final ThreadLocal<DateFormatter> df = ThreadLocal.withInitial(() -> {
        try {
            return new DateFormatter(new SimpleDateFormat("dd-MMm-yyyy"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    });

    public static void main(String[] args) {
        DateFormatter.df.get();
    }
}
