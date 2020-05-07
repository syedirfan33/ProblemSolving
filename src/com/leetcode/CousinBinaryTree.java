package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.leetcode.CompleteBinaryTree.TreeNode;

public class CousinBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = -1;
        int depth = 0;
        int res1 = -1;
        Map<Integer, Integer> map = new HashMap<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.remove();
                if(cur.val == x  || cur.val == y){
                    if(res == -1) {
                        res = depth;
                        res1 = cur.val;
                    }
                    else if( res != depth) return false;
                    else {
                        if(map.get(cur.val) == map.get(res1)) return false;
                        return true;
                    }
                }
                if(cur.left!=null){
                    queue.add(cur.left);
                    map.put(cur.left.val, cur.val);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                    map.put(cur.right.val, cur.val);
                }
            }
          depth++;
        }
        return false;
    }

}
