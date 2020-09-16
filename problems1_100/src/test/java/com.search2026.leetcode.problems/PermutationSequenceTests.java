package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PermutationSequenceTests {

    @Test
    public void testSolution() {
        PermutationSequence.Solution sol = new PermutationSequence().new Solution();
        assertEquals(sol.getPermutation(4, 17), "3412");
    }

}
