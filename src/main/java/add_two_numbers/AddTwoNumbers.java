package add_two_numbers;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbers {
  /*
      Add Two Numbers
      Leetcode #2
      https://leetcode.com/problems/add-two-numbers/
      Difficulty: Medium
   */
  public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode p1 = l1, p2 = l2, curr = dummy;

      int carry = 0;
      while (p1 != null || p2 != null) {
        int x = p1 == null ? 0 : p1.val;
        int y = p2 == null ? 0 : p2.val;
        int sum = x + y + carry;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p1 != null) {
          p1 = p1.next;
        }
        if (p2 != null) {
          p2 = p2.next;
        }
      }

      if (carry > 0) {
        curr.next = new ListNode(carry);
      }

      return dummy.next;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new AddTwoNumbers().new Solution();
      ListNode list1 = new ListNode(2);
      list1.next = new ListNode(4);
      list1.next.next = new ListNode(3);

      ListNode list2 = new ListNode(5);
      list2.next = new ListNode(6);
      list2.next.next = new ListNode(4);

      ListNode result = sol.addTwoNumbers(list1, list2);

      assertEquals(7, result.val);
      assertEquals(0, result.next.val);
      assertEquals(8, result.next.next.val);
    }
  }
}
