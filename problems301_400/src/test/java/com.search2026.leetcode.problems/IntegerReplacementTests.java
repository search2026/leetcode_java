package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerReplacementTests {

    @Test
    public void testSolution() {
        IntegerReplacement.Solution sol = new IntegerReplacement().new Solution();
        assertEquals(3, sol.integerReplacement(8));
        assertEquals(4, sol.integerReplacement(7));
    }

    @Test
    public void testSolution2() {
        IntegerReplacement.Solution_2 sol = new IntegerReplacement().new Solution_2();
        assertEquals(3, sol.integerReplacement(8));
        assertEquals(4, sol.integerReplacement(7));
    }

}
