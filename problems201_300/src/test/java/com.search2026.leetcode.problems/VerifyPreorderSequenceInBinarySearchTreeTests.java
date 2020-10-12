package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VerifyPreorderSequenceInBinarySearchTreeTests {

    @Test
    public void testSolution() {
        VerifyPreorderSequenceInBinarySearchTree.Solution sol =
                new VerifyPreorderSequenceInBinarySearchTree().new Solution();
        assertFalse(sol.verifyPreorder(new int[]{5, 2, 6, 1, 3}));
        assertTrue(sol.verifyPreorder(new int[]{5, 2, 1, 3, 6}));
    }

    @Test
    public void testSolution2() {
        VerifyPreorderSequenceInBinarySearchTree.Solution_2 sol =
                new VerifyPreorderSequenceInBinarySearchTree().new Solution_2();
        assertFalse(sol.verifyPreorder(new int[]{5, 2, 6, 1, 3}));
        assertTrue(sol.verifyPreorder(new int[]{5, 2, 1, 3, 6}));
    }

    @Test
    public void testSolution3() {
        VerifyPreorderSequenceInBinarySearchTree.Solution_3 sol =
                new VerifyPreorderSequenceInBinarySearchTree().new Solution_3();
        assertFalse(sol.verifyPreorder(new int[]{5, 2, 6, 1, 3}));
        assertTrue(sol.verifyPreorder(new int[]{5, 2, 1, 3, 6}));
    }

}
