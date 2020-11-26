package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIV {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return helper(root, k);
    }

    private boolean helper(TreeNode root, int target){
        if(root == null) return false;
        if(set.contains(target - root.val)) return true;
        set.add(root.val);
        return helper(root.left, target) || helper(root.right, target);
    }
}
