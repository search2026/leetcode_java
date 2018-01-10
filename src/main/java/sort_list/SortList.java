package sort_list;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SortList {
  /*
      Sort List
      Leetcode #148
      https://leetcode.com/problems/sort-list/
      Difficulty: Medium
   */
  public class Solution {
    private ListNode merge(ListNode head1, ListNode head2) {
      if (head1 == null) return head2;
      if (head2 == null) return head1;
      ListNode dummy = new ListNode(-1);
      ListNode curr = dummy;

      while (head1 != null && head2 != null) {
        if (head1.val <= head2.val) {
          curr.next = head1;
          head1 = head1.next;
        } else {
          curr.next = head2;
          head2 = head2.next;
        }
        curr = curr.next;
      }

      if (head1 == null) curr.next = head2;
      if (head2 == null) curr.next = head1;

      return dummy.next;
    }

    private ListNode mergesort(ListNode head) {
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
      ListNode head = new ListNode(3);
      head.next = new ListNode(5);
      head.next.next = new ListNode(-1);
      ListNode sorted = sol.sortList(head);
      assertEquals(-1, sorted.val);
      assertEquals(3, sorted.next.val);
      assertEquals(5, sorted.next.next.val);
      assertNull(sorted.next.next.next);
    }
  }
}
