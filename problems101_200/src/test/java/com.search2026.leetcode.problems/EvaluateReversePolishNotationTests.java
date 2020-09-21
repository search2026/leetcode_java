package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluateReversePolishNotationTests {
    @Test
    public void testSolution() {
        EvaluateReversePolishNotation.Solution sol = new EvaluateReversePolishNotation().new Solution();
        String[] test1 = {"2", "1", "+", "3", "*"};
        assertEquals(9, sol.evalRPN(test1));

        String[] test2 = {"4", "13", "5", "/", "+"};
        assertEquals(6, sol.evalRPN(test2));
    }

    @Test
    public void testSolution2() {
        EvaluateReversePolishNotation.Solution_2 sol = new EvaluateReversePolishNotation().new Solution_2();
        String[] test1 = {"2", "1", "+", "3", "*"};
        assertEquals(9, sol.evalRPN(test1));

        String[] test2 = {"4", "13", "5", "/", "+"};
        assertEquals(6, sol.evalRPN(test2));
    }

}
