package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumDepthOfBinaryTreeTests {

    @Test
    public void testSolution() {
        MinimumDepthOfBinaryTree.Solution sol = new MinimumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        assertEquals(2, sol.minDepth(root));

        root.right.left = new TreeNode(6);
        assertEquals(2, sol.minDepth(root));
    }

    @Test
    public void testSolution2() {
        MinimumDepthOfBinaryTree.Solution_2 sol = new MinimumDepthOfBinaryTree().new Solution_2();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        assertEquals(2, sol.minDepth(root));

        root.right.left = new TreeNode(6);
        assertEquals(2, sol.minDepth(root));

        root.right.left.right = new TreeNode(6);
        assertEquals(2, sol.minDepth(root));
    }

}
