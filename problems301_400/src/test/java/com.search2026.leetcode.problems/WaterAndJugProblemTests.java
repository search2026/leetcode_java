package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaterAndJugProblemTests {

    @Test
    public void test1() {
        WaterAndJugProblem.Solution sol = new WaterAndJugProblem().new Solution();
        assertTrue(sol.canMeasureWater(3, 5, 4));
        assertFalse(sol.canMeasureWater(2, 6, 5));
    }

}
