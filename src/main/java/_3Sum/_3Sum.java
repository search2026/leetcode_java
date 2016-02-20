package _3Sum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class _3Sum {
    /*
        3 Sum
        https://leetcode.com/problems/3sum/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    int start = i + 1;
                    int end = nums.length - 1;
                    while (start < end) {
                        if (nums[start] + nums[end] == -nums[i]) {
                            List<Integer> solution = new ArrayList<Integer>();
                            solution.add(nums[i]);
                            solution.add(nums[start]);
                            solution.add(nums[end]);
                            result.add(solution);
                            int startnum = nums[start];
                            int endnum = nums[end];
                            while (start < nums.length && nums[start] == startnum) {
                                start++;
                            }
                            while (end >= 0 && nums[end] == endnum) {
                                end--;
                            }
                        } else if (nums[start] + nums[end] < -nums[i]) {
                            start++;
                        } else {
                            end--;
                        }
                    }
                }
            }
            return result;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new _3Sum().new Solution();
            assertTrue(true);
        }
    }
}
