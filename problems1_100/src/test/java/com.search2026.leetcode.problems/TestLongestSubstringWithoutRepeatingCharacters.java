package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLongestSubstringWithoutRepeatingCharacters {
    @Test
    public void test1() {
        LongestSubstringWithoutRepeatingCharacters.Solution sol = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, sol.lengthOfLongestSubstring("bbbb"));
        assertEquals(3, sol.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void test2() {
        LongestSubstringWithoutRepeatingCharacters.Solution_2 sol = new LongestSubstringWithoutRepeatingCharacters().new Solution_2();
        assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, sol.lengthOfLongestSubstring("bbbb"));
        assertEquals(3, sol.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void test3() {
        LongestSubstringWithoutRepeatingCharacters.Solution_3 sol = new LongestSubstringWithoutRepeatingCharacters().new Solution_3();
        assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, sol.lengthOfLongestSubstring("bbbb"));
        assertEquals(3, sol.lengthOfLongestSubstring("pwwkew"));
    }

}
