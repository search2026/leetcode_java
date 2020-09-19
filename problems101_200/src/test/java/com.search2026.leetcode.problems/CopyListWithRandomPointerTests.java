package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.RandomListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CopyListWithRandomPointerTests {

    @Test
    public void testSolution() {
        CopyListWithRandomPointer.Solution sol = new CopyListWithRandomPointer().new Solution();
        RandomListNode head = new RandomListNode(1);
        RandomListNode second = new RandomListNode(2);
        head.next = second;
        head.random = second;
        second.random = second;
        RandomListNode res = sol.copyRandomList(head);
        assertEquals(1, res.label);
        assertEquals(2, res.next.label);
        assertEquals(2, res.random.label);
        assertEquals(2, res.next.random.label);
    }

}
