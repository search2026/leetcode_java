package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductOfArrayExceptSelfTests {

    @Test
    public void testSolution() {
        ProductOfArrayExceptSelf.Solution sol = new ProductOfArrayExceptSelf().new Solution();
        int[] nums = {1,2,3,4};
        assertArrayEquals(new int[]{24,12,8,6}, sol.productExceptSelf(nums));
    }

}
