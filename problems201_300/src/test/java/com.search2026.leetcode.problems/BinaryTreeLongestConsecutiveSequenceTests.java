package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeLongestConsecutiveSequenceTests {

    @Test
    public void testSolution() {
        BinaryTreeLongestConsecutiveSequence.Solution sol = new BinaryTreeLongestConsecutiveSequence().new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        assertEquals(3, sol.longestConsecutive(root));

        root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(1);
        assertEquals(2, sol.longestConsecutive(root));
    }

    @Test
    public void testSolution2() {
        BinaryTreeLongestConsecutiveSequence.Solution_2 sol =
                new BinaryTreeLongestConsecutiveSequence().new Solution_2();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        assertEquals(3, sol.longestConsecutive(root));

        sol = new BinaryTreeLongestConsecutiveSequence().new Solution_2();
        root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(1);
        assertEquals(2, sol.longestConsecutive(root));
    }

    @Test
    public void testSolution3() {
        BinaryTreeLongestConsecutiveSequence.Solution_3 sol =
                new BinaryTreeLongestConsecutiveSequence().new Solution_3();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        assertEquals(2, sol.longestConsecutive(root));

        root = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left = new TreeNode(3);
        assertEquals(3, sol.longestConsecutive(root));
    }

    @Test
    public void testSolution4() {
        BinaryTreeLongestConsecutiveSequence.Solution_4 sol =
                new BinaryTreeLongestConsecutiveSequence().new Solution_4();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        assertEquals(2, sol.longestConsecutive(root));

        sol = new BinaryTreeLongestConsecutiveSequence().new Solution_4();
        root = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left = new TreeNode(3);
        assertEquals(3, sol.longestConsecutive(root));
    }

}
