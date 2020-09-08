package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestLetterCombinationsOfAPhoneNumber {

    @Test
    public void test1() {
        LetterCombinationsOfAPhoneNumber.Solution sol = new LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> res = sol.letterCombinations("23");
        assertEquals(9, res.size());
        assertTrue(res.contains("ad"));
        assertTrue(res.contains("ae"));
        assertTrue(res.contains("af"));
        assertTrue(res.contains("bd"));
        assertTrue(res.contains("be"));
        assertTrue(res.contains("bf"));
        assertTrue(res.contains("cd"));
        assertTrue(res.contains("ce"));
        assertTrue(res.contains("cf"));
        assertFalse(res.contains("hd"));
    }

}
