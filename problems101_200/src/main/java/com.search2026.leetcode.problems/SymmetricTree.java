package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SymmetricTree {

    /*
        Symmetric Tree - Recursive
        Leetcode #101
        https://leetcode.com/problems/symmetric-tree/
        Difficulty: Easy
     */
    public class Solution {
        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;

            return left.val == right.val && isSymmetric(left.left, right.right)
                           && isSymmetric(left.right, right.left);
        }

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }
    }

    /*
        Symmetric Tree - Iterative
        Leetcode #101
        https://leetcode.com/problems/symmetric-tree/
        Difficulty: Easy
     */
    public class Solution_2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            LinkedList<TreeNode> lefts = new LinkedList<>();
            LinkedList<TreeNode> rights = new LinkedList<>();
            lefts.add(root.left);
            rights.add(root.right);
            while (!lefts.isEmpty() && !rights.isEmpty()) {
                TreeNode left = lefts.poll();
                TreeNode right = rights.poll();
                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                lefts.add(left.left);
                lefts.add(left.right);
                rights.add(right.right);
                rights.add(right.left);
            }
            return lefts.isEmpty() && rights.isEmpty();
        }
    }

}
