package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveZeroesTests {

    @Test
    public void testSolution() {
        MoveZeroes.Solution sol = new MoveZeroes().new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums);
        int[] res = {1, 3, 12, 0, 0};
        Assertions.assertArrayEquals(res, nums);
    }

}
