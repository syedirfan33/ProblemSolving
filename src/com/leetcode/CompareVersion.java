package com.leetcode;

public class CompareVersion {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int max = Math.max(v1.length, v2.length);
        for(int i = 0; i < max; i++){
            int part1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int part2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if(part1 > part2) return 1;
            else if(part1 < part2) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion(null, null));
    }
}
