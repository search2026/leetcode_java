package reverse_linked_list;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new ReverseLinkedList().new Solution();
      ListNode head = new ListNode(3);
      head.next = new ListNode(5);
      head.next.next = new ListNode(-1);
      ListNode reversed = sol.reverseList(head);
      assertEquals(-1, reversed.val);
      assertEquals(5, reversed.next.val);
      assertEquals(3, reversed.next.next.val);
      assertNull(reversed.next.next.next);
    }

    @Test
    public void test2() {
      Solution_2 sol = new ReverseLinkedList().new Solution_2();
      ListNode head = new ListNode(3);
      head.next = new ListNode(5);
      head.next.next = new ListNode(-1);
      ListNode reversed = sol.reverseList(head);
      assertEquals(-1, reversed.val);
      assertEquals(5, reversed.next.val);
      assertEquals(3, reversed.next.next.val);
      assertNull(reversed.next.next.next);
    }

    @Test
    public void test3() {
      Solution_3 sol = new ReverseLinkedList().new Solution_3();
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      ListNode reversed = sol.reverseBetween(head, 2, 4);
      assertEquals(1, reversed.val);
      assertEquals(4, reversed.next.val);
      assertEquals(3, reversed.next.next.val);
      assertEquals(2, reversed.next.next.next.val);
      assertEquals(5, reversed.next.next.next.next.val);
      assertNull(reversed.next.next.next.next.next);
    }
  }
}

