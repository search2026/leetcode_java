package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class BinaryTreeMaximumPathSum {

    /*
        Binary Tree Maximum Path Sum
        Leetcode #124
        https://leetcode.com/problems/binary-tree-maximum-path-sum/
        Difficulty: Hard
     */
    public class Solution {
        private int maxPathSum(TreeNode node, int[] maxSum) {
            if (node == null) return 0;
            int lMaxSum = maxPathSum(node.left, maxSum);
            int rMaxSum = maxPathSum(node.right, maxSum);
            maxSum[0] = Math.max(maxSum[0], node.val + lMaxSum + rMaxSum);
            int currSum = node.val + Math.max(lMaxSum, rMaxSum);
            return Math.max(currSum, 0);
        }

        public int maxPathSum(TreeNode root) {
            int[] maxSum = new int[1];
            maxSum[0] = Integer.MIN_VALUE;
            maxPathSum(root, maxSum);
            return maxSum[0];
        }
    }

}
