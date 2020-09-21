package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SortListTests {

    @Test
    public void testSolution() {
        SortList.Solution sol = new SortList().new Solution();
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(-1);
        ListNode sorted = sol.sortList(head);
        assertEquals(-1, sorted.val);
        assertEquals(3, sorted.next.val);
        assertEquals(5, sorted.next.next.val);
        assertNull(sorted.next.next.next);
    }

}
