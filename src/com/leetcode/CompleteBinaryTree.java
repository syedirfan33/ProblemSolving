/**
 * 
 */
package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Syed Irfan
 *
 */
public class CompleteBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	 public boolean isCompleteTree(TreeNode root) {
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        boolean end = false;
	        while(!queue.isEmpty()){
	            TreeNode cur = queue.poll();
	            if(cur==null){
	                end = true;
	            }else{
	                if(end) return false;
	                queue.offer(cur.left);
	                queue.offer(cur.right);
	            }
	            
	        }   
	        return true;
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
