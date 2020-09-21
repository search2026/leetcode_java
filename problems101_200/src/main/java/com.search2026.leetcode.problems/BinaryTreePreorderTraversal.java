package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePreorderTraversal {

    /*
        Binary Tree Preorder Traversal - Using Stacks
        Leetcode #144
        https://leetcode.com/problems/binary-tree-preorder-traversal/
        Difficulty: Medium
    */
    public class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null)
                return res;

            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode p = root;

            while (!stack.isEmpty() || p != null) {
                if (p != null) {
                    stack.offerLast(p);
                    res.add(p.val);
                    p = p.left;
                } else {
                    p = stack.removeLast();
                    p = p.right;
                }
            }

            return res;
        }
    }

    /*
        Binary Tree Preorder Traversal - Morris Traversal
        Leetcode #144
        https://leetcode.com/problems/binary-tree-preorder-traversal/
        Difficulty: Medium
    */
    public class Solution_2 {
        public List<Integer> preorderTraversal(TreeNode root) {
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
                        res.add(p.val);
                        temp.right = p;
                        p = p.left;
                    } else {
                        temp.right = null;
                        p = p.right;
                    }
                }
            }
            return res;
        }
    }

}
