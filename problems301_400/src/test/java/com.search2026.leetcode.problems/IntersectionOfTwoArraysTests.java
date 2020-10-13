package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntersectionOfTwoArraysTests {

    @Test
    public void testSolution() {
        IntersectionOfTwoArrays.Solution sol = new IntersectionOfTwoArrays().new Solution();
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        int[] res = sol.intersection(a, b);
        assertEquals(1, res.length);
        assertEquals(2, res[0]);
    }

    @Test
    public void testSolution2() {
        IntersectionOfTwoArrays.Solution_2 sol = new IntersectionOfTwoArrays().new Solution_2();
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        int[] res = sol.intersection(a, b);
        assertEquals(1, res.length);
        assertEquals(2, res[0]);
    }

    @Test
    public void testSolution3() {
        IntersectionOfTwoArrays.Solution_3 sol = new IntersectionOfTwoArrays().new Solution_3();
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        int[] res = sol.intersection(a, b);
        assertEquals(1, res.length);
        assertEquals(2, res[0]);
    }

    @Test
    public void testSolution4() {
        IntersectionOfTwoArrays.Solution_4 sol = new IntersectionOfTwoArrays().new Solution_4();
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        int[] res = sol.intersect(a, b);
        assertEquals(2, res.length);
        assertEquals(2, res[0]);
        assertEquals(2, res[1]);
    }

    @Test
    public void testSolution5() {
        IntersectionOfTwoArrays.Solution_5 sol = new IntersectionOfTwoArrays().new Solution_5();
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        int[] res = sol.intersect(a, b);
        assertEquals(2, res.length);
        assertEquals(2, res[0]);
        assertEquals(2, res[1]);
    }

}
