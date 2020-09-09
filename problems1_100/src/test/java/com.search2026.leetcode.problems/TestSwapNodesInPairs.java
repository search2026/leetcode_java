package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSwapNodesInPairs {

    @Test
    public void test1() {
        SwapNodesInPairs.Solution sol = new SwapNodesInPairs().new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        ListNode reversed = sol.swapPairs(root);
        assertEquals(2, reversed.val);
        assertEquals(1, reversed.next.val);
        assertEquals(4, reversed.next.next.val);
        assertEquals(3, reversed.next.next.next.val);
    }

    @Test
    public void test2() {
        SwapNodesInPairs.Solution_2 sol = new SwapNodesInPairs().new Solution_2();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        ListNode reversed = sol.swapPairs(root);
        assertEquals(2, reversed.val);
        assertEquals(1, reversed.next.val);
        assertEquals(4, reversed.next.next.val);
        assertEquals(3, reversed.next.next.next.val);
    }

    @Test
    public void test3() {
        SwapNodesInPairs.Solution_3 sol = new SwapNodesInPairs().new Solution_3();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        ListNode reversed = sol.swapPairs(root);
        assertEquals(2, reversed.val);
        assertEquals(1, reversed.next.val);
        assertEquals(4, reversed.next.next.val);
        assertEquals(3, reversed.next.next.next.val);
    }

}
