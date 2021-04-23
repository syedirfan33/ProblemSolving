package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PlayGround {
    public static void main(String[] args) {
        int cashiers = 3;
        int[][] inp = new int[2][3];
        int firstEndTime = -1;
        int secondEndTime = -1;
        int thirdEndTime = -1;
        Queue<int[]> queue = new LinkedList<>();
        for(int[] cur: inp) queue.add(cur);
        int res = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.remove();
            if(firstEndTime == -1){
                firstEndTime = cur[1];
            }else if(secondEndTime == -1){
                secondEndTime = cur[1];
            }else if(thirdEndTime == -1){
                thirdEndTime = cur[1];
            }
            res = Math.max(firstEndTime, Math.max(secondEndTime, thirdEndTime));
            res = Math.max(res, cur[1]);
        }
    }
}
