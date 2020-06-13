package com.leetcode;

import com.leetcode.CompleteBinaryTree.*;

import java.util.*;

/**
 * @author Syed Irfan - 02/06/2020
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        getPath(root, res, new StringBuilder());
        return res;
    }
    
    private void getPath(TreeNode root, List<String> res, StringBuilder s) {
        if(root == null) return;
        s.append(root.val);
        if(root.left == null && root.right == null){
            res.add(s.toString());
        }
        s.append("->");
        int len = s.length();
        getPath(root.left, res, s);
        s.delete(len, s.length());
        getPath(root.right, res, s);
    }
}
