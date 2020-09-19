package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedBinaryTreeTests {

    @Test
    public void testSolution() {
        BalancedBinaryTree.Solution sol = new BalancedBinaryTree().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        assertTrue(sol.isBalanced(root));

        root.right.left.right = new TreeNode(6);
        assertFalse(sol.isBalanced(root));
    }

}
