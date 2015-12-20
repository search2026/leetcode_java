package _3sum_closest;

import java.util.Arrays;

public class _3SumClosest {

    public class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int minSum = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int twoSum = target - nums[i];
                int begin = i + 1;
                int end = nums.length - 1;
                while (begin < end) {
                    int sum = nums[begin] + nums[end];
                    if (Math.abs(twoSum - sum) < Math.abs(target - minSum)) {
                        minSum = sum + nums[i];
                    }
                    if (sum < twoSum) {
                        begin++;
                    } else if (sum > twoSum) {
                        end--;
                    } else {
                        return target;
                    }
                }
            }
            return minSum;
        }
    }

    public static class UnitTest {

    }
}
