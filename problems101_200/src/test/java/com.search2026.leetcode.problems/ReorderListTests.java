package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReorderListTests {

    @Test
    public void testSolution() {
        ReorderList.Solution sol = new ReorderList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        sol.reorderList(head);
        assertEquals(1, head.val);
        assertEquals(4, head.next.val);
        assertEquals(2, head.next.next.val);
        assertEquals(3, head.next.next.next.val);
    }

}
