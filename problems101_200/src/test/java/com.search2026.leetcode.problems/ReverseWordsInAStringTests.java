package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsInAStringTests {

    @Test
    public void testSolution() {
        ReverseWordsInAString.Solution sol = new ReverseWordsInAString().new Solution();
        assertEquals("blue is sky the", sol.reverseWords("the sky is blue"));
    }

    @Test
    public void testSolution2() {
        ReverseWordsInAString.Solution_2 sol = new ReverseWordsInAString().new Solution_2();
        char[] test = "the sky is blue".toCharArray();
        char[] expected = "blue is sky the".toCharArray();
        sol.reverseWords(test);
        assertArrayEquals(expected, test);
    }

}
