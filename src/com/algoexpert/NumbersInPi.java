package com.algoexpert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumbersInPi {
    // TC O(n3), but due to memo, there will be an improvement
    public static int numbersInPi(String pi, String[] numbers) {
        Set<String> set = new HashSet<>();
        for (String num : numbers) set.add(num);
        Map<Integer, Integer> memo = new HashMap<>();
        int res = helper(pi, numbers, 0, set, memo);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int helper(String pi, String[] numbers, int idx, Set<String> set, Map<Integer, Integer> memo) {
        if (memo.containsKey(idx)) return memo.get(idx);
        if (idx == pi.length())
            return -1; // We are always adding 1 + spaceInSuffix,so for last iteration, this 1 will cances out by -1 so that spaces will be 0 for last item.
        int cur = Integer.MAX_VALUE;
        for (int i = idx; i < pi.length(); i++) {
            String sub = pi.substring(idx, i + 1);
            if (set.contains(sub)) {
                int spaceInSuffix = helper(pi, numbers, i + 1, set, memo);
                if (spaceInSuffix != Integer.MAX_VALUE) { // If we don't add this condition, 1 + max val returns overflow value in next line
                    cur = Math.min(cur, 1 + spaceInSuffix);
                }
            }
        }
        memo.put(idx, cur);
        return cur;
    }
}
