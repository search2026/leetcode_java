package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class SameTree {

    /*
        Same Tree
        Leetcode #100
        https://leetcode.com/problems/same-tree/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == q) {
                return true;
            }
            if (p != null && q != null) {
                return p.val == q.val && isSameTree(p.left, q.left)
                               && isSameTree(p.right, q.right);
            }
            return false;
        }
    }

}
