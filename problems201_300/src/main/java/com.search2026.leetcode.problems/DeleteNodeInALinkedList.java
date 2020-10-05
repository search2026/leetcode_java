package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

public class DeleteNodeInALinkedList {

    /*
        Delete Node in a Linked List
        Leetcode #237
        https://leetcode.com/problems/delete-node-in-a-linked-list/
        Difficulty: Easy
     */
    public class Solution {
        public void deleteNode(ListNode node) {
            if (node == null) {
                return;
            }

            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

}
