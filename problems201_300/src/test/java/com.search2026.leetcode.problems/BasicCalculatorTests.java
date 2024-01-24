package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

    @Test
    public void testSolution7() {
        BasicCalculator.Solution_7 sol = new BasicCalculator().new Solution_7();
        assertEquals(2, sol.calculate("1 + 1"));
        assertEquals(4, sol.calculate(" 6-4 / 2 "));
        assertEquals(21, sol.calculate("2*(5+5*2)/3+(6/2+8)"));
        assertEquals(-12, sol.calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }

    @Test
    public void testSolution8() {
        BasicCalculator.Solution_8 sol = new BasicCalculator().new Solution_8();
        assertEquals(2, sol.calculate("1 + 1"));
        assertEquals(4, sol.calculate(" 6-4 / 2 "));
        assertEquals(21, sol.calculate("2*(5+5*2)/3+(6/2+8)"));
        assertEquals(-12, sol.calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }


    @Test
    public void testSolution9() {
        BasicCalculator.Solution_9 sol = new BasicCalculator().new Solution_9();

        assertArrayEquals(new String[]{"-1*a", "14"},
                sol.basicCalculatorIV("e + 8 - a + 5",
                        new String[]{"e"},
                        new int[]{1}).toArray(String[]::new));

        assertArrayEquals(new String[]{"-1*pressure", "5"},
                sol.basicCalculatorIV("e - 8 + temperature - pressure",
                        new String[]{"e", "temperature"},
                        new int[]{1, 12}).toArray(String[]::new));

//        assertArrayEquals(new String[]{"1*e*e", "-64"},
//                sol.basicCalculatorIV("(e + 8) * (e - 8)",
//                        new String[]{},
//                        new int[]{}).toArray(String[]::new));
    }
}
