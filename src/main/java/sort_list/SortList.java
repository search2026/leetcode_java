package sort_list;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SortList {
    /*
        Sort List
        Leetcode #148
        https://leetcode.com/problems/sort-list/
        Difficulty: Medium
     */
    public class Solution {
        public ListNode merge(ListNode head1, ListNode head2) {
            if (head1 == null) return head2;
            if (head2 == null) return head1;
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;

            while (head1 != null && head2 != null) {
                if (head1.val <= head2.val) {
                    cur.next = head1;
                    head1 = head1.next;
                } else {
                    cur.next = head2;
                    head2 = head2.next;
                }
                cur = cur.next;
            }

            if (head1 == null) cur.next = head2;
            if (head2 == null) cur.next = head1;

            return dummy.next;
        }

        public ListNode mergesort(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode head1 = dummy.next;
            ListNode head2 = slow.next;
            slow.next = null;
            return merge(mergesort(head1), mergesort(head2));
        }

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            return mergesort(head);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SortList().new Solution();
            assertTrue(true);
        }
    }
}
