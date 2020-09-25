package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithAtMostTwoDistinctCharactersTests {

    @Test
    public void testSolution() {
        LongestSubstringWithAtMostTwoDistinctCharacters.Solution sol = new LongestSubstringWithAtMostTwoDistinctCharacters().new Solution();
        assertEquals(3, sol.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    @Test
    public void testSolution2() {
        LongestSubstringWithAtMostTwoDistinctCharacters.Solution_2 sol = new LongestSubstringWithAtMostTwoDistinctCharacters().new Solution_2();
        assertEquals(3, sol.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    @Test
    public void testSolution3() {
        LongestSubstringWithAtMostTwoDistinctCharacters.Solution_3 sol = new LongestSubstringWithAtMostTwoDistinctCharacters().new Solution_3();
        assertEquals(3, sol.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

}
