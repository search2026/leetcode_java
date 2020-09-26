package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayDeque;

public class BinarySearchTreeIterator {

    /*
        Binary Search Tree Iterator
        Leetcode #173
        https://leetcode.com/problems/binary-search-tree-iterator/
        Difficulty: Medium
     */
    public class BSTIterator {

        private ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        private TreeNode current = null;

        public BSTIterator(TreeNode root) {
            pushNode(root);
        }

        private void pushNode(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            if (current == null) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    current = stack.pop();
                    pushNode(current.right);
                }
            }
            return true;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (hasNext()) {
                int val = current.val;
                current = null;
                return val;
            } else {
                // Follow the contract of java.util.Iterator
                throw new java.util.NoSuchElementException();
            }
        }
    }

}
