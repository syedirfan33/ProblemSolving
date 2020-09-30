package com.leetcode;


import com.algoexpert.PathSum;

import java.util.HashMap;

//Similar to SubArraySumEqK
public class PathSumIII {
    int res = 0;
    public int pathSum(PathSum.TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        pathSumHelper(root, 0, sum, map);
        return res;
    }

    private void pathSumHelper(PathSum.TreeNode node, int cur, int target, HashMap<Integer, Integer> map){
        if(node == null) return;
        cur += node.val;
        if(map.containsKey(cur - target)){
            res += map.get(cur - target);
        }
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        pathSumHelper(node.left, cur, target, map);
        pathSumHelper(node.right, cur, target, map);
        map.put(cur, map.get(cur) - 1);
    }
}
