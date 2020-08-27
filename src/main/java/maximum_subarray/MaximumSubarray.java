package maximum_subarray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarray {
    /*
        Maximum Subarray - Dynamic Programming
        Leetcode #53
        https://leetcode.com/problems/maximum-subarray/
        Difficulty: Medium
     */
    public class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0)
                throw new IllegalArgumentException("null or empty input array");

            int localMax = nums[0], globalMax = nums[0];
            for (int i = 1; i < nums.length; i++) {
                localMax = Math.max(localMax + nums[i], nums[i]);
                globalMax = Math.max(globalMax, localMax);
            }
            return globalMax;
        }
    }

    /*
    Maximum Subarray - Dynamic Programming
    Leetcode #53
    https://leetcode.com/problems/maximum-subarray/
    Difficulty: Medium
  */
    public class Solution_2 {
        private void search(int[] nums, int[] rslt, int left, int right) {
            if (left == right) {
                Arrays.fill(rslt, nums[left]);
                return;
            }

            int mid = left + (right - left) / 2;
            int[] leftRslt = new int[4];
            search(nums, leftRslt, left, mid);
            int[] rightRslt = new int[4];
            search(nums, rightRslt, mid + 1, right);

            rslt[0] = Math.max(Math.max(leftRslt[0], rightRslt[0]), leftRslt[2] + rightRslt[1]);
            rslt[1] = Math.max(leftRslt[1], leftRslt[3] + +rightRslt[1]);
            rslt[2] = Math.max(rightRslt[2], rightRslt[3] + +leftRslt[2]);
            rslt[3] = leftRslt[3] + rightRslt[3];
        }

        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0)
                throw new IllegalArgumentException("null or empty input array");

            int[] rslt = new int[4]; //maxSoFar, leftMax, rightMax, currSum
            search(nums, rslt, 0, nums.length - 1);
            return rslt[0];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MaximumSubarray().new Solution();
            assertEquals(6, sol.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        }

        @Test
        public void test2() {
            Solution_2 sol = new MaximumSubarray().new Solution_2();
            assertEquals(6, sol.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        }
    }
}
