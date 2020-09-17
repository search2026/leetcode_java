package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ConvertSortedArrayToBinarySearchTree {

    /*
        Convert Sorted Array to Binary Search Tree - Recursion
        Leetcode #108
        https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution {
        private TreeNode sortedArrayToBST(int[] num, int left, int right) {
            if (left > right) return null;

            int mid = left + (right - left) / 2;
            TreeNode node = new TreeNode(num[mid]);
            node.left = sortedArrayToBST(num, left, mid - 1);
            node.right = sortedArrayToBST(num, mid + 1, right);
            return node;
        }

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }
    }

    /*
        Convert Sorted Array to Binary Search Tree - Iterative
        Leetcode #108
        https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution_2 {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            int len = nums.length;

            TreeNode root = new TreeNode(0);

            Deque<TreeNode> nodeStack = new LinkedList<TreeNode>() {{
                push(root);
            }};
            Deque<Integer> leftIndexStack = new LinkedList<Integer>() {{
                push(0);
            }};
            Deque<Integer> rightIndexStack = new LinkedList<Integer>() {{
                push(len - 1);
            }};

            while (!nodeStack.isEmpty()) {
                TreeNode currNode = nodeStack.pop();
                int left = leftIndexStack.pop();
                int right = rightIndexStack.pop();
                int mid = left + (right - left) / 2; // avoid overflow
                currNode.val = nums[mid];
                if (left <= mid - 1) {
                    currNode.left = new TreeNode(0);
                    nodeStack.push(currNode.left);
                    leftIndexStack.push(left);
                    rightIndexStack.push(mid - 1);
                }
                if (mid + 1 <= right) {
                    currNode.right = new TreeNode(0);
                    nodeStack.push(currNode.right);
                    leftIndexStack.push(mid + 1);
                    rightIndexStack.push(right);
                }
            }
            return root;
        }
    }

}
