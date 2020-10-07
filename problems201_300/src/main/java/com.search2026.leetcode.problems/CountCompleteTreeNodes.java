package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class CountCompleteTreeNodes {

    /*
        Count Complete Tree Nodes
        Leetcode #222
        https://leetcode.com/problems/count-complete-tree-nodes/
        Difficulty: Medium
     */
    public class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = findLeftHeight(root);
            int rightHeight = findRightHeight(root);

            if (leftHeight == rightHeight) {
                return (2 << (leftHeight - 1)) - 1;
            }

            return countNodes(root.left) + countNodes(root.right) + 1;
        }

        private int findLeftHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int height = 1;

            while (root.left != null) {
                height++;
                root = root.left;
            }

            return height;
        }

        private int findRightHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int height = 1;

            while (root.right != null) {
                height++;
                root = root.right;
            }

            return height;
        }
    }

}
