package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromePairsTests {

    @Test
    public void testSolution() {
        PalindromePairs.Solution sol = new PalindromePairs().new Solution();
        String[] test = new String[]{"bat", "tab", "cat"};
        List<List<Integer>> res = sol.palindromePairs(test);
        assertEquals(2, res.size());

        test = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        res = sol.palindromePairs(test);
        assertEquals(4, res.size());

        test = new String[]{"a", ""};
        res = sol.palindromePairs(test);
        assertEquals(2, res.size());
    }

    @Test
    public void testSolution2() {
        PalindromePairs.Solution_2 sol = new PalindromePairs().new Solution_2();
        String[] test = new String[]{"bat", "tab", "cat"};
        List<List<Integer>> res = sol.palindromePairs(test);
        assertEquals(2, res.size());

        test = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        res = sol.palindromePairs(test);
        assertEquals(4, res.size());

        test = new String[]{"a", ""};
        res = sol.palindromePairs(test);
        assertEquals(2, res.size());
    }

    @Test
    public void testSolution3() {
        PalindromePairs.Solution_3 sol = new PalindromePairs().new Solution_3();
        String[] test = new String[]{"bat", "tab", "cat"};
        List<List<Integer>> res = sol.palindromePairs(test);
        assertEquals(2, res.size());

        test = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        res = sol.palindromePairs(test);
        assertEquals(4, res.size());

        test = new String[]{"a", ""};
        res = sol.palindromePairs(test);
        assertEquals(2, res.size());
    }

    @Test
    public void testSolution4() {
        PalindromePairs.Solution_4 sol = new PalindromePairs().new Solution_4();
        String[] test = new String[]{"bat", "tab", "cat"};
        List<List<Integer>> res = sol.palindromePairs(test);
        assertEquals(2, res.size());

        test = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        res = sol.palindromePairs(test);
        assertEquals(4, res.size());

        test = new String[]{"a", ""};
        res = sol.palindromePairs(test);
        assertEquals(2, res.size());
    }

}
