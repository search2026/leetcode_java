package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestAbsoluteFilePathTests {

    @Test
    public void testSolution() {
        LongestAbsoluteFilePath.Solution sol = new LongestAbsoluteFilePath().new Solution();
        assertEquals(20, sol.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\\n\t\tfile.ext"));
        assertEquals(32, sol.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

}
