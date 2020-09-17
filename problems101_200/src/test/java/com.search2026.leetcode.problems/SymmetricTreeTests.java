package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SymmetricTreeTests {

    @Test
    public void testSolution() {
        SymmetricTree.Solution sol = new SymmetricTree().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        assertTrue(sol.isSymmetric(root));
        root.left = new TreeNode(5);
        assertFalse(sol.isSymmetric(root));
    }

}
