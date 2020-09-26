package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidPalindromeTests {

    @Test
    public void testSolution() {
        ValidPalindrome.Solution sol = new ValidPalindrome().new Solution();
        assertTrue(sol.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(sol.isPalindrome("race a car"));
    }

}
