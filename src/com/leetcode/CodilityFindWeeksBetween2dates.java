package com.leetcode;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class CodilityFindWeeksBetween2dates {
    public int solution(int Y, String A, String B, String W) {

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        int[] ACfg = getMonthCfg(A, Y);
        int[] BCfg = getMonthCfg(B, Y);
        cal1.set(Y, ACfg[0], 1);
        cal2.set(Y, BCfg[0], BCfg[1]);
        return getWeeks(cal1, cal2);
    }

    private int getWeeks(Calendar d1, Calendar d2) {
        int startDay = d1.get(Calendar.DAY_OF_WEEK);
        if (startDay == Calendar.SUNDAY) {
            d1.add(Calendar.DAY_OF_WEEK, 1);
        } else if (startDay != Calendar.MONDAY) {
            d1.add(Calendar.DAY_OF_WEEK, 9 - startDay);
        }
        Instant d1Instanct = Instant.ofEpochMilli(d1.getTimeInMillis());
        Instant d2Instant = Instant.ofEpochMilli(d2.getTimeInMillis());
        LocalDateTime start = LocalDateTime.ofInstant(d1Instanct, ZoneId.systemDefault());
        LocalDateTime end = LocalDateTime.ofInstant(d2Instant, ZoneId.systemDefault());
        long weeks = ChronoUnit.WEEKS.between(start, end);
        return (int) weeks;
    }

    private int[] getMonthCfg(String month, int year) {
        switch (month) {
            case "January":
                return new int[]{0, 31};
            case "February":
                if (year % 4 == 0) return new int[]{1, 29};
                return new int[]{1, 28};
            case "March":
                return new int[]{2, 31};
            case "April":
                return new int[]{3, 30};
            case "May":
                return new int[]{4, 31};
            case "June":
                return new int[]{5, 30};
            case "July":
                return new int[]{6, 31};
            case "August":
                return new int[]{7, 31};
            case "September":
                return new int[]{8, 30};
            case "October":
                return new int[]{9, 31};
            case "November":
                return new int[]{10, 30};
            case "December":
                return new int[]{11, 31};
        }
        return new int[]{0, 0};
    }
}
