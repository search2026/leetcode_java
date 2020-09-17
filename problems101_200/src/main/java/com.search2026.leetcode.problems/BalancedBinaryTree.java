package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class BalancedBinaryTree {

    /*
        Balanced Binary Tree - Bottom Up Travsersal
        Leetcode #110
        https://leetcode.com/problems/balanced-binary-tree/
        Difficulty: Easy
     */
    class Solution {
        private int getTreeDepth(TreeNode root) {
            if (root == null) return 0;

            int lDepth = getTreeDepth(root.left);
            if (lDepth == -1) return -1;
            int rDepth = getTreeDepth(root.right);
            if(rDepth == -1) return -1;

            return (Math.abs(lDepth - rDepth) <= 1) ? Math.max(lDepth, rDepth) + 1 : -1;
        }

        public boolean isBalanced(TreeNode root) {
            return getTreeDepth(root) != -1;
        }
    }

}
