package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return res;
        Integer cand1 = null;
        Integer cand2 = null;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (cand1 != null && cur == cand1) {
                cnt1 += 1;
            } else if (cand2 != null && cur == cand2) {
                cnt2 += 1;
            } else if (cnt1 == 0) {
                cnt1 = 1;
                cand1 = cur;
            } else if (cnt2 == 0) {
                cnt2 = 1;
                cand2 = cur;
            } else {
                cnt1 -= 1;
                cnt2 -= 1;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (cur == cand1) cnt1++;
            else if (cur == cand2) cnt2++;
        }
        if (cnt1 > n / 3) res.add(cand1);
        if (cnt2 > n / 3) res.add(cand2);
        return res;
    }
}
