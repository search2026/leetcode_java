package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestWildcardMatching {

    @Test
    public void test1() {
        WildcardMatching.Solution sol = new WildcardMatching().new Solution();
        assertFalse(sol.isMatch("aa", "a"));
        assertTrue(sol.isMatch("aa", "aa"));
        assertFalse(sol.isMatch("aaa", "aa"));
        assertTrue(sol.isMatch("aa", "*"));
        assertTrue(sol.isMatch("aa", "a*"));
        assertTrue(sol.isMatch("ab", "?*"));
        assertFalse(sol.isMatch("aab", "c*a*b"));
        assertTrue(sol.isMatch("cazb", "c*a*b"));
    }

    @Test
    public void test2() {
        WildcardMatching.Solution_2 sol = new WildcardMatching().new Solution_2();
        assertFalse(sol.isMatch("aa", "a"));
        assertTrue(sol.isMatch("aa", "aa"));
        assertFalse(sol.isMatch("aaa", "aa"));
        assertTrue(sol.isMatch("aa", "*"));
        assertTrue(sol.isMatch("aa", "a*"));
        assertTrue(sol.isMatch("ab", "?*"));
        assertFalse(sol.isMatch("aab", "c*a*b"));
        assertTrue(sol.isMatch("cazb", "c*a*b"));
    }

    @Test
    public void test3() {
        WildcardMatching.Solution_3 sol = new WildcardMatching().new Solution_3();
        assertFalse(sol.isMatch("aa", "a"));
        assertTrue(sol.isMatch("aa", "aa"));
        assertFalse(sol.isMatch("aaa", "aa"));
        assertTrue(sol.isMatch("aa", "*"));
        assertTrue(sol.isMatch("aa", "a*"));
        assertTrue(sol.isMatch("ab", "?*"));
        assertFalse(sol.isMatch("aab", "c*a*b"));
        assertTrue(sol.isMatch("cazb", "c*a*b"));
    }

}
