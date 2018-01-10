package partition_to_k_equal_sum_subsets;

import org.junit.*;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class PartitiontoKEqualSumSubsets {
    /*
        Partition to K Equal Sum Subsets
        Leetcode #698
        https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
        Difficult: Hard
     */
    public class Solution {
        private boolean search(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target) {
            if (k == 1) return true;
            if (cur_sum == target && cur_num > 0) {
                return search(nums, visited, 0, k - 1, 0, 0, target);
            }
            for (int i = start_index; i < nums.length; i++) {
                if (visited[i] == 1) continue;
                visited[i] = 1;
                if (search(nums, visited, i + 1, k, cur_sum + nums[i], cur_num++, target)) return true;
                visited[i] = 0;
            }
            return false;
        }

        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0) return false;
            int sum = 0;
            for (int num : nums) sum += num;
            if (sum < k || sum % k != 0) return false;
            int[] visited = new int[nums.length];
            return search(nums, visited, 0, k, 0, 0, sum / k);
        }
    }

    /*
        Partition to K Equal Sum Subsets
        Leetcode #698
        https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
        Difficult: Hard
     */
    public class Solution_2 {
        HashMap<Integer, Integer> map = new HashMap<>();

        private boolean search(int[] nums, int sum, int[] p, int idx) {
            if (idx == -1) {
                for (int s : p) if (s != sum) return false;
                return true;
            }

            int num = nums[idx];

            for (int i = 0; i < p.length; i++) {
                if (p[i] + num <= sum) {
                    p[i] += num;
                    if (search(nums, sum, p, idx - 1)) return true;
                    p[i] -= num;
                }
            }
            return false;
        }

        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0) return false;
            Arrays.sort(nums);
            int sum = 0;
            for (int num : nums) sum += num;
            if (sum % k != 0 || sum < k) return false;
            sum = sum / k;
            return search(nums, sum, new int[k], nums.length - 1);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PartitiontoKEqualSumSubsets().new Solution();
            int[] nums = {4, 3, 2, 3, 5, 2, 1};
            assertTrue(sol.canPartitionKSubsets(nums, 4));
            assertTrue(sol.canPartitionKSubsets(nums, 2));
            assertFalse(sol.canPartitionKSubsets(nums, 3));

            nums = new int[]{-1,1,0,0};
            // assertFalse(sol.canPartitionKSubsets(nums, 4));
            // assertTrue(sol.canPartitionKSubsets(nums, 2));

            nums = new int[]{-1,1};
            // assertFalse(sol.canPartitionKSubsets(nums, 1));
            // assertFalse(sol.canPartitionKSubsets(nums, 2));

            nums = new int[]{-1,1,0};
            // assertFalse(sol.canPartitionKSubsets(nums, 1));
            // assertFalse(sol.canPartitionKSubsets(nums, 2));
        }

        @Test
        public void test2() {
            Solution_2 sol = new PartitiontoKEqualSumSubsets().new Solution_2();
            int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
            assertTrue(sol.canPartitionKSubsets(nums, 4));
            assertTrue(sol.canPartitionKSubsets(nums, 2));
            assertFalse(sol.canPartitionKSubsets(nums, 3));

            nums = new int[]{-1,1,0,0};
            // assertFalse(sol.canPartitionKSubsets(nums, 4));
            // assertTrue(sol.canPartitionKSubsets(nums, 2));

            nums = new int[]{-1,1};
            // assertFalse(sol.canPartitionKSubsets(nums, 1));
            // assertFalse(sol.canPartitionKSubsets(nums, 2));

            nums = new int[]{-1,1,0};
            // assertFalse(sol.canPartitionKSubsets(nums, 1));
            // assertFalse(sol.canPartitionKSubsets(nums, 2));
        }
    }
}

