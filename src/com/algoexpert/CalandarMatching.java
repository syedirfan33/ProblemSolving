package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class CalandarMatching {
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        List<int[]> cal1 = getList(calendar1, dailyBounds1);
        List<int[]> cal2 = getList(calendar2, dailyBounds2);
        List<int[]> li = mergeList(cal1, cal2);
        List<StringMeeting> res = new ArrayList<>();
        int[] cur = li.get(0);
        for (int i = 1; i < li.size(); i++) {
            if (cur[1] < li.get(i)[0]) {
                if (Math.abs(cur[1] - li.get(i)[0]) >= meetingDuration) {
                    res.add(new StringMeeting(getRes(cur[1]), getRes(li.get(i)[0])));
                }
                cur = li.get(i);
            } else {
                cur[1] = Math.max(cur[1], li.get(i)[1]);
            }
        }
        return res;
    }

    private static String getRes(int first) {
        int hour = first / 60;
        int min = first % 60;
        String s1 = hour + ":" + (min < 10 ? "0" + min : min);
        return s1;
    }


    private static List<int[]> mergeList(List<int[]> cal1, List<int[]> cal2) {
        List<int[]> res = new ArrayList<>();
        int first = 0, second = 0;
        while (first < cal1.size() && second < cal2.size()) {
            if (cal1.get(first)[0] < cal2.get(second)[0]) {
                res.add(cal1.get(first));
                first++;
            } else {
                res.add(cal2.get(second));
                second++;
            }
        }
        while (first < cal1.size()) res.add(cal1.get(first++));
        while (second < cal2.size()) res.add(cal2.get(second++));
        return res;
    }

    private static List<int[]> getList(List<StringMeeting> calendar, StringMeeting dailyBounds) {
        List<int[]> list = new ArrayList<>();
        list.add(timeToMinutes(new StringMeeting("00:00", dailyBounds.start))); // We add this to handle edge cases.
        for (StringMeeting str : calendar) {
            list.add(timeToMinutes(str));
        }
        list.add(timeToMinutes(new StringMeeting(dailyBounds.end, "23:59")));
        return list;
    }

    private static int[] timeToMinutes(StringMeeting meeting) {
        String[] arr = meeting.start.split(":");
        String[] arr2 = meeting.end.split(":");
        int[] res = new int[2];
        res[0] = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        res[1] = Integer.parseInt(arr2[0]) * 60 + Integer.parseInt(arr2[1]);
        return res;
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
