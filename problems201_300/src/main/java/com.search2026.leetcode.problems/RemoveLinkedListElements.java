package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

public class RemoveLinkedListElements {

    /*
        Remove Linked List Elements
        Leetcode #203
        https://leetcode.com/problems/remove-linked-list-elements/
        Difficulty: Easy
     */
    public class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return null;
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }

}
