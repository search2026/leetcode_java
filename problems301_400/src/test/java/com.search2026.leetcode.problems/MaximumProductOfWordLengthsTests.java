package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaximumProductOfWordLengthsTests {

    @Test
    public void testSolution() {
        MaximumProductOfWordLengths.Solution sol = new MaximumProductOfWordLengths().new Solution();
        String[] strs = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        assertEquals(16, sol.maxProduct(strs));

        strs = new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        assertEquals(4, sol.maxProduct(strs));

        strs = new String[]{"a", "aa", "aaa", "aaaa"};
        assertEquals(0, sol.maxProduct(strs));
    }

}
