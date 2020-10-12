package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class InorderSuccessorInBST {

    /*
        Inorder Successor in BST
        Leetcode #285
        https://github.com/search2026/leetcode_java/blob/master/resources/InorderSuccessorInBST.md
        Difficulty: Medium
     */
    public class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null || p == null) {
                return null;
            }

            if (p.right != null) {
                return findMin(p.right);
            }

            // Case 2: p.right == null
            TreeNode succ = null;
            TreeNode q = root;

            while (q != null) {
                if (q.val > p.val) {
                    succ = q;
                    q = q.left;
                } else if (q.val < p.val) {
                    q = q.right;
                } else {
                    break;
                }
            }

            return succ;
        }

        private TreeNode findMin(TreeNode root) {
            TreeNode p = root;

            while (p.left != null) {
                p = p.left;
            }

            return p;
        }
    }

}
