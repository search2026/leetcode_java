package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPickIndexTests {

    @Test
    public void testSolution() {
        int[] nums = {1, 2, 3, 3, 3};
        RandomPickIndex.Solution sol = new RandomPickIndex().new Solution(nums);
        sol.pick(3);
        sol.pick(1);
    }

    @Test
    public void testSolution2() {
        int[] nums = {1, 2, 3, 3, 3};
        RandomPickIndex.Solution_2 sol = new RandomPickIndex().new Solution_2(nums);
        sol.pick(3);
        sol.pick(1);
    }

}
