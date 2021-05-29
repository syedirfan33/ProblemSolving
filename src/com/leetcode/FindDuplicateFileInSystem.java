package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {
    //Solved it myself :)
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] strArr = path.split("\\s");
            for (int i = 1; i < strArr.length; i++) {
                int idx = strArr[i].indexOf("(");
                String fileName = strArr[i].substring(0, idx);
                String content = strArr[i].substring(idx + 1, strArr[i].length() - 1);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(strArr[0] + "/" + fileName);
            }
        }
        List<List<String>> res = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v.size() > 1)
                res.add(v);
        });
        return res;
    }
}
