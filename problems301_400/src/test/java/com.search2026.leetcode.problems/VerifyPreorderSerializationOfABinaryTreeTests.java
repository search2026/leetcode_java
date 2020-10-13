package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerifyPreorderSerializationOfABinaryTreeTests {
    @Test
    public void testSolution() {
        VerifyPreorderSerializationOfABinaryTree.Solution sol =
                new VerifyPreorderSerializationOfABinaryTree().new Solution();
        assertTrue(sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        assertFalse(sol.isValidSerialization("1,#"));
        assertFalse(sol.isValidSerialization("9,#,#,1"));
    }

    @Test
    public void testSolution2() {
        VerifyPreorderSerializationOfABinaryTree.Solution_2 sol =
                new VerifyPreorderSerializationOfABinaryTree().new Solution_2();
        assertTrue(sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        assertFalse(sol.isValidSerialization("1,#"));
        assertFalse(sol.isValidSerialization("9,#,#,1"));
    }

}
