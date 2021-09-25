package com.leetcode;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        helper(res, root);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private void helper(StringBuilder res, TreeNode root) {
        if (root == null) {
            res.append("*");
            res.append(",");
            return;
        }
        res.append(root.val);
        res.append(",");
        helper(res, root.left);
        helper(res, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] arr = data.split(",");
        return build(arr, new int[]{0});
    }

    // instaed of int[] , we can also maintain global variable
    private TreeNode build(String[] arr, int[] idx) {
        if (idx[0] >= arr.length || arr[idx[0]].equals("*"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(arr[idx[0]]));
        idx[0]++;
        node.left = build(arr, idx);
        idx[0]++;
        node.right = build(arr, idx);
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
