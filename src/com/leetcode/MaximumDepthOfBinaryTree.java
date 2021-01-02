package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // Solution 1
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int res1 = 1 + helper(root.left);
        int res2 = 1 + helper(root.right);
        return Math.max(res1, res2);
    }

    //Solution 2
    int res = 0;
    public int maxDepthII(TreeNode root) {
        if(root == null) return 0;
        helper(root, 1);
        return res;
    }

    private void helper(TreeNode root, int cur){
        if(root == null) return;
        res = Math.max(res, cur);
        helper(root.left, cur + 1);
        helper(root.right, cur + 1);
    }

    //BFS solution
    public int maxDepthIII(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.remove();
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            res++;
        }
        return res;
    }
}
