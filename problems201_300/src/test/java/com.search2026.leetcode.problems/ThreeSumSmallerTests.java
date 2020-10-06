package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeSumSmallerTests {

    @Test
    public void testSolution() {
        ThreeSumSmaller.Solution sol = new ThreeSumSmaller().new Solution();
        assertEquals(2, sol.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }

}
