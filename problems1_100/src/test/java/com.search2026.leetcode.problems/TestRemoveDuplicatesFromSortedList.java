package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRemoveDuplicatesFromSortedList {

    @Test
    public void test1() {
        RemoveDuplicatesFromSortedList.Solution sol = new RemoveDuplicatesFromSortedList().new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(3);
        sol.deleteDuplicates(root);
        assertEquals(1, root.val);
        assertEquals(2, root.next.val);
        assertEquals(3, root.next.next.val);
    }

    @Test
    public void test2() {
        RemoveDuplicatesFromSortedList.Solution_2 sol = new RemoveDuplicatesFromSortedList().new Solution_2();
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(3);
        sol.deleteDuplicates(root);
        assertEquals(2, root.val);
        assertEquals(3, root.next.val);
    }

}
