package com.leetcode;

import java.util.HashMap;
import java.util.Map;


// Similar to ConstructBinaryTreeFromInAndPost
public class ConstructBinaryTreeFromInAndPre {
    Map<Integer, Integer> map;
    int preIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        preIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end)
            return null;
        int val = preorder[preIdx++];
        TreeNode node = new TreeNode(val);
        int inIdx = map.get(val);
        if (start == end)
            return node;
        node.left = helper(preorder, inorder, start, inIdx - 1);
        node.right = helper(preorder, inorder, inIdx + 1, end);
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
