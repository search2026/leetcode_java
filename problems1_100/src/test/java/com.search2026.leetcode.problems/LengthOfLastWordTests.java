package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthOfLastWordTests {

    @Test
    public void testSolution() {
        LengthOfLastWord.Solution sol = new LengthOfLastWord().new Solution();
        assertEquals(5, sol.lengthOfLastWord("Hello World"));
    }

}
