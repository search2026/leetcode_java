package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class ValidateBinarySearchTree {

    /*
        Validate Binary Search Tree - Top Down Recursion
        Leetcode #98
        https://leetcode.com/problems/validate-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution {
        private boolean valid(TreeNode root, long min, long max) {
            if (root == null) return true;
            return root.val > min && root.val < max &&
                           valid(root.left, min, root.val) && valid(root.right, root.val, max);
        }

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }

    /*
        Validate Binary Search Tree - In-Order Traversal
        Leetcode #98
        https://leetcode.com/problems/validate-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution_2 {
        private TreeNode inOrderPrev = null;

        private boolean isMonotonicIncreasing(TreeNode node) {
            if (node == null) return true;
            if (!isMonotonicIncreasing(node.left)) return false;
            if (inOrderPrev != null && node.val <= inOrderPrev.val) return false;
            inOrderPrev = node;
            return isMonotonicIncreasing(node.right);
        }

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            return isMonotonicIncreasing(root);
        }
    }

}
