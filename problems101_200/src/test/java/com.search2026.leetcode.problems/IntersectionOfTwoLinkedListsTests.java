package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntersectionOfTwoLinkedListsTests {

    @Test
    public void test1() {
        IntersectionOfTwoLinkedLists.Solution sol = new IntersectionOfTwoLinkedLists().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        node7.next = node9;
        node2.next = node3;
        ListNode res = sol.getIntersectionNode(node1, node2);
        assertEquals(3, (int)res.val);
        node2.next = node4;
        node4.next = node6;
        node6.next = node8;
        node8.next = node9;
        res = sol.getIntersectionNode(node1, node2);
        assertEquals(9, (int)res.val);
    }

    @Test
    public void test2() {
        IntersectionOfTwoLinkedLists.Solution_2 sol = new IntersectionOfTwoLinkedLists().new Solution_2();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        node7.next = node9;
        node2.next = node3;
        ListNode res = sol.getIntersectionNode(node1, node2);
        assertEquals(3, (int)res.val);
        node2.next = node4;
        node4.next = node6;
        node6.next = node8;
        node8.next = node9;
        res = sol.getIntersectionNode(node1, node2);
        assertEquals(9, (int)res.val);
    }

    @Test
    public void test3() {
        IntersectionOfTwoLinkedLists.Solution_3 sol = new IntersectionOfTwoLinkedLists().new Solution_3();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        node7.next = node9;
        node2.next = node3;
        ListNode res = sol.getIntersectionNode(node1, node2);
        assertEquals(3, (int)res.val);
        node2.next = node4;
        node4.next = node6;
        node6.next = node8;
        node8.next = node9;
        res = sol.getIntersectionNode(node1, node2);
        assertEquals(9, (int)res.val);
    }

}
