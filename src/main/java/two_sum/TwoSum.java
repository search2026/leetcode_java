package two_sum;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TwoSum {
    /*
        Two Sum
        https://leetcode.com/problems/two-sum/
        Difficulty: Medium
     */
    public class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(nums[0], 1);
            for (int i = 1; i < nums.length; ++i) {
                int diff = target - nums[i];
                if (map.containsKey(diff)) {
                    return new int[]{map.get(diff), i + 1};
                } else map.put(nums[i], i + 1);
            }
            return null;
        }
    }

    /*
        Two Sum II Input Array is sorted
        http://www.programcreek.com/2014/03/two-sum-ii-input-array-is-sorted-java/
        Difficulty: Medium
     */
    public class SolutionII {
        public int[] twoSumII(final int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return null;

            int i = 0;
            int j = nums.length - 1;

            while (i < j) {
                int x = nums[i] + nums[j];
                if (x < target) {
                    ++i;
                } else if (x > target) {
                    j--;
                } else {
                    return new int[]{i + 1, j + 1};
                }
            }

            return null;
        }
    }

    /*
        Two Sum III Data Structure
       http://www.programcreek.com/2014/03/two-sum-iii-data-structure-design-java/
        Difficulty: Medium
     */
    public class SolutionIII {
        private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

        public void add(int number) {
            if (elements.containsKey(number)) {
                elements.put(number, elements.get(number) + 1);
            } else {
                elements.put(number, 1);
            }
        }

        public boolean find(int value) {
            for (Integer i : elements.keySet()) {
                int target = value - i;
                if (elements.containsKey(target)) {
                    if (i == target && elements.get(target) < 2) {
                        continue;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public class TwoSumIII {
    }

    public static class UnitTest {
        @Test
        public void test1() {
            new TwoSum().new Solution().twoSum(new int[]{5, 75, 25}, 100);
        }

        public void test2() {
            new TwoSum().new Solution().twoSum(new int[]{5, 75, 25}, 100);
        }
    }
}
