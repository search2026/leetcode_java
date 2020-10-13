package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinChangeTests {

    @Test
    public void testSolution() {
        CoinChange.Solution sol = new CoinChange().new Solution();
        assertEquals(3, sol.coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(-1, sol.coinChange(new int[]{2}, 3));
    }

}
