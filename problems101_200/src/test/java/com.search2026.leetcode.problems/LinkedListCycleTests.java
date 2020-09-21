package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListCycleTests {

    @Test
    public void testSolution() {
        LinkedListCycle.Solution sol = new LinkedListCycle().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        assertTrue(sol.hasCycle(head));
        head.next = null;
        assertFalse(sol.hasCycle(head));
    }


    @Test
    public void testSolution2() {
        LinkedListCycle.Solution_2 sol = new LinkedListCycle().new Solution_2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        assertEquals(1, sol.detectCycle(head).val);
        head.next = null;
        assertNull(sol.detectCycle(head));
    }

}