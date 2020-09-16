package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateListTests {

    @Test
    public void testSolution() {
        RotateList.Solution sol = new RotateList().new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode res = sol.rotateRight(root, 2);
        assertEquals(4, res.val);
        assertEquals(5, res.next.val);
        assertEquals(1, res.next.next.val);
        assertEquals(2, res.next.next.next.val);
        assertEquals(3, res.next.next.next.next.val);
    }

}
