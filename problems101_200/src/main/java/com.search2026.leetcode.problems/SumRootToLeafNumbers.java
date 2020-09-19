package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class SumRootToLeafNumbers {

    /*
        Sum Root to Leaf Numbers
        Leetcode #129
        https://leetcode.com/problems/sum-root-to-leaf-numbers/
        Difficulty: Medium
     */
    public class Solution {
        public int sumNumbers(TreeNode root) {
            return sumTree(root, 0);
        }

        private int sumTree(TreeNode root, int sum) {
            if (root == null)
                return 0;
            if (root.left == null && root.right == null)
                return sum * 10 + root.val;
            return sumTree(root.left, sum * 10 + root.val) + sumTree(root.right, sum * 10 + root.val);
        }
    }

}
