package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddTwoNumbersTests {

    @Test
    public void testSolution() {
        AddTwoNumbers.Solution sol = new AddTwoNumbers().new Solution();
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);

        ListNode res = sol.addTwoNumbers(list1, list2);

        assertEquals(7, res.val);
        assertEquals(0, res.next.val);
        assertEquals(8, res.next.next.val);
    }

    @Test
    public void testSolution2() {
        AddTwoNumbers.Solution_2 sol = new AddTwoNumbers().new Solution_2();
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);

        ListNode res = sol.addTwoNumbers(list1, list2);

        assertEquals(7, res.val);
        assertEquals(0, res.next.val);
        assertEquals(8, res.next.next.val);
    }

}
