package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteNodeInALinkedListTests {

    @Test
    public void testSolution() {
        DeleteNodeInALinkedList.Solution sol = new DeleteNodeInALinkedList().new Solution();
        ListNode node_1 = new ListNode(1);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        ListNode node_9 = new ListNode(9);
        ListNode head = node_4;
        head.next = node_5;
        head.next.next = node_1;
        head.next.next.next = node_9;
        sol.deleteNode(node_5);
        assertEquals(4, head.val);
        assertEquals(1, head.next.val);
        assertEquals(9, head.next.next.val);
    }

}
