package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDepthOfBinaryTreeTests {

    @Test
    public void testSolution() {
        MaximumDepthOfBinaryTree.Solution sol = new MaximumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        assertEquals(2, sol.maxDepth(root));

        root.right.left = new TreeNode(7);
        assertEquals(3, sol.maxDepth(root));

        root.right.left.right = new TreeNode(6);
        assertEquals(4, sol.maxDepth(root));
    }

}
