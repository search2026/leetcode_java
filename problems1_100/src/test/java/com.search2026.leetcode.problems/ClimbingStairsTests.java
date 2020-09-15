package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingStairsTests {

    @Test
    public void testSolution() {
        ClimbingStairs.Solution sol = new ClimbingStairs().new Solution();
        assertEquals(1, sol.climbStairs(1));
        assertEquals(2, sol.climbStairs(2));
        assertEquals(3, sol.climbStairs(3));
        assertEquals(5, sol.climbStairs(4));
        assertEquals(8, sol.climbStairs(5));
        assertEquals(13, sol.climbStairs(6));
        assertEquals(21, sol.climbStairs(7));
    }

    @Test
    public void testSolution2() {
        ClimbingStairs.Solution_2 sol = new ClimbingStairs().new Solution_2();
        assertEquals(1, sol.climbStairs(1));
        assertEquals(2, sol.climbStairs(2));
        assertEquals(3, sol.climbStairs(3));
        assertEquals(5, sol.climbStairs(4));
        assertEquals(8, sol.climbStairs(5));
        assertEquals(13, sol.climbStairs(6));
        assertEquals(21, sol.climbStairs(7));
    }

    @Test
    public void testSolution3() {
        ClimbingStairs.Solution_3 sol = new ClimbingStairs().new Solution_3();
        assertEquals(1, sol.climbStairs(1));
        assertEquals(2, sol.climbStairs(2));
        assertEquals(3, sol.climbStairs(3));
        assertEquals(5, sol.climbStairs(4));
        assertEquals(8, sol.climbStairs(5));
        assertEquals(13, sol.climbStairs(6));
        assertEquals(21, sol.climbStairs(7));
    }

}
