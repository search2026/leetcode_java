package com.search2026.leetcode.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestListNode {

    @Test
    public void testListNodeAcess() {
        ListNode root = new ListNode(3);
        ListNode second = new ListNode(-1);
        root.next = second;

        assertEquals(3, root.val);
        assertEquals(-1, root.next.val);
        assertNull(root.next.next);
    }

}
