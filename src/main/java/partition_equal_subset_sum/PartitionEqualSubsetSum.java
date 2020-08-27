package partition_equal_subset_sum;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PartitionEqualSubsetSum {
    /*
        Partition Equal Subset Sum
        Leetcode #416
        https://leetcode.com/problems/partition-equal-subset-sum/description/
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
        https://leetcode.com/problems/partition-equal-subset-sum/description/
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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PartitionEqualSubsetSum().new Solution();
            int[] nums = new int[]{1, 5, 11, 5};
            assertTrue(sol.canPartition(nums));
            nums = new int[]{1, 2, 3, 5};
            assertFalse(sol.canPartition(nums));
        }

        @Test
        public void test2() {
            Solution_2 sol = new PartitionEqualSubsetSum().new Solution_2();
            int[] nums = new int[]{1, 5, 11, 5};
            assertTrue(sol.canPartition(nums));
            nums = new int[]{1, 2, 3, 5};
            assertFalse(sol.canPartition(nums));
        }
    }
}

