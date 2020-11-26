package com.leetcode;

import java.util.*;

public class WordBreakII {
    Map<Integer, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, 0, set);
    }

    List<String> helper(String s, int start, Set<String> set) {
        if (memo.containsKey(start)) return memo.get(start);
        List<String> cur = new ArrayList<>();
        if (start == s.length()) cur.add("");
        for (int i = start + 1; i <= s.length(); i++) {
            String prefix = s.substring(start, i);
            if (set.contains(prefix)) {
                List<String> others = helper(s, i, set);
                StringBuilder sb = new StringBuilder();
                for (String str : others) {
                    cur.add(prefix + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        memo.put(start, cur);
        return cur;
    }
}
