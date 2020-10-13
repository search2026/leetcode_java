package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReverseVowelsOfaStringTests {

    @Test
    public void test1() {
        ReverseVowelsOfaString.Solution sol = new ReverseVowelsOfaString().new Solution();
        assertEquals("", sol.reverseVowels(""));
        assertEquals("", sol.reverseVowels(null));
        assertEquals("s", sol.reverseVowels("s"));
        assertEquals("e", sol.reverseVowels("e"));
        assertEquals("holle", sol.reverseVowels("hello"));
        assertEquals("leetcode", sol.reverseVowels("leotcede"));
        assertEquals("abcccd", sol.reverseVowels("abcccd"));
    }

}
