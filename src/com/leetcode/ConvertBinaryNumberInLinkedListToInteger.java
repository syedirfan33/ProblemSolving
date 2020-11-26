package com.leetcode;

public class ConvertBinaryNumberInLinkedListToInteger {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        StringBuilder str = new StringBuilder();
        while (head != null) {
            str.append(head.val);
            head = head.next;
        }
        return Integer.valueOf(str.toString(), 2);
        // By not using library method
        // int res = 0;
        // int i = 0;
        // int j = str.length() - 1;
        // while(j >= 0){
        //     if(str.charAt(j) == '1') res += Math.pow(2, i);
        //     i++;
        //     j--;
        // }
        // return res;
    }
}
