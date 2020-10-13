package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestBSTSubtreeTests {

    @Test
    public void testSolution() {
        LargestBSTSubtree.Solution sol = new LargestBSTSubtree().new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.left = null;
        root.right.right = new TreeNode(7);
        assertEquals(3, sol.largestBSTSubtree(root));
    }

    @Test
    public void testSolution2() {
        LargestBSTSubtree.Solution_2 sol = new LargestBSTSubtree().new Solution_2();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.left = null;
        root.right.right = new TreeNode(7);
        assertEquals(3, sol.largestBSTSubtree(root));
    }

    @Test
    public void testSolution3() {
        LargestBSTSubtree.Solution_3 sol = new LargestBSTSubtree().new Solution_3();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.left = null;
        root.right.right = new TreeNode(7);
        assertEquals(3, sol.largestBSTSubtree(root));
    }

}
