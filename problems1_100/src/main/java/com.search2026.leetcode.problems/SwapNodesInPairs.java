package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

public class SwapNodesInPairs {

    /*
        Swap Nodes in Pairs - Iterative
        Leetcode #24
        https://leetcode.com/problems/swap-nodes-in-pairs/
        Difficulty: Medium
     */
    public class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;

            while (prev.next != null && prev.next.next != null) {
                ListNode first = prev.next;
                ListNode second = prev.next.next;
                first.next = second.next;
                prev.next = second;
                second.next = first;
                prev = first;
            }

            return dummy.next;
        }
    }

    /*
        Swap Nodes in Pairs - Iterative with previous pointer
        Leetcode #24
        https://leetcode.com/problems/swap-nodes-in-pairs/
        Difficulty: Medium
     */
    public class Solution_2 {
        public ListNode swapPairs(ListNode head) {
            if ((head == null) || (head.next == null)) return head;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode p = head;
            ListNode prev = dummy;
            while (p != null && p.next != null) {
                prev.next = p.next;
                prev = p;
                p = p.next.next;
                prev.next.next = prev;
            }
            prev.next = p;
            return dummy.next;
        }
    }

    /*
        Swap Nodes in Pairs - Recursion
        Leetcode #24
        https://leetcode.com/problems/swap-nodes-in-pairs/
        Difficulty: Medium
     */
    public class Solution_3 {
        public ListNode swapPairs(ListNode head) {
            if ((head == null) || (head.next == null)) return head;
            ListNode n = head.next;
            head.next = swapPairs(head.next.next);
            n.next = head;
            return n;
        }
    }

}
