package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LargestDivisibleSubsetTests {

    @Test
    public void testSolution() {
        LargestDivisibleSubset.Solution sol = new LargestDivisibleSubset().new Solution();
        int[] test = {1};
        List<Integer> res = sol.largestDivisibleSubset(test);
        List<Integer> expected = new ArrayList<Integer>() {{
            add(1);
        }};
        assertEquals(1, res.size());
        assertEquals(expected, res);

        test = new int[]{1, 2, 3};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(1);
            add(3);
        }};
        assertEquals(2, res.size());
        assertEquals(expected, res);

        test = new int[]{1, 2, 4, 8};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(4);
            add(8);
        }};
        assertEquals(4, res.size());
        assertEquals(expected, res);

        test = new int[]{1, 2, 3, 4, 6, 24};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(6);
            add(24);
        }};
        assertEquals(4, res.size());
        assertEquals(expected, res);

        test = new int[]{546, 669};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(669);
        }};
        assertEquals(1, res.size());
        assertEquals(expected, res);
    }

    @Test
    public void testSolution2() {
        LargestDivisibleSubset.Solution_2 sol = new LargestDivisibleSubset().new Solution_2();
        int[] test = {1};
        List<Integer> res = sol.largestDivisibleSubset(test);
        List<Integer> expected = new ArrayList<Integer>() {{
            add(1);
        }};
        assertEquals(1, res.size());
        assertEquals(expected, res);

        test = new int[]{1, 2, 3};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(1);
            add(3);
        }};
        assertEquals(2, res.size());
//        assertEquals(expected, res);

        test = new int[]{1, 2, 4, 8};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(4);
            add(8);
        }};
        assertEquals(4, res.size());
        assertEquals(expected, res);

        test = new int[]{1, 2, 3, 4, 6, 24};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(6);
            add(24);
        }};
        assertEquals(4, res.size());
        assertEquals(expected, res);

        test = new int[]{546, 669};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(669);
        }};
        assertEquals(1, res.size());
//        assertEquals(expected, res);
    }

    @Test
    public void testSolution3() {
        LargestDivisibleSubset.Solution_3 sol = new LargestDivisibleSubset().new Solution_3();
        int[] test = {1};
        List<Integer> res = sol.largestDivisibleSubset(test);
        List<Integer> expected = new ArrayList<Integer>() {{
            add(1);
        }};
        assertEquals(1, res.size());
        assertEquals(expected, res);

        test = new int[]{1, 2, 3};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(1);
            add(3);
        }};
        assertEquals(2, res.size());
        assertEquals(expected, res);

        test = new int[]{1, 2, 4, 8};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(4);
            add(8);
        }};
        assertEquals(4, res.size());
        assertEquals(expected, res);

        test = new int[]{1, 2, 3, 4, 6, 24};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(6);
            add(24);
        }};
        assertEquals(4, res.size());
        assertEquals(expected, res);

        test = new int[]{546, 669};
        res = sol.largestDivisibleSubset(test);
        expected = new ArrayList<Integer>() {{
            add(669);
        }};
        assertEquals(1, res.size());
        assertEquals(expected, res);
    }

}
