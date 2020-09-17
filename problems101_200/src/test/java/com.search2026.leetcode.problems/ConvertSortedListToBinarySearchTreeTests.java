package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertSortedListToBinarySearchTreeTests {

    @Test
    public void testSolution() {
        ConvertSortedListToBinarySearchTree.Solution sol = new ConvertSortedListToBinarySearchTree().new Solution();

        ListNode testRoot = new ListNode(1);
        testRoot.next = new ListNode(3);
        testRoot.next.next = new ListNode(5);
        testRoot.next.next.next = new ListNode(6);
        testRoot.next.next.next.next = new ListNode(7);
        testRoot.next.next.next.next.next = new ListNode(8);
        testRoot.next.next.next.next.next.next = new ListNode(9);

        TreeNode root = sol.sortedListToBST(testRoot);

        assertEquals(6, root.val);
        assertEquals(3, root.left.val);
        assertEquals(8, root.right.val);
        assertEquals(1, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertEquals(7, root.right.left.val);
        assertEquals(9, root.right.right.val);
    }

}
