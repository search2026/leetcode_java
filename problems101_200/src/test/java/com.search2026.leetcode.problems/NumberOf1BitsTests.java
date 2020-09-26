package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOf1BitsTests {

    @Test
    public void testSolution() {
        NumberOf1Bits.Solution sol = new NumberOf1Bits().new Solution();
        assertEquals(3, sol.hammingWeight(11));
        assertEquals(1, sol.hammingWeight(128));
    }

}
