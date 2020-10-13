package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class DeleteANodeInABST {

    /*
        Delete a Binary Search Tree Node
        Leetcode #450
        https://leetcode.com/problems/delete-node-in-a-bst/
        Difficulty: Medium
        Recursive
     */
    public class Solution {
        private int getMin(TreeNode root) {
            int min = root.val;
            while (root.left != null) {
                root = root.left;
                min = root.val;
            }
            return min;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                // node with two children, replace with the inOrder successor(minVal) in the right subtree
                root.val = getMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
            return root;
        }
    }

    /*
       Delete a Binary Search Tree Node
       https://leetcode.com/problems/delete-node-in-a-bst/
       Difficulty: Medium
       Iterative
    */
    public class Solution_2 {
        private TreeNode deleteRootNode(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode next = root.right;
            TreeNode pre = null;
            for (; next.left != null; pre = next, next = next.left) ;
            next.left = root.left;
            if (root.right != next) {
                pre.left = next.right;
                next.right = root.right;
            }
            return next;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode cur = root;
            TreeNode pre = null;
            while (cur != null && cur.val != key) {
                pre = cur;
                if (key < cur.val) {
                    cur = cur.left;
                } else if (key > cur.val) {
                    cur = cur.right;
                }
            }
            if (pre == null) {
                return deleteRootNode(cur);
            }
            if (pre.left == cur) {
                pre.left = deleteRootNode(cur);
            } else {
                pre.right = deleteRootNode(cur);
            }
            return root;
        }
    }

}
