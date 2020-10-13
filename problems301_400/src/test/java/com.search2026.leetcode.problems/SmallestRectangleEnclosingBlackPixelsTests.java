package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmallestRectangleEnclosingBlackPixelsTests {

    @Test
    public void test1() {
        SmallestRectangleEnclosingBlackPixels.Solution sol = new SmallestRectangleEnclosingBlackPixels().new Solution();
        char[][] iImage = {
                {'0','0', '1', '0'},
                {'0','1', '1', '0'},
                {'0','1', '0', '0'},
        };
        assertEquals(6, sol.minArea(iImage, 0, 2));
    }

}
