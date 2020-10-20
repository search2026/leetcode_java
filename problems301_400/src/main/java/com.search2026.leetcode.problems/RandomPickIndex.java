package com.search2026.leetcode.problems;

import java.util.Random;

public class RandomPickIndex {

    /*
        Random Pick Index - Reservoir Sampling
        Leetcode #398
        https://leetcode.com/problems/random-pick-index/
        Difficulty: Medium
     */
    public class Solution {
        int[] nums;
        Random rnd;

        public Solution(int[] nums) {
            this.nums = nums;
            this.rnd = new Random();
        }

        public int pick(int target) {
            int result = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != target) {
                    continue;
                }
                if (rnd.nextInt(++count) == 0) {
                    result = i;
                }
            }

            return result;
        }
    }


    /*
        Random Pick Index
        Leetcode #398
        https://leetcode.com/problems/random-pick-index/
        Difficulty: Medium
     */
    public class Solution_2 {
        int[] nums;
        Random rand;

        public Solution_2(int[] nums) {
            this.nums = nums;
            this.rand = new Random();
        }

        public int pick(int target) {
            int total = 0;
            int res = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    // randomly select an int from 0 to the nums of target. If x equals 0, set the res as the current
                    // index. The probability is always 1/nums for the latest appeared number. For example, 1 for 1st
                    // num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
                    int x = rand.nextInt(++total);
                    res = x == 0 ? i : res;
                }
            }
            return res;
        }
    }

}
