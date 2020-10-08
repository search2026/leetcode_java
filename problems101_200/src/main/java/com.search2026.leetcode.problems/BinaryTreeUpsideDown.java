package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class BinaryTreeUpsideDown {

    /*
        Binary Tree Upside Down - Top Down Approach
        Leetcode #156
        https://github.com/search2026/leetcode_java/blob/master/resources/BinaryTreeUpsideDown.md
        Difficulty: Medium
     */
    public class Solution {
        public TreeNode UpsideDownBinaryTree(TreeNode root) {
            TreeNode node = root, parent = null, right = null;
            while (node != null) {
                TreeNode left = node.left;
                node.left = right;
                right = node.right;
                node.right = parent;
                parent = node;
                node = left;
            }
            return parent;
        }
    }

    /*
        Binary Tree Upside Down - Bottom Up Approach
        Leetcode #156
        https://github.com/search2026/leetcode_java/blob/master/resources/BinaryTreeUpsideDown.md
        Difficulty: Medium
     */
    public class Solution_2 {
        private TreeNode traversal(TreeNode node, TreeNode parent) {
            if (node == null) return parent;
            TreeNode root = traversal(node.left, node);
            node.left = (parent == null) ? parent : parent.right;
            node.right = parent;
            return root;
        }

        public TreeNode UpsideDownBinaryTree(TreeNode root) {
            if (root == null) return root;
            return traversal(root, null);
        }
    }

}
