package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurstBalloonsTests {

    @Test
    public void testSolution() {
        BurstBalloons.Solution sol = new BurstBalloons().new Solution();
        assertEquals(167, sol.maxCoins(new int[]{3, 1, 5, 8}));
    }

}
