package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class InvertBinaryTree {

    /*
        Invert Binary Tree
        Leetcode #226
        https://leetcode.com/problems/invert-binary-tree/
        Difficulty: Easy
     */
    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            TreeNode temp = root.left;

            root.left = invertTree(root.right);
            root.right = invertTree(temp);

            return root;
        }
    }

}
