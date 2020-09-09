package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMergeTwoSortedLists {

    @Test
    public void test1() {
        MergeTwoSortedLists.Solution sol = new MergeTwoSortedLists().new Solution();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        ListNode mergered = sol.mergeTwoLists(list1, list2);
        assertEquals(1, mergered.val);
        assertEquals(2, mergered.next.val);
        assertEquals(3, mergered.next.next.val);
        assertEquals(4, mergered.next.next.next.val);
        assertEquals(5, mergered.next.next.next.next.val);
    }

    @Test
    public void test2() {
        MergeTwoSortedLists.Solution_2 sol = new MergeTwoSortedLists().new Solution_2();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        ListNode mergered = sol.mergeTwoLists(list1, list2);
        assertEquals(1, mergered.val);
        assertEquals(2, mergered.next.val);
        assertEquals(3, mergered.next.next.val);
        assertEquals(4, mergered.next.next.next.val);
        assertEquals(5, mergered.next.next.next.next.val);
    }

}
