package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestReverseLinkedList {

    @Test
    public void test1() {
        ReverseLinkedList.Solution sol = new ReverseLinkedList().new Solution();
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
        ReverseLinkedList.Solution_2 sol = new ReverseLinkedList().new Solution_2();
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
        ReverseLinkedList.Solution_3 sol = new ReverseLinkedList().new Solution_3();
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
