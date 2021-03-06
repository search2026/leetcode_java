package com.search2026.leetcode.problems;

public class PartitionEqualSubsetSum {

    /*
        Partition Equal Subset Sum
        Leetcode #416
        https://leetcode.com/problems/partition-equal-subset-sum/
        Difficulty: Medium
     */
    public class Solution {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return true;
            }

            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if ((sum & 1) == 1) {
                return false;
            }
            sum /= 2;

            int n = nums.length;
            boolean[] dp1 = new boolean[sum + 1];
            boolean[] dp2 = new boolean[sum + 1];
            dp1[0] = true;
            dp2[0] = true;

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < sum + 1; j++) {
                    dp2[j] = dp1[j];
                    if (j >= nums[i - 1]) {
                        dp2[j] = (dp1[j] || dp1[j - nums[i - 1]]);
                    }
                }
                for (int j=1; j < sum + 1; j++) {
                    dp1[j] = dp2[j];
                }
            }

            return dp1[sum];
        }
    }

    /*
        Partition Equal Subset Sum
        Leetcode #416
        https://leetcode.com/problems/partition-equal-subset-sum
        Difficulty: Medium
     */
    public class Solution_2 {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return true;
            }

            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) {
                return false;
            }
            sum /= 2;

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;

            for (int i = 1; i <= nums.length; i++) {
                for (int j = sum; j >= nums[i-1]; j--) {
                    dp[j] = dp[j] || dp[j - nums[i-1]];
                }
            }
            return dp[sum];
        }
    }

}
