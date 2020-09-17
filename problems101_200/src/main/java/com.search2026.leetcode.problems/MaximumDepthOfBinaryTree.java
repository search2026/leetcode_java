package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class MaximumDepthOfBinaryTree {

    /*
        Maximum Depth of Binary Tree
        Leetcode #104
        https://leetcode.com/problems/maximum-depth-of-binary-tree/
        Difficulty: Easy
     */
    public class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

}
