package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerToEnglishWordsTests {

    @Test
    public void testSolution() {
        IntegerToEnglishWords.Solution sol = new IntegerToEnglishWords().new Solution();
        assertEquals("One Hundred Twenty Three", sol.numberToWords(123));
        assertEquals("Twelve Thousand Three Hundred Forty Five", sol.numberToWords(12345));
        assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", sol.numberToWords(1234567));
        assertEquals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One", sol.numberToWords(1234567891));
    }

}
