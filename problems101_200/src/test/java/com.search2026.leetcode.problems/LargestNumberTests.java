package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LargestNumberTests {

    @Test
    public void testSolution() {
        LargestNumber.Solution sol = new LargestNumber().new Solution();
        assertEquals("210", sol.largestNumber(new int[]{10, 2}));
        assertEquals("9534330", sol.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

}
