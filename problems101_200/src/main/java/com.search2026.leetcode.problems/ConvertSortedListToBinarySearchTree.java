package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import com.search2026.leetcode.common.TreeNode;

public class ConvertSortedListToBinarySearchTree {

    /*
        Convert Sorted List to Binary Search Tree
        Leetcode #109
        https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution {
        private TreeNode sortedListToBST(ListNode head, ListNode[] tail, int left, int right) {
            if (left > right) {
                tail[0] = head;
                return null;
            }
            TreeNode node = new TreeNode(0);
            int mid = left + (right - left) / 2;
            node.left = sortedListToBST(head, tail, left, mid - 1);
            node.val = tail[0].val;
            node.right = sortedListToBST(tail[0].next, tail, mid + 1, right);
            return node;
        }

        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) return null;
            ListNode p = head;
            int len = 0;
            while (p != null) {
                len++;
                p = p.next;
            }
            return sortedListToBST(head, new ListNode[1], 0, len - 1);
        }
    }

}
