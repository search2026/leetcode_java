package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessNumberHigherOrLowerTests {

    @Test
    public void testSolution() {
        GuessNumberHigherOrLower.Solution sol = new GuessNumberHigherOrLower().new Solution(6);
        assertEquals(6, sol.guessNumber(10));
        assertEquals(6, sol.guessNumber(5));
        assertEquals(6, sol.guessNumber(100));
    }

    @Test
    public void testSolution2() {
        GuessNumberHigherOrLower.Solution_2 sol = new GuessNumberHigherOrLower().new Solution_2();
        assertEquals(16, sol.getMoneyAmount(10));
        assertEquals(6, sol.getMoneyAmount(5));
        assertEquals(400, sol.getMoneyAmount(100));
    }

    @Test
    public void testSolution3() {
        GuessNumberHigherOrLower.Solution_3 sol = new GuessNumberHigherOrLower().new Solution_3();
        assertEquals(16, sol.getMoneyAmount(10));
        assertEquals(6, sol.getMoneyAmount(5));
        assertEquals(400, sol.getMoneyAmount(100));
    }

}
