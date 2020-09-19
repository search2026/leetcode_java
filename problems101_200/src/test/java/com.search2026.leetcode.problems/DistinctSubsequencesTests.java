package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DistinctSubsequencesTests {

    @Test
    public void testSolution() {
        DistinctSubsequences.Solution sol = new DistinctSubsequences().new Solution();
        assertEquals(3, sol.numDistinct("rabbbit", "rabbit"));
    }

}
