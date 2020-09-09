package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

public class MergeTwoSortedLists {

    /*
        Merge Two Sorted Lists - Iterative
        Leetcode #81
        https://leetcode.com/problems/merge-two-sorted-lists/
        Difficulty: Easy
     */
    public class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }

            if (l1 != null) {
                p.next = l1;
            } else {
                p.next = l2;
            }

            return dummy.next;
        }
    }

    /*
        Merge Two Sorted Lists - Recursive
        Leetcode #81
        https://leetcode.com/problems/merge-two-sorted-lists/
        Difficulty: Easy
     */
    public class Solution_2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l2.next, l1);
                return l2;
            }
        }
    }

}
