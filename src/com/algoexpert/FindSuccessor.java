package com.algoexpert;

public class FindSuccessor {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


    // Visualise a tree, you will get the answer.
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if(node.right != null) return getLeftMostChild(node.right); // Case 1
        return firstAnotherParent(tree, node);
    }

    private BinaryTree getLeftMostChild(BinaryTree node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    private BinaryTree firstAnotherParent(BinaryTree tree, BinaryTree node){
        if(node.parent != null && node.parent.right == node) return node.parent.parent; // Case 2
        return node.parent; // Case 3
    }


    // Case 1
    //         1
    //       /   \
    //      2     3
    //    /  \    /
    //   4    5  7
    //  /
    // 6
    // IOT -> 6, 4, 2, 5, 1, 7, 3
    // Case 1 : ans for node 1 is 7 -> left most child of 1.right
    // case 2 : ans for node 5 is 1 -> 5.parent.right == 5 , so ans is 5.parent.parent. Why? imagine IOT
    // case 3 : ans for node 4 is 2 -> parent of 4 is 2. Why ? imagine IOT
}
