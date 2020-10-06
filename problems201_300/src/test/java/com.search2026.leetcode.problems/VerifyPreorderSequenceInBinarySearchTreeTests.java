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

}
