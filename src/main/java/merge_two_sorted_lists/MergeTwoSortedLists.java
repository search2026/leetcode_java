package merge_two_sorted_lists;

import common.ListNode;

public class MergeTwoSortedLists {
    /*
        Merge Two Sorted Lists
        https://leetcode.com/problems/merge-two-sorted-lists/
        Difficulty: Easy
     */
    public class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            else if (l2 == null) return l1;

            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;

            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }

            if (p1 != null) {
                p.next = p1;
            } else if (p2 != null) {
                p.next = p2;
            }

            return dummy.next;
        }
    }

    public static class UnitTest {

    }
}
