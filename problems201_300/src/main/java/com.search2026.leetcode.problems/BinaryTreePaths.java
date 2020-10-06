package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    /*
        Binary Tree Paths
        Leetcode #257
        https://leetcode.com/problems/binary-tree-paths/
        Difficulty: Easy
     */
    public class Solution {
        private void search(TreeNode root, List<String> res, String s) {
            if (root.left == null && root.right == null) res.add(s + root.val);
            if (root.left != null) search(root.left, res, s + root.val + "->");
            if (root.right != null) search(root.right, res, s + root.val + "->");
        }

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) return res;
            search(root, res, "");
            return res;
        }
    }

}
