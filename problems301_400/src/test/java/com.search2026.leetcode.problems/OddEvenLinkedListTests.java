package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OddEvenLinkedListTests {

    @Test
    public void testSolution() {
        OddEvenLinkedList.Solution sol = new OddEvenLinkedList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = sol.oddEvenList(head);
        assertEquals(1, res.val);
        assertEquals(3, res.next.val);
        assertEquals(5, res.next.next.val);
        assertEquals(2, res.next.next.next.val);
        assertEquals(4, res.next.next.next.next.val);
    }

}
