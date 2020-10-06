package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromePermutationTests {

    @Test
    public void testSolution() {
        PalindromePermutation.Solution sol = new PalindromePermutation().new Solution();
        assertFalse(sol.canPermutePalindrome("code"));
        assertTrue(sol.canPermutePalindrome("aab"));
        assertTrue(sol.canPermutePalindrome("carerac"));
    }


    @Test
    public void testSolution2() {
        PalindromePermutation.Solution_2 sol = new PalindromePermutation().new Solution_2();
        List<String> res = sol.generatePalindromes("aabb");
        assertEquals(2, res.size());
        assertTrue(res.contains("abba"));
        assertTrue(res.contains("baab"));

        res = sol.generatePalindromes("abc");
        assertEquals(0, res.size());
    }

}
