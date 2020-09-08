package com.search2026.leetcode.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTreeNode {

    @Test
    public void testTreeNode() {
        TreeNode root = new TreeNode(3);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(5);
        root.left = leftNode;
        root.right = rightNode;

        assertEquals(3, root.val);
        assertEquals(1, root.left.val);
        assertEquals(5, root.right.val);
        assertNull(root.left.right);
        assertNull(root.right.left);
    }

}
