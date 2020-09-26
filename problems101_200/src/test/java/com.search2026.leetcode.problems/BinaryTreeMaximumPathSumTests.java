package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeMaximumPathSumTests {

    @Test
    public void testSolution() {
        BinaryTreeMaximumPathSum.Solution sol = new BinaryTreeMaximumPathSum().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(-2);
        assertEquals(7, sol.maxPathSum(root));

        root = new TreeNode(-5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(4);
        assertEquals(6, sol.maxPathSum(root));
    }

}
