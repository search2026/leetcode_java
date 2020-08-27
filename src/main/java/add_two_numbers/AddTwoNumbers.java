package add_two_numbers;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTwoNumbers {
    /*
        Add Two Numbers
        Leetcode #2
        https://leetcode.com/problems/add-two-numbers/
        Difficulty: Medium
     */
    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            int carry = 0;
            while (l1 != null || l2 != null || carry > 0) {
                int x = (l1 == null) ? 0 : l1.val;
                int y = (l2 == null) ? 0 : l2.val;
                int sum = x + y + carry;
                p.next = new ListNode(sum % 10);
                carry = sum / 10;
                p = p.next;
                if (l1 != null)
                    l1 = l1.next;
                if (l2 != null)
                    l2 = l2.next;
            }

            return dummy.next;
        }
    }

    /*
        Add Two Numbers
        Leetcode #2
        https://leetcode.com/problems/add-two-numbers/
        Difficulty: Medium
     */
    public class Solution_2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            int carry = 0;
            while (l1 != null || l2 != null || carry > 0) {
                int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
                p.next = new ListNode(sum % 10);
                carry = sum / 10;
                p = p.next;
                l1 = (l1 == null) ? l1 : l1.next;
                l2 = (l2 == null) ? l2 : l2.next;
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

        @Test
        public void test2() {
            Solution_2 sol = new AddTwoNumbers().new Solution_2();
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
