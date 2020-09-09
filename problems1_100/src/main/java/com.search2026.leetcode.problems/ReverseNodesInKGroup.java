package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

public class ReverseNodesInKGroup {

    /*
        Reverse Nodes in K Group
        Leetcode #25
        https://leetcode.com/problems/reverse-nodes-in-k-group/
        Difficulty: Hard
     */
    public class Solution {
        private ListNode reverseGroup(ListNode start, ListNode end) {
            ListNode prefix = start.next;
            ListNode p = prefix.next;
            while (p != end) {
                ListNode temp = p.next;
                p.next = prefix;
                prefix = p;
                p = temp;
            }
            ListNode temp = start.next;
            start.next = prefix;
            temp.next = end;
            return temp;
        }

        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 0) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode start = dummy;
            ListNode end = start.next;
            int count = 0;
            while (end != null) {
                if (count == k) {
                    start = reverseGroup(start, end);
                    count = 0;
                }
                count++;
                end = end.next;
            }
            if (count == k) {
                reverseGroup(start, end);
            }
            return dummy.next;
        }
    }

}
