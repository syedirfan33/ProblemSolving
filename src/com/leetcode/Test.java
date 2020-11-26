package com.leetcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date(014644);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
       // formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateFormatted = formatter.format(date);
        System.out.println(dateFormatted);
    }
}
