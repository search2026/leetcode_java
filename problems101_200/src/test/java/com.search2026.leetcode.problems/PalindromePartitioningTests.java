package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromePartitioningTests {

    @Test
    public void testSolution() {
        PalindromePartitioning.Solution sol = new PalindromePartitioning().new Solution();
        List<List<String>> res = sol.partition("aab");
        assertEquals(2, res.size());
//        assertEquals(2, res.get(0).size());
//        assertEquals(3, res.get(0).size());
    }

    @Test
    public void testSolution2() {
        PalindromePartitioning.Solution_2 sol = new PalindromePartitioning().new Solution_2();
        List<List<String>> res = sol.partition("aab");
        assertEquals(2, res.size());
//        assertEquals(2, res.get(0).size());
//        assertEquals(3, res.get(0).size());
    }

    @Test
    public void testSolution3() {
        PalindromePartitioning.Solution_3 sol = new PalindromePartitioning().new Solution_3();
        assertEquals(1, sol.minCut("aab"));
        assertEquals(0, sol.minCut("a"));
        assertEquals(1, sol.minCut("ab"));
    }

}
