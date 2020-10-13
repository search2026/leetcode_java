package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithAtMostKDistinctCharactersTests {

    @Test
    public void testSolution() {
        LongestSubstringWithAtMostKDistinctCharacters.Solution sol =
                new LongestSubstringWithAtMostKDistinctCharacters().new Solution();
        assertEquals(3, sol.lengthOfLongestSubstringKDistinct("eceba", 2));
        assertEquals(4, sol.lengthOfLongestSubstringKDistinct("eceba", 3));
    }

    @Test
    public void testSolution2() {
        LongestSubstringWithAtMostKDistinctCharacters.Solution_2 sol =
                new LongestSubstringWithAtMostKDistinctCharacters().new Solution_2();
        assertEquals(3, sol.lengthOfLongestSubstringKDistinct("eceba", 2));
        assertEquals(4, sol.lengthOfLongestSubstringKDistinct("eceba", 3));
    }

}
