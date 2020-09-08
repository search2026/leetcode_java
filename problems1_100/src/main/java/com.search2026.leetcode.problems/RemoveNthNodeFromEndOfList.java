package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

public class RemoveNthNodeFromEndOfList {

    /*
        Remove Nth Node From End of List
        Leetcode #19
        https://leetcode.com/problems/remove-nth-node-from-end-of-list/
        Difficulty: Easy
     */
    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head;
            while (n > 1) {
                fast = fast.next;
                n--;
            }
            if (fast.next == null) {
                return head.next;
            }
            ListNode slow = head;
            fast = fast.next;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }

}
