package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {

    /*
        Lowest Common Ancestor of a Binary Search Tree - Recursive
        LeetCode #235
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
        Difficulty: Easy
     */
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || (root.val >= Math.min(p.val, q.val) && root.val <= Math.max(p.val, q.val))) {
                return root;
            }
            if (root.val > Math.max(p.val, q.val)) {
                return lowestCommonAncestor(root.left, p, q);
            }
            return lowestCommonAncestor(root.right, p, q);

        }
    }

    /*
        Lowest Common Ancestor of a Binary Search Tree - Iterative
        LeetCode #235
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
        Difficulty: Easy
     */
    public class Solution_2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while ((root.val - p.val) * (root.val - q.val) > 0)
                root = p.val < root.val ? root.left : root.right;
            return root;
        }
    }

}
