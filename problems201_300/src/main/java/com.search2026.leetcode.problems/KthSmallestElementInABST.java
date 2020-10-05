package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementInABST {

    /*
        Kth Smallest Element in a BST
        Leetcode #230
        https://leetcode.com/problems/kth-smallest-element-in-a-bst/
        Difficulty: Medium
     */
    public class Solution {
        int counter;
        int res;
        public int kthSmallest(TreeNode root, int k) {
            if (root == null || k == 0) return 0;

            counter = k;
            helper(root);
            return res;
        }

        private void helper(TreeNode root) {
            if (root == null) return;

            helper(root.left);
            counter--;
            if (counter == 0) {
                res = root.val;
                return;
            }

            helper(root.right);
        }
    }

    /*
        Kth Smallest Element in a BST - Using List/Stack
        Leetcode #230
        https://leetcode.com/problems/kth-smallest-element-in-a-bst/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int kthSmallest(TreeNode root, int k) {
            TreeNode node = root;
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            int counter = 0;
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.addLast(node);
                    node = node.left;
                } else {
                    node = stack.removeLast();
                    counter++;
                    if (counter == k) return node.val;
                    node = node.right;
                }
            }
            return -1;
        }
    }

    /*
        Kth Smallest Element in a BST - Count Number
        Leetcode #230
        https://leetcode.com/problems/kth-smallest-element-in-a-bst/
        Difficulty: Medium
    */
    public class Solution_3 {
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return 0;
            }

            int leftNodes = getNumberNodes(root.left);
            if (k == leftNodes + 1) {
                return root.val;
            } else if (k > leftNodes + 1) {
                return kthSmallest(root.right, k - leftNodes - 1);
            } else {
                return kthSmallest(root.left, k);
            }
        }

        private int getNumberNodes(TreeNode root) {
            if (root == null) return 0;

            return getNumberNodes(root.left) + getNumberNodes(root.right) + 1;
        }
    }

}
