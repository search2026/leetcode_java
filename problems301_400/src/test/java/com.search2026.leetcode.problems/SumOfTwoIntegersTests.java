package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfTwoIntegersTests {

    @Test
    public void testSolution() {
        SumOfTwoIntegers.Solution sol = new SumOfTwoIntegers().new Solution();
        assertEquals(7, sol.getSum(2, 5));
        assertEquals(7, sol.getSum(1, 6));
        assertEquals(7, sol.getSum(4, 3));
    }

    @Test
    public void testSolution2() {
        SumOfTwoIntegers.Solution_2 sol = new SumOfTwoIntegers().new Solution_2();
        assertEquals(7, sol.getSum(2, 5));
        assertEquals(7, sol.getSum(1, 6));
        assertEquals(7, sol.getSum(4, 3));
    }

    @Test
    public void testSolution3() {
        SumOfTwoIntegers.Solution_3 sol = new SumOfTwoIntegers().new Solution_3();
        assertEquals(7, sol.getSum(2, 5));
        assertEquals(7, sol.getSum(1, 6));
        assertEquals(7, sol.getSum(4, 3));
    }

}
