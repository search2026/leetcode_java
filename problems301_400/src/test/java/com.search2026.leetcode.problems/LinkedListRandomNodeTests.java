package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListRandomNodeTests {

    @Test
    public void testSolution() {
        // Init a singly linked list [1,2,3].
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkedListRandomNode.Solution solution = new LinkedListRandomNode().new Solution(head);

        // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
        int rnd = solution.getRandom();
        assertTrue(rnd < 4);
        assertTrue(rnd > 0);
    }

}
