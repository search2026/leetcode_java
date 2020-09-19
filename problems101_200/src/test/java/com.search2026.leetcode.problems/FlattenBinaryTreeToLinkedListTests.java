package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FlattenBinaryTreeToLinkedListTests {

    @Test
    public void testSolution() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        FlattenBinaryTreeToLinkedList.Solution sol = new FlattenBinaryTreeToLinkedList().new Solution();
        sol.flatten(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertEquals(2, root.right.val);
        assertNull(root.right.left);
        assertEquals(3, root.right.right.val);
        assertNull(root.right.right.left);
        assertEquals(4, root.right.right.right.val);
        assertNull(root.right.right.right.left);
        assertEquals(5, root.right.right.right.right.val);
        assertNull(root.right.right.right.right.left);
        assertEquals(6, root.right.right.right.right.right.val);
        assertNull(root.right.right.right.right.right.left);
        assertNull(root.right.right.right.right.right.right);
    }

    @Test
    public void testSolution2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        FlattenBinaryTreeToLinkedList.Solution_2 sol = new FlattenBinaryTreeToLinkedList().new Solution_2();
        sol.flatten(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertEquals(2, root.right.val);
        assertNull(root.right.left);
        assertEquals(3, root.right.right.val);
        assertNull(root.right.right.left);
        assertEquals(4, root.right.right.right.val);
        assertNull(root.right.right.right.left);
        assertEquals(5, root.right.right.right.right.val);
        assertNull(root.right.right.right.right.left);
        assertEquals(6, root.right.right.right.right.right.val);
        assertNull(root.right.right.right.right.right.left);
        assertNull(root.right.right.right.right.right.right);
    }

}
