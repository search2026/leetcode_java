package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestSubstringWithAtLeastKRepeatingCharactersTests {

    @Test
    public void testSolution() {
        LongestSubstringWithAtLeastKRepeatingCharacters.Solution sol =
                new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        assertEquals(3, sol.longestSubstring("aaabb", 3));
//        assertEquals(2, sol.longestSubstring("ababbc", 5));
    }

    @Test
    public void testSolution2() {
        LongestSubstringWithAtLeastKRepeatingCharacters.Solution_2 sol =
                new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution_2();
        assertEquals(3, sol.longestSubstring("aaabb", 3));
//        assertEquals(2, sol.longestSubstring("ababbc", 5));
    }

}
