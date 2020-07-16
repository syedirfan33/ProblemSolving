package com.leetcode;

import com.leetcode.CompleteBinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Syed Irfan - 02/07/2020
 */
public class BinaryTreeLOTII {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> curLi = new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode cur = queue.remove();
                    curLi.add(cur.val);
                    if(cur.left!=null) queue.add(cur.left);
                    if(cur.right!=null) queue.add(cur.right);
                }
                res.add(0,curLi);
            }
            return res;
        }
    }
}
