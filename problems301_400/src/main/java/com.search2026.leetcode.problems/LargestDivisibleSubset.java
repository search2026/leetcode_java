package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {

    /*
        Largest Divisible Subset - Dynamic Programming
        Leetcode #368
        https://leetcode.com/problems/largest-divisible-subset/
        Difficulty: Medium
     */
    public class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> maxSeq = new ArrayList<>();
            if (nums == null) return maxSeq;
            int n = nums.length;
            if (n == 0) return maxSeq;
            if (n == 1) return new ArrayList<Integer>() {{
                add(nums[0]);
            }};

            Arrays.sort(nums);
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int maxCount = 1;

            for (int i = 1; i < nums.length; i++) {
                int localMax = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] % nums[j] == 0) {
                        localMax = Math.max(localMax, dp[j] + 1);
                    }
                }
                dp[i] = localMax;
                maxCount = Math.max(maxCount, dp[i]);
            }

            for (int i = n - 1; i >= 0; i--) {
                if (dp[i] == maxCount) {
                    maxSeq.add(0, nums[i]);
                    maxCount--;
                }
            }

            return maxSeq;
        }
    }

    /*
        Largest Divisible Subset - Brute Force
        Leetcode #368
        https://leetcode.com/problems/largest-divisible-subset/
        Difficulty: Medium
     */
    // ToDo: Not working yet
    public class Solution_2 {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> maxSeq = new LinkedList<>();
            if (nums == null) return maxSeq;
            int n = nums.length;
            if (n == 0) return maxSeq;

            Arrays.sort(nums);
            for (int i = 0; i < n; i++) {
                LinkedList<Integer> currList = new LinkedList<>();
                currList.add(nums[i]);
                for (int j = i - 1; j >= 0; j--) {
                    if (currList.getFirst() % nums[j] == 0) {
                        currList.addFirst(nums[j]);
                    }
                }

                if (currList.size() > maxSeq.size()) {
                    maxSeq = currList;
                }
            }

            return maxSeq;
        }
    }

    /*
      Largest Divisible Subset - Brute Force
      Leetcode #368
      https://leetcode.com/problems/largest-divisible-subset/
      Difficulty: Medium
   */
    public class Solution_3 {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> maxSeq = new LinkedList<>();
            if (nums == null) return maxSeq;
            int n = nums.length;
            if (n == 0) return maxSeq;

            Arrays.sort(nums);
            for (int i = n - 1; i >= 0; i--) {
                LinkedList<Integer> currList = new LinkedList<>();
                currList.add(nums[i]);
                for (int j = i - 1; j >= 0; j--) {
                    if (currList.getFirst() % nums[j] == 0) {
                        currList.addFirst(nums[j]);
                    }
                }

                if (currList.size() > maxSeq.size()) {
                    maxSeq = currList;
                }
            }

            return maxSeq;
        }
    }

}
