package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestImplementStrStr {

    @Test
    public void test1() {
        ImplementStrStr.Solution sol = new ImplementStrStr().new Solution();
        assertEquals(1, sol.strStr("hello", "ll"));
        assertEquals(-1, sol.strStr("aaaaa", "bba"));
    }

    @Test
    public void test2() {
        ImplementStrStr.Solution_2 sol = new ImplementStrStr().new Solution_2();
        assertEquals(1, sol.strStr("hello", "ll"));
        assertEquals(-1, sol.strStr("aaaaa", "bba"));
    }

    @Test
    public void test3() {
        ImplementStrStr.Solution_3 sol = new ImplementStrStr().new Solution_3();
        assertEquals(1, sol.strStr("hello", "ll"));
        assertEquals(-1, sol.strStr("aaaaa", "bba"));
    }

    @Test
    public void test4() {
        ImplementStrStr.Solution_4 sol = new ImplementStrStr().new Solution_4();
        assertEquals(1, sol.strStr("hello", "ll"));
        assertEquals(-1, sol.strStr("aaaaa", "bba"));
    }

}
