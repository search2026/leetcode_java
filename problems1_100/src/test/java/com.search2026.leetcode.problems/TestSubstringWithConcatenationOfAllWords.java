package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSubstringWithConcatenationOfAllWords {

    @Test
    public void test1() {
        SubstringWithConcatenationOfAllWords.Solution sol = new SubstringWithConcatenationOfAllWords().new Solution();
        String[] words = new String[]{"foo", "bar"};
        List<Integer> rslt = sol.findSubstring("barfoothefoobarman", words);
        assertEquals(0, (int) rslt.get(0));
        assertEquals(9, (int) rslt.get(1));
    }

    @Test
    public void test2() {
        SubstringWithConcatenationOfAllWords.Solution_2 sol = new SubstringWithConcatenationOfAllWords().new Solution_2();
        String[] words = new String[]{"foo", "bar"};
        List<Integer> rslt = sol.findSubstring("barfoothefoobarman", words);
        assertEquals(0, (int) rslt.get(0));
        assertEquals(9, (int) rslt.get(1));
    }

    @Test
    public void test3() {
        SubstringWithConcatenationOfAllWords.Solution_3 sol = new SubstringWithConcatenationOfAllWords().new Solution_3();
        String[] words = new String[]{"foo", "bar"};
        List<Integer> rslt = sol.findSubstring("barfoothefoobarman", words);
        assertEquals(0, (int) rslt.get(0));
        assertEquals(9, (int) rslt.get(1));
    }

}
