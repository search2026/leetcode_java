package com.search2026.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

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
        }
    }

    /*
        Two Sum II - Two Pointers
        Leetcode #167
        https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
        http://www.cnblogs.com/grandyang/p/5185815.html
        Difficulty: Medium
     */
    public class Solution_2 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) return null;

            int left = 0, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) return new int[]{left + 1, right + 1};
                else if (sum < target) left++;
                else right--;
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
}
