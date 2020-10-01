package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountPrimesTests {

    @Test
    public void testSolution() {
        CountPrimes.Solution sol = new CountPrimes().new Solution();
        assertEquals(4, sol.countPrimes(10));
        assertEquals(0, sol.countPrimes(1));
        assertEquals(0, sol.countPrimes(0));
    }

}
