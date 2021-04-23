package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipBinaryTreeToMatchPreOrderTraversal {
    // Video from coding decoded or algorithms made easy
    List<Integer> res = new ArrayList<>();
    int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (dfs(root, voyage))
            return res;

        return Arrays.asList(-1);
    }

    private boolean dfs(TreeNode root, int[] voyage) {
        if (root == null)
            return true;

        if (root.val != voyage[i])
            return false;

        i++; // It's time to compare the children to see if flipping needs to be done

        if (root.left != null && root.left.val != voyage[i]) {
            // need to flip
            res.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        } else {
            return dfs(root.left, voyage) && dfs(root.right, voyage);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
