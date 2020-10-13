package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuperUglyNumberTests {

    @Test
    public void testSolution() {
        SuperUglyNumber.Solution sol = new SuperUglyNumber().new Solution();
        int[] primes = {2, 7, 13, 19};
        assertEquals(32, sol.nthSuperUglyNumber(12, primes));
    }

}
