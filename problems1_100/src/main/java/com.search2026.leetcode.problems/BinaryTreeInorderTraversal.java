package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal {

    /*
        Binary Tree Inorder Traversal - Using Stacks
        Leetcode #94
        https://leetcode.com/problems/binary-tree-inorder-traversal/
        Difficulty: Medium
    */
    public static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode p = root;

            while (!stack.isEmpty() || p != null) {
                if (p != null) {
                    stack.offerLast(p);
                    p = p.left;
                } else {
                    p = stack.removeLast();
                    res.add(p.val);
                    p = p.right;
                }
            }

            return res;
        }
    }

    /*
        Binary Tree Inorder Traversal - Morris Traversal
        Leetcode #94
        https://leetcode.com/problems/binary-tree-inorder-traversal/
        Difficulty: Medium
    */
    public static class Solution_2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            TreeNode p = root;
            while (p != null) {
                if (p.left == null) {
                    res.add(p.val);
                    p = p.right;
                } else {
                    TreeNode temp = p.left;
                    while (temp.right != null && temp.right != p) {
                        temp = temp.right;
                    }
                    if (temp.right == null) {
                        temp.right = p;
                        p = p.left;
                    } else {
                        res.add(p.val);
                        temp.right = null;
                        p = p.right;
                    }
                }
            }
            return res;
        }
    }

}
