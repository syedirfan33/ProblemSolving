package com.leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int first = a.length() - 1, second = b.length() - 1;
        char carry = '0';
        while (first >= 0 || second >= 0) {
            char c1 = first >= 0 ? a.charAt(first--) : '0';
            char c2 = second >= 0 ? b.charAt(second--) : '0';
            if (c1 == '1' && c2 == '1') {
                if (carry == '0') {
                    carry = '1';
                    res.append('0');
                } else {
                    res.append('1');
                }
            } else if (c1 == '0' && c2 == '0') {
                if (carry == '0') res.append('0');
                else {
                    carry = '0';
                    res.append('1');
                }
            } else {
                if (carry == '0') {
                    res.append('1');
                } else {
                    res.append('0');
                }
            }

        }
        if (carry != '0') res.append(carry);
        return res.reverse().toString();
    }

    public String addBinaryII(String a, String b) {
        if (a == null && b == null) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) {
            result.append('1');
        }

        return result.reverse().toString();
    }
}
