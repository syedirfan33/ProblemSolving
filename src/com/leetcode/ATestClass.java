package com.leetcode;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author Syed Irfan - 12/06/2020
 */
public class ATestClass {
    public static void main(String[] args) throws UnsupportedEncodingException {

        StringBuilder res = new StringBuilder();
        Object[] arr = new Object[]{null};
        arr[0] = "hi";
        System.out.println(arr[0]);
        System.out.println("0.7.5".compareTo("0.7.4"));
        String encodedWithUTF8 = "dfsfs!\n23@â€œ";
        String decodedToISO88591 = new String(encodedWithUTF8.getBytes("Windows-1252"), "UTF-8");
        System.out.println(decodedToISO88591);

        String[] inp = {"bali", "malta", "polma", "paris"};

        List<String> out = getResult("nalga", inp);
        System.out.println(Arrays.toString(out.toArray()));
    }

    private static List<String> getResult(String input, String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        int minScore = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length() == input.length()) {
                int currentScore = 0;
                for (int i = 0; i < input.length(); i++) {
                    if (word.charAt(i) != input.charAt(i)) {
                        currentScore++;
                    }
                }
                if (!map.containsKey(currentScore)) {
                    map.put(currentScore, new ArrayList<>());
                }
                map.get(currentScore).add(word);
                minScore = Math.min(minScore, currentScore);
            }
        }
        if (minScore == Integer.MAX_VALUE) {
            return new ArrayList<>();
        }

        return map.get(minScore);
    }

    private String getSlot(Meeting workingHours, Meeting[] meetings, int currentTime, int duration) {
        if(workingHours.end < currentTime + duration){
            return "No time available";
        }
        Arrays.sort(meetings, (a, b) -> a.start - b.start);

        for (int i = 0; i < meetings.length - 1; i++){
            Meeting currentMeeting = meetings[i];
            Meeting nextMeeting = meetings[i + 1];
            if(currentMeeting.end >= currentTime){
                int currentDuration = nextMeeting.start - currentMeeting.end;
                if(currentDuration >= duration){
                    Meeting answer = new Meeting();
                    answer.start = currentMeeting.end;
                    answer.end = currentMeeting.end + duration;
                }
            }
        }
        Meeting answer = new Meeting();
        answer.start = meetings[meetings.length - 1].end;
        answer.end = answer.start + duration;
        return null;
    }


}

class Meeting {
    public int start;
    public int end;

    Meeting(){

    }
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

enum TxnType {
    SPLIT_BILL, SEND_MONEY, SEND_MONEY_REQUEST
}
