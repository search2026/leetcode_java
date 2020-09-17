package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertSortedArrayToBinarySearchTreeTests {

    @Test
    public void testSolution() {
        ConvertSortedArrayToBinarySearchTree.Solution sol = new ConvertSortedArrayToBinarySearchTree().new Solution();
        int[] test = {1, 3, 5, 6, 7, 8, 9};
        TreeNode root = sol.sortedArrayToBST(test);
        assertEquals(6, root.val);
        assertEquals(3, root.left.val);
        assertEquals(8, root.right.val);
        assertEquals(1, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertEquals(7, root.right.left.val);
        assertEquals(9, root.right.right.val);
    }

    @Test
    public void testSolution2() {
        ConvertSortedArrayToBinarySearchTree.Solution_2 sol = new ConvertSortedArrayToBinarySearchTree().new Solution_2();
        int[] test = {1, 3, 5, 6, 7, 8, 9};
        TreeNode root = sol.sortedArrayToBST(test);
        assertEquals(6, root.val);
        assertEquals(3, root.left.val);
        assertEquals(8, root.right.val);
        assertEquals(1, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertEquals(7, root.right.left.val);
        assertEquals(9, root.right.right.val);
    }

}
