package two_sum;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSum {
    /*
        Two Sum - HashMap
        Leetcode #1
        https://leetcode.com/problems/two-sum/
        Difficulty: Medium
     */
    public class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null) return null;
            int n = nums.length;
            if (n < 2) return null;
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff)) {
                    return new int[]{map.get(diff), i};
                }
                map.put(nums[i], i);
            }

            return null;
            // throw new IllegalArgumentException("No two summ solution");
        }
    }

    /*
        Two Sum II - Two Pointers
        Leetcode #167
        https://leetcode.com/discuss/oj/two-sum-ii-input-array-is-sorted
        http://www.cnblogs.com/grandyang/p/5185815.html
        Difficulty: Medium
     */
    public class Solution_2 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) return null;

            int p1 = 0, p2 = nums.length - 1;

            while (p1 < p2) {
                int sum = nums[p1] + nums[p2];
                if (sum == target) return new int[]{p1, p2};
                else if (sum < target) p1++;
                else p2--;
            }

            return null;
        }
    }

    /*
        Two Sum III Data Structure
        Leetcode #170
        https://leetcode.com/discuss/questions/oj/two-sum-iii-data-structure-design?sort=votes
        http://www.cnblogs.com/grandyang/p/5184143.html
        Difficulty: Medium
     */
    public class TwoSumDS {
        private Map<Integer, Integer> map;

        TwoSumDS() {
            map = new HashMap<Integer, Integer>();
        }

        public void add(int number) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }

        public boolean find(int target) {
            if (map.size() < 2) return false;

            for (Integer key : map.keySet()) {
                int diff = target - key;
                if (map.containsKey(diff)) {
                    if (diff != key) return true;
                    else if (map.get(key) > 1) return true;
                }
            }

            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new TwoSum().new Solution();
            int[] test = {5, 75, 25};
            assertArrayEquals(new int[]{1, 2}, sol.twoSum(test, 100));
            assertArrayEquals(null, sol.twoSum(test, 99));
        }

        @Test
        public void test2() {
            Solution_2 sol = new TwoSum().new Solution_2();
            int[] test = {5, 25, 75};
            assertArrayEquals(new int[]{1, 2}, sol.twoSum(test, 100));
            assertArrayEquals(null, sol.twoSum(test, 99));
        }

        @Test
        public void test3() {
            TwoSumDS sol = new TwoSum().new TwoSumDS();
            sol.add(1);
            sol.add(3);
            sol.add(5);
            sol.add(4);
            assertTrue(sol.find(4));
            assertTrue(sol.find(7));
            assertFalse(sol.find(10));
        }
    }
}
