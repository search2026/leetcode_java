package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PascalsTriangleTests {

    @Test
    public void testSolution() {
        PascalsTriangle.Solution sol = new PascalsTriangle().new Solution();
        List<List<Integer>> res = sol.generate(5);
        assertEquals(5, res.size());
        assertEquals(1, res.get(0).size());
        assertEquals(2, res.get(1).size());
        assertEquals(3, res.get(2).size());
        assertEquals(4, res.get(3).size());
        assertEquals(5, res.get(4).size());
    }

    @Test
    public void testSolution2() {
        PascalsTriangle.Solution_2 sol = new PascalsTriangle().new Solution_2();

        List<Integer> res = sol.getRow(0);
        assertEquals(1, res.size());
        assertEquals(1, res.get(0));

        res = sol.getRow(1);
        assertEquals(2, res.size());
        assertEquals(1, res.get(0));
        assertEquals(1, res.get(1));

        res = sol.getRow(3);
        assertEquals(4, res.size());
        assertEquals(1, res.get(0));
        assertEquals(3, res.get(1));
        assertEquals(3, res.get(2));
        assertEquals(1, res.get(3));
    }

}
