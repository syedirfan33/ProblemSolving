package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//Premium problem, solved using lintcode
public class ConstructBinaryTreeFromInAndPost {
    int postIdx;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        postIdx = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) return null;
        int val = postorder[postIdx--];
        TreeNode node = new TreeNode(val);
        int nextIdx = map.get(val);
        if (start == end) return node;
        node.right = helper(inorder, postorder, nextIdx + 1, end); // Important
        node.left = helper(inorder, postorder, start, nextIdx - 1);
        return node;
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
