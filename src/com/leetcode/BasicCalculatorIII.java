package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorIII {
    //Copied, don't know anything
    //https://ttzztt.gitbooks.io/lc/content/quant-dev/basic-calculator-iii.html
    public static String MathChallenge(String str) {
        Deque<Integer> deque = new LinkedList<>();
        int a1 = 0, a2 = 1, b1 = 1, b2 = 1;
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);

            if (Character.isDigit(curChar)) {
                int curNum = curChar - '0';
                while (i < str.length() - 1 && Character.isDigit(str.charAt(i + 1))) {
                    curNum = curNum * 10 + (str.charAt(++i) - '0');
                }

                a2 = b2 == 1 ? a2 * curNum : a2 / curNum;
            } else if (curChar == '(') {
                deque.addFirst(a1);
                deque.addFirst(b1);
                deque.addFirst(a2);
                deque.addFirst(b2);
                a1 = 0;
                a2 = 1;
                b1 = 1;
                b2 = 1;
            } else if (curChar == ')') {
                int curNum = a1 + b1 * a2;
                b2 = deque.remove();
                a2 = deque.remove();
                b1 = deque.remove();
                a1 = deque.remove();
                a2 = b2 == 1 ? a2 * curNum : a2 / curNum;
            } else if (curChar == '*' || curChar == '/') {
                b2 = curChar == '*' ? 1 : -1;
            } else if (curChar == '+' || curChar == '-') {
                a1 = a1 + b1 * a2;
                b1 = curChar == '+' ? 1 : -1;
                a2 = 1;
                b2 = 1;
            }
        }
        int res = a1 + a2 * b1;
        return res + "";
    }
}
