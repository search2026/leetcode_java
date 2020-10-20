package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

public class PlusOneLinkedList {

    /*
        Plus One Linked List
        Leetcode #369
        https://github.com/search2026/leetcode_java/blob/master/resources/PlusOneLinkedList.md
        Difficulty: Medium
     */
    public class Solution {
        public ListNode plusOne(ListNode head) {
            if (head == null) return head;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode p1 = dummy;
            ListNode p2 = dummy;

            while (p2.next != null) {
                p2 = p2.next;
                if (p2.val != 9) {
                    p1 = p2;
                }
            }

            if (p2.val != 9) {
                p2.val++;
            } else {
                p1.val++;
                p1 = p1.next;
                while (p1 != null) {
                    p1.val = 0;
                    p1 = p1.next;
                }
            }

            if (dummy.val == 0) {
                return dummy.next;
            }

            return dummy;
        }
    }

}
