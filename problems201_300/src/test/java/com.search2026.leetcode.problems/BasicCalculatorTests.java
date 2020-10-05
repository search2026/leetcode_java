package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTests {

    @Test
    public void testSolution() {
        BasicCalculator.Solution sol = new BasicCalculator().new Solution();
        assertEquals(2, sol.calculate("1 + 1"));
        assertEquals(3, sol.calculate(" 2-1 + 2 "));
        assertEquals(23, sol.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    @Test
    public void testSolution2() {
        BasicCalculator.Solution_2 sol = new BasicCalculator().new Solution_2();
        assertEquals(2, sol.calculate("1 + 1"));
        assertEquals(3, sol.calculate(" 2-1 + 2 "));
        assertEquals(23, sol.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    @Test
    public void testSolution3() {
        BasicCalculator.Solution_3 sol = new BasicCalculator().new Solution_3();
        assertEquals(2, sol.calculate("1 + 1"));
        assertEquals(3, sol.calculate(" 2-1 + 2 "));
        assertEquals(23, sol.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    @Test
    public void testSolution4() {
        BasicCalculator.Solution_4 sol = new BasicCalculator().new Solution_4();
        assertEquals(7, sol.calculate("3+2*2"));
        assertEquals(1, sol.calculate(" 3/2 "));
        assertEquals(5, sol.calculate(" 3+5 / 2 "));
    }

    @Test
    public void testSolution5() {
        BasicCalculator.Solution_5 sol = new BasicCalculator().new Solution_5();
        assertEquals(7, sol.calculate("3+2*2"));
        assertEquals(1, sol.calculate(" 3/2 "));
        assertEquals(5, sol.calculate(" 3+5 / 2 "));
    }

    @Test
    public void testSolution6() {
        BasicCalculator.Solution_6 sol = new BasicCalculator().new Solution_6();
        assertEquals(7, sol.calculate("3+2*2"));
        assertEquals(1, sol.calculate(" 3/2 "));
        assertEquals(5, sol.calculate(" 3+5 / 2 "));
    }

}
