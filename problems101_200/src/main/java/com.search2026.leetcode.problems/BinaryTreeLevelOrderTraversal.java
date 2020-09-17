package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    /*
        Binary Tree Level Order Traversal - BFS
        Leetcode #102
        https://leetcode.com/problems/binary-tree-level-order-traversal/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> curr = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode t = q.poll();
                    curr.add(t.val);
                    if (t.left != null)
                        q.offer(t.left);
                    if (t.right != null)
                        q.offer(t.right);
                }
                res.add(curr);
            }
            return res;
        }
    }

    /*
        Binary Tree Level Order Traversal - DFS
        Leetcode #102
        https://leetcode.com/problems/binary-tree-level-order-traversal/
        Difficulty: Medium
     */
    public class Solution_2 {
        public void search(List<List<Integer>> res, TreeNode root, int height) {
            if (root == null) return;
            if (height >= res.size()) {
                res.add(new LinkedList<>());
            }
            res.get(height).add(root.val);
            search(res, root.left, height + 1);
            search(res, root.right, height + 1);
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            search(res, root, 0);
            return res;
        }
    }

    /*
        Binary Tree Level Order Traversal II
        Leetcode #107
        https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> curr = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode t = q.poll();
                    curr.add(t.val);
                    if (t.left != null)
                        q.offer(t.left);
                    if (t.right != null)
                        q.offer(t.right);
                }
                res.add(curr);
            }
            Collections.reverse(res);
            return res;
        }
    }

}
