package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeKSortedListsTests {

    @Test
    public void testSolution() {
        MergeKSortedLists.Solution sol = new MergeKSortedLists().new Solution();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(6);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        ListNode list3 = new ListNode(5);
        ListNode[] lists = {list1, list2, list3};
        ListNode merged = sol.mergeKLists(lists);
        assertEquals(1, merged.val);
        assertEquals(2, merged.next.val);
        assertEquals(3, merged.next.next.val);
        assertEquals(4, merged.next.next.next.val);
        assertEquals(5, merged.next.next.next.next.val);
        assertEquals(6, merged.next.next.next.next.next.val);
    }

    @Test
    public void testSolution2() {
        MergeKSortedLists.Solution_2 sol = new MergeKSortedLists().new Solution_2();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(6);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        ListNode list3 = new ListNode(5);
        ListNode[] lists = {list1, list2, list3};
        ListNode merged = sol.mergeKLists(lists);
        assertEquals(1, merged.val);
        assertEquals(2, merged.next.val);
        assertEquals(3, merged.next.next.val);
        assertEquals(4, merged.next.next.next.val);
        assertEquals(5, merged.next.next.next.next.val);
        assertEquals(6, merged.next.next.next.next.next.val);
    }

}
