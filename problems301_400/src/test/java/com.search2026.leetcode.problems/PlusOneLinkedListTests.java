package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlusOneLinkedListTests {

    @Test
    public void testSolution() {
        PlusOneLinkedList.Solution sol = new PlusOneLinkedList().new Solution();
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
