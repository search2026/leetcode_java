package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateLettersTests {

    @Test
    public void testSolution() {
        RemoveDuplicateLetters.Solution sol = new RemoveDuplicateLetters().new Solution();
        String test1 = "bcabc";
        String test2 = "cbacdcbc";
        assertEquals(sol.removeDuplicateLetters(test1),"abc");
        assertEquals(sol.removeDuplicateLetters(test2),"acdb");
    }

}
