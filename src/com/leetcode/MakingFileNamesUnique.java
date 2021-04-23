package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                res[i] = names[i];
                map.put(names[i], 1);
            } else {
                int val = map.get(names[i]);
                StringBuilder cur = new StringBuilder(names[i]);
                cur.append('(');
                cur.append(val);
                cur.append(')');
                while (map.containsKey(cur.toString())) {
                    val++;
                    cur = new StringBuilder(names[i]);
                    cur.append('(');
                    cur.append(val);
                    cur.append(')');
                }
                res[i] = cur.toString();
                map.put(res[i], 1);
                map.put(names[i], val + 1); // Understand why its required. simple. This line is very important, or else will get time limit exceeded.
            }
        }
        return res;
    }
}
