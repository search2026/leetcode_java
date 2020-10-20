package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluateDivisionTests {

    @Test
    public void testSolution() {
        EvaluateDivision.Solution sol = new EvaluateDivision().new Solution();
        String[][] equations = {
                {"a", "b"},
                {"b", "c"}
        };
        double[] values = {2.0, 3.0};
        String[][]  queries = {
                {"a", "c"},
                {"b", "a"},
                {"a", "e"},
                {"a", "a"},
                {"x", "x"}
        };
        double[] res = sol.calcEquation(equations, values, queries);
        assertEquals(5, res.length);
        assertEquals(6.0, res[0], 1E-03);
        assertEquals(0.5, res[1], 1E-03);
        assertEquals(-1.0, res[2], 1E-03);
        assertEquals(1.0, res[3], 1E-03);
        assertEquals(-1.0, res[4], 1E-03);
    }

    @Test
    public void testSolution2() {
        EvaluateDivision.Solution_2 sol = new EvaluateDivision().new Solution_2();
        String[][] equations = {
                {"a", "b"},
                {"b", "c"}
        };
        double[] values = {2.0, 3.0};
        String[][]  queries = {
                {"a", "c"},
                {"b", "a"},
                {"a", "e"},
                {"a", "a"},
                {"x", "x"}
        };
        double[] res = sol.calcEquation(equations, values, queries);
        assertEquals(5, res.length);
        assertEquals(6.0, res[0], 1E-03);
        assertEquals(0.5, res[1], 1E-03);
        assertEquals(-1.0, res[2], 1E-03);
        assertEquals(1.0, res[3], 1E-03);
        assertEquals(-1.0, res[4], 1E-03);
    }

}
