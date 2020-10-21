package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RotateFunctionTests {

    @Test
    public void testSolution() {
        RotateFunction.Solution sol = new RotateFunction().new Solution();
        assertEquals(26, sol.maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

}
