package plus_one_linked_list;

import java.util.*;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlusOneLinkedList {
  /*
      Plus One Linked List
      Leetcode #369
      https://leetcode.com/discuss/questions/oj/plus-one-linked-list?sort=votes
      http://www.cnblogs.com/grandyang/p/5626389.html
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

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new PlusOneLinkedList().new Solution();
      ListNode root = new ListNode(9);
      root.next = new ListNode(9);
      root.next.next = new ListNode(8);
      root = sol.plusOne(root);
      assertEquals(9, root.val);
      assertEquals(9, root.next.val);
      assertEquals(9, root.next.next.val);
      root = sol.plusOne(root);
      assertEquals(1, root.val);
      assertEquals(0, root.next.val);
      assertEquals(0, root.next.next.val);
      assertEquals(0, root.next.next.next.val);
    }
  }
}

