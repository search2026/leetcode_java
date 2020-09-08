package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPalindromeNumber {

    @Test
    public void test1() {
        PalindromeNumber.Solution sol = new PalindromeNumber().new Solution();
        assertTrue(sol.isPalindrome(1234321));
        assertTrue(sol.isPalindrome(9));
        assertFalse(sol.isPalindrome(122));
        assertFalse(sol.isPalindrome(-5115));
    }

    @Test
    public void test2() {
        PalindromeNumber.Solution sol = new PalindromeNumber().new Solution();
        assertTrue(sol.isPalindrome(1234321));
        assertTrue(sol.isPalindrome(9));
        assertFalse(sol.isPalindrome(122));
    }

}
