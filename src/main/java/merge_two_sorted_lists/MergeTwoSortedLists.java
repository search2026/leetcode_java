package merge_two_sorted_lists;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new MergeTwoSortedLists().new Solution();
      ListNode list1 = new ListNode(1);
      list1.next = new ListNode(3);
      list1.next.next = new ListNode(5);
      ListNode list2 = new ListNode(2);
      list2.next = new ListNode(4);
      ListNode mergered = sol.mergeTwoLists(list1, list2);
      assertEquals(1, mergered.val);
      assertEquals(2, mergered.next.val);
      assertEquals(3, mergered.next.next.val);
      assertEquals(4, mergered.next.next.next.val);
      assertEquals(5, mergered.next.next.next.next.val);
    }

    @Test
    public void test2() {
      Solution_2 sol = new MergeTwoSortedLists().new Solution_2();
      ListNode list1 = new ListNode(1);
      list1.next = new ListNode(3);
      list1.next.next = new ListNode(5);
      ListNode list2 = new ListNode(2);
      list2.next = new ListNode(4);
      ListNode mergered = sol.mergeTwoLists(list1, list2);
      assertEquals(1, mergered.val);
      assertEquals(2, mergered.next.val);
      assertEquals(3, mergered.next.next.val);
      assertEquals(4, mergered.next.next.next.val);
      assertEquals(5, mergered.next.next.next.next.val);
    }
  }
}
