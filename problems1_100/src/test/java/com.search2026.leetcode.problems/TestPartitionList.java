package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPartitionList {

    @Test
    public void test1() {
        PartitionList.Solution sol = new PartitionList().new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(2);
        sol.partition(root, 2);
        assertEquals(1, root.val);
        assertEquals(2, root.next.val);
        assertEquals(2, root.next.next.val);
        assertEquals(4, root.next.next.next.val);
        assertEquals(3, root.next.next.next.next.val);
        assertEquals(5, root.next.next.next.next.next.val);
    }

}
