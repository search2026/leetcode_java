package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindModeInBinarySearchTreeTests {

    @Test
    public void testSolution() {
        FindModeInBinarySearchTree.Solution sol = new FindModeInBinarySearchTree().new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        int[] res = sol.findMode(root);
        assertEquals(1, res.length);
        assertArrayEquals(new int[]{2}, res);
    }

}
