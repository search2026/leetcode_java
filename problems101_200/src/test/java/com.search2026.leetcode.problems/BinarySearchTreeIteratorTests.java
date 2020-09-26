package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeIteratorTests {

    @Test
    public void testSolution() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BinarySearchTreeIterator.BSTIterator it = new BinarySearchTreeIterator().new BSTIterator(root);
        assertEquals(7, it.next());
        assertEquals(3, it.next());
        assertTrue(it.hasNext());
    }

}
