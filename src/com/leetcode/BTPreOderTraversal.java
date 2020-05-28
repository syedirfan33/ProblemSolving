package com.leetcode;

import com.leetcode.CompleteBinaryTree.*;

import java.util.*;

/**
 * @author Syed Irfan - 24/05/2020
 */
public class BTPreOderTraversal {
  
  // Important - Recursive Solution
  /*  public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        buildRes(res, root);
        return res;
    }
    
    private void buildRes(List<Integer> res, TreeNode root){
        if(root == null) return;
        
        res.add(root.val);
        buildRes(res, root.left);
        buildRes(res, root.right);
    }*/
    
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            CompleteBinaryTree.TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        return res;
    }
}
