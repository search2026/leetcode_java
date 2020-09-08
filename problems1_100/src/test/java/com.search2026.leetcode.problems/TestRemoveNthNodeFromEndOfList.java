package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRemoveNthNodeFromEndOfList {
    @Test
    public void test1() {
        RemoveNthNodeFromEndOfList.Solution sol = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode res = sol.removeNthFromEnd(first, 2);
        assertEquals(1, res.val);
        assertEquals(2, res.next.val);
        assertEquals(3, res.next.next.val);
        assertEquals(5, res.next.next.next.val);
    }
}
