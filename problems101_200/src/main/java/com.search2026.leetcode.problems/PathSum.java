package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    /*
        Path Sum
        Leetcode #112
        https://leetcode.com/problems/path-sum/
        Difficulty: Easy
     */
    public class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return sum == root.val;
            }
            return hasPathSum(root.left, sum - root.val)
                           || hasPathSum(root.right, sum - root.val);
        }
    }

    /*
        Path Sum II
        Leetcode #113
        https://leetcode.com/problems/path-sum/
        Difficulty: Medium
     */
    public class Solution_2 {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (root != null) {
                pathSum(root, sum, new ArrayList<Integer>(), res);
            }
            return res;
        }

        private void pathSum(TreeNode root, int sum, ArrayList<Integer> nodes, List<List<Integer>> curr) {
            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    ArrayList<Integer> temp = new ArrayList<>(nodes);
                    temp.add(root.val);
                    curr.add(temp);
                }
                return;
            }
            nodes.add(root.val);
            if (root.left != null) {
                pathSum(root.left, sum - root.val, nodes, curr);
            }
            if (root.right != null) {
                pathSum(root.right, sum - root.val, nodes, curr);
            }
            nodes.remove(nodes.size() - 1);
        }
    }

}
