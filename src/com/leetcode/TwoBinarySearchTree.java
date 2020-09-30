package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoBinarySearchTree {
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
        public List<Integer> getAllElements(CompleteBinaryTree.TreeNode root1, CompleteBinaryTree.TreeNode root2) {
            List<Integer> in1 = new ArrayList<>();
            List<Integer> in2 = new ArrayList<>();
            inOrder(in1, root1);
            inOrder(in2, root2);
            return mergeList(in1, in2);
        }

        private void inOrder(List<Integer> in, CompleteBinaryTree.TreeNode root){
            if(root == null) return;
            inOrder(in, root.left);
            in.add(root.val);
            inOrder(in, root.right);
        }

        private List<Integer> mergeList(List<Integer> l1, List<Integer> l2){
            List<Integer> res = new ArrayList<>();
            int i = 0;
            int j = 0;
            while(i < l1.size() && j < l2.size()){
                if(l1.get(i) < l2.get(j)){
                    res.add(l1.get(i));
                    i++;
                }else{
                    res.add(l2.get(j));
                    j++;
                }
            }

            while(i < l1.size()){
                res.add(l1.get(i));
                i++;
            }
            while(j < l2.size()){
                res.add(l2.get(j));
                j++;
            }

            return res;
        }
    }
}
