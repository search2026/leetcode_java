package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

public class ShuffleAnArrayTests {

    @Test
    public void testSolution() {
        // Init an array with set 1, 2, and 3.
        int[] nums = {1, 2, 3};
        ShuffleAnArray.Solution solution = new ShuffleAnArray().new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
        solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
        solution.reset();

// Returns the random shuffling of array [1,2,3].
        solution.shuffle();
    }

}
