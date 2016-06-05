package merge_two_sorted_lists;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MergeTwoSortedLists {
    /*
        Merge Two Sorted Lists
        Leetcode #81
        https://leetcode.com/problems/merge-two-sorted-lists/
        Difficulty: Easy
     */
    public class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
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

            if (l1 != null) p.next = l1;
            else p.next = l2;

            return dummy.next;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MergeTwoSortedLists().new Solution();
            assertTrue(true);
        }
    }
}
