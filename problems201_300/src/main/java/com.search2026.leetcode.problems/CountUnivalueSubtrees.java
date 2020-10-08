package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayList;

public class CountUnivalueSubtrees {

    /*
        Count Univalue Subtrees
        Leetcode #250
        https://github.com/search2026/leetcode_java/blob/master/resources/CountUnivalueSubtrees.md
        Difficulty: Medium
     */
    public class Solution {
        private boolean search(TreeNode root, ArrayList<Integer> sum) {
            if (root == null) return true;
            boolean left = search(root.left, sum);
            boolean right = search(root.right, sum);
            if (left && right && (root.left==null || root.val==root.left.val) && (root.right==null || root.val==root.right.val)) {
                sum.set(0, sum.get(0)+1);
                return true;
            }
            return false;
        }

        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) return 0;
            ArrayList<Integer> sum = new ArrayList<>();
            sum.add(0);
            search(root, sum);
            return sum.get(0);
        }
    }

}
