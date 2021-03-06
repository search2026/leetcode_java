package com.search2026.leetcode.problems;

public class JumpGame {

    /*
        Jump Game - Dynamic Programming
        leetcode #55
        https://leetcode.com/problems/jump-game/
        Difficulty: Medium
     */
    public class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int n = nums.length;

            int cur = 0;
            for (int i = 0; i < n && i <= cur; i++) {
                cur = Math.max(cur, nums[i] + i);
                if (cur >= n - 1) return true;
            }
            return false;
        }
    }

    /*
        Jump Game - Checking "0" points
        leetcode #55
        https://leetcode.com/problems/jump-game/
        Difficulty: Medium
    */
    public class Solution_2 {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) return true;

            int count = 0;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] == 0) {
                    boolean jumpFlag = false;
                    for (int j = i - 1; j >= 0; j--) {
                        if (nums[j] > i - j) {
                            jumpFlag = true;
                            break;
                        }
                    }
                    if (!jumpFlag) return false;
                }
            }
            return true;
        }
    }

    /*
        Jump Game II
        Leetcode #45
        https://leetcode.com/problems/jump-game-ii/
        Difficulty: Hard
    */
    public class Solution_3 {
        public int jump(int[] nums) {
            if (nums == null || nums.length <= 1) return 0;
            int last_reach = 0;
            int global = 0;
            int steps = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > steps) {
                    steps = global;
                    last_reach++;
                }
                global = Math.max(global, i + nums[i]);
            }
            return last_reach;
        }
    }

}
