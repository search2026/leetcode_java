package merge_two_sorted_lists;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MergeTwoSortedLists {
    /*
        Merge Two Sorted Lists
        https://leetcode.com/problems/merge-two-sorted-lists/
        Difficulty: Easy
     */
    public class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            if (l1 == null) curr.next = l2;
            else if (l2 == null) curr.next = l1;
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
