package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

public class ReverseLinkedList {

    /*
        Reverse Linked List
        Leetcode #206
        https://leetcode.com/problems/reverse-linked-list/
        Difficulty: Easy
     */
    public class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode t = head.next;
                head.next = prev;
                prev = head;
                head = t;
            }
            return prev;
        }
    }

    /*
        Reverse Linked List - Recursive
        Leetcode #206
        https://leetcode.com/problems/reverse-linked-list/
        Difficulty: Easy
     */
    public class Solution_2 {
        private ListNode reverseListInt(ListNode node, ListNode prev) {
            if (node == null) return prev;
            ListNode next = node.next;
            node.next = prev;
            return reverseListInt(next, node);
        }

        public ListNode reverseList(ListNode head) {
            return reverseListInt(head, null);
        }
    }

    /*
        Reverse Linked List II
        Leetcode #92
        https://leetcode.com/problems/reverse-linked-list-ii/
        Difficulty: Medium
     */
    public class Solution_3 {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null || m > n) return null;

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            for (int i = 0; i < m - 1; i++) prev = prev.next;
            ListNode start = prev.next;
            ListNode next = start.next;

            // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, next = 3
            // dummy-> 1 -> 2 -> 3 -> 4 -> 5
            // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
            // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
            for (int i = 0; i < n - m; i++) {
                start.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = start.next;
            }

            return dummy.next;
        }
    }

}
