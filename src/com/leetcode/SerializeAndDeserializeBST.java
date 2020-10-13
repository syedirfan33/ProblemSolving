package com.leetcode;

public class SerializeAndDeserializeBST {
    public class Codec {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "";
            StringBuilder res = new StringBuilder();
            helper(res, root);
            return res.toString().trim();
        }

        private void helper(StringBuilder res, TreeNode root){
            if(root == null) return;
            res.append(root.val+" ");
            helper(res, root.left);
            helper(res, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.isEmpty()) return null;
            String[] inp = data.split(" ");
            return construct(inp,0, inp.length - 1);
        }

        private TreeNode construct(String[] inp, int start, int end){
            if(start > end) return null;
            TreeNode root = new TreeNode(Integer.parseInt(inp[start]));
            int idx = start + 1;
            for(idx = start + 1; idx <= end; idx++){
                if(Integer.parseInt(inp[idx]) > Integer.parseInt(inp[start])){
                    break;
                }
            }
            root.left = construct(inp, start + 1, idx - 1);
            root.right = construct(inp, idx, end);
            return root;
        }
    }

}
