package com.algoexpert;

import java.util.Stack;

public class ShortenPath {
    // This problem is same as "Simplify Path" leetcode. The only difference is that
    // if the path is relative (does not start with "/"), output should also "not start with "/"
    // Also, as per test cases, /../../ -> /
    // but, ../../ -> ../../
    public static String shortenPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.equals(".") || dir.length() == 0) continue;
            else if (dir.equals("..")) {
                if (!stack.isEmpty() && stack.peek() != "..") stack.pop();
                else if (path.charAt(0) != '/') stack.push("..");
            } else {
                stack.push(dir);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            String dir = stack.pop();
            res.insert(0, dir).insert(0, "/");
        }
        if (path.charAt(0) != '/') res.deleteCharAt(0);
        return res.toString();
    }
}
