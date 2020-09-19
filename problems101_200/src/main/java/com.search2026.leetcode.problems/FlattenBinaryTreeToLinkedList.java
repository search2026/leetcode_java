package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    /*
        Flatten Binary Tree to Linked List - Recursive
        Leetcode #114
        https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
        Difficulty: Medium
     */
    public class Solution {
        private TreeNode flatten(TreeNode root, TreeNode pre) {
            if (root == null) return pre;
            pre = flatten(root.right, pre);
            pre = flatten(root.left, pre);
            root.right = pre;
            root.left = null;
            pre = root;
            return pre;
        }

        public void flatten(TreeNode root) {
            flatten(root, null);
        }
    }

    /*
        Flatten Binary Tree to Linked List - Iterative
        Leetcode #114
        https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
        Difficulty: Medium
     */
    public class Solution_2 {
        public void flatten(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left != null) {
                    TreeNode leftClosetToMiddle = cur.left;
                    while (leftClosetToMiddle.right != null) leftClosetToMiddle = leftClosetToMiddle.right;
                    leftClosetToMiddle.right = cur.right;
                    cur.right = cur.left;
                    cur.left = null;
                }
                cur = cur.right;
            }
        }
    }

}
