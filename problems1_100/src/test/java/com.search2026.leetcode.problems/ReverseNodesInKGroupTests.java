package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseNodesInKGroupTests {

    @Test
    public void testSolution() {
        ReverseNodesInKGroup.Solution sol = new ReverseNodesInKGroup().new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ListNode res = sol.reverseKGroup(root, 2);
        assertEquals(2, res.val);
        assertEquals(1, res.next.val);
        assertEquals(4, res.next.next.val);
        assertEquals(3, res.next.next.next.val);
        assertEquals(5, res.next.next.next.next.val);
    }

}
