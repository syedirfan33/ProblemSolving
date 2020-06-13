package com.leetcode;

import com.leetcode.CompleteBinaryTree.*;

import java.util.*;

/**
 * @author Syed Irfan - 02/06/2020
 */
public class SymmetricTree {
    //Iterative solution
    /*public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }*/
    
    //Recursive Solution
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return validate(root.left, root.right);
    }
    
    private boolean validate(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return validate(left.left, right.right) && validate(left.right, right.left);
    }
}
