package com.leetcode;

public class SegmentTree {

    // 307. Range Sum Query - Mutable : Segment tree based question, video from coding decoded

    SegmentTreeNode root;

    public SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        updateHelper(root, index, val);
    }

    public int sumRange(int left, int right) {
        return sumRangeHelper(root, left, right);
    }

    // Very important to know base conditions
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    // Update means, we have to always update leaf node.
    private void updateHelper(SegmentTreeNode node, int idx, int val) {
        if (node.start == node.end) {
            node.sum = val;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (idx <= mid) {
                updateHelper(node.left, idx, val);
            } else {
                updateHelper(node.right, idx, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }

    private int sumRangeHelper(SegmentTreeNode node, int start, int end) {
        if (node.start == start && node.end == end) {
            return node.sum;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (start > mid) {
                return sumRangeHelper(node.right, start, end);
            } else if (end <= mid) {
                return sumRangeHelper(node.left, start, end);
            } else {
                return sumRangeHelper(node.left, start, mid) + sumRangeHelper(node.right, mid + 1, end);
            }
        }
    }
}

class SegmentTreeNode {
    int start, end;
    SegmentTreeNode left, right;
    int sum;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
}
