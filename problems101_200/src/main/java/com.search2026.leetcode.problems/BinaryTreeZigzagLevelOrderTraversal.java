package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    /*
        Binary Tree Zigzag Level Order Traversal
        leetcode #103
        https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            boolean order = true;

            while (!q.isEmpty()) {
                List<Integer> curr = new ArrayList<>();
                int size = q.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode t = q.poll();
                    if (order) {
                        curr.add(t.val);
                    } else {
                        curr.add(0, t.val);
                    }
                    if (t.left != null) q.add(t.left);
                    if (t.right != null) q.add(t.right);
                }
                res.add(curr);
                order = !order;
            }

            return res;
        }
    }

    /*
        Binary Tree Zigzag Level Order Traversal
        leetcode #103
        https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
        Difficulty: Medium
     */
    public class Solution_2 {
        private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
            if (curr == null) return;

            if (sol.size() <= level) {
                List<Integer> newLevel = new LinkedList<>();
                sol.add(newLevel);
            }

            List<Integer> collection = sol.get(level);
            if (level % 2 == 0) collection.add(curr.val);
            else collection.add(0, curr.val);

            travel(curr.left, sol, level + 1);
            travel(curr.right, sol, level + 1);
        }

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            travel(root, res, 0);
            return res;
        }
    }

}
