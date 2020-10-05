package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SlidingWindowMaximumTests {

    @Test
    public void test1() {
        SlidingWindowMaximum.Solution sol = new SlidingWindowMaximum().new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = sol.maxSlidingWindow(nums, 3);
        assertArrayEquals(new int[]{3,3,5,5,6,7}, res);
    }

}
