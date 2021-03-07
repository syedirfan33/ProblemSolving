package com.leetcode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return null;
        if (K == 0) {
            res.add(target.val);
            return res;
        }
        build(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> visited = new HashSet<>();
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                if (cur.left != null && !visited.contains(cur.left)) q.add(cur.left);
                if (cur.right != null && !visited.contains(cur.right)) q.add(cur.right);
                if (map.containsKey(cur) && !visited.contains(map.get(cur))) q.add(map.get(cur));
                visited.add(cur);
            }
            distance++;
            if (distance == K) break;
        }
        while (!q.isEmpty()) res.add(q.remove().val);
        return res;
    }

    private void build(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            map.put(root.left, root);
            build(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            build(root.right);
        }
    }
}
