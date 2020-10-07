package com.search2026.leetcode.problems;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class LongestIncreasingSubsequence {

    /*
        Longest Increasing Subsequence - Dynamic Programming
        Leetcode #300
        https://leetcode.com/problems/longest-increasing-subsequence/
        Difficulty: Medium
     */
    public class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null) return 0;
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return 1;

            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int maxLen = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++)
                maxLen = Math.max(dp[i], maxLen);

            return maxLen;
        }
    }

    /*
        Longest Increasing Subsequence - Binary Search
        Leetcode #300
        https://leetcode.com/problems/longest-increasing-subsequence/
        http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
        Difficulty: Medium
     */
    public class Solution_2 {
        // Binary search (note boundaries in the caller)
        private int CeilIndex(int nums[], int left, int right, int key) {
            while (right - left > 1) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= key) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            return right;
        }

        public int lengthOfLIS(int[] nums) {
            if (nums == null) return 0;
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return 1;

            int[] tailTable = new int[n];
            tailTable[0] = nums[0];
            int len = 1; // always points empty slot
            for (int i = 1; i < n; i++) {
                if (nums[i] < tailTable[0])
                    // new smallest value
                    tailTable[0] = nums[i];
                else if (nums[i] > tailTable[len - 1])
                    // A[i] wants to extend largest subsequence
                    tailTable[len++] = nums[i];
                else
                    // A[i] wants to be current end candidate of an existing
                    // subsequence. It will replace ceil value in tailTable
                    tailTable[CeilIndex(tailTable, -1, len - 1, nums[i])] = nums[i];
            }

            return len;
        }
    }

    /*
        Longest Increasing Subsequence - Dynamic Programming + Binary Search
        Leetcode #300
        https://leetcode.com/problems/longest-increasing-subsequence/
        Difficulty: Medium
     */
    public class Solution_3 {
        public int lengthOfLIS(int[] nums) {
            if (nums == null) return 0;
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return 1;

            int[] dp = new int[n];
            int maxLen = 0;
            for (int x : nums) {
                int i = Arrays.binarySearch(dp, 0, maxLen, x);
                if (i < 0) i = -(i + 1);
                dp[i] = x;
                if (i == maxLen) {
                    maxLen++;
                }
            }

            return maxLen;
        }
    }

    /*
        Longest Increasing Subsequence - Dynamic Programming + Binary Search
        Leetcode #300
        https://leetcode.com/problems/longest-increasing-subsequence/
        Difficulty: Medium
     */
    public class Solution_4 {
        public int lengthOfLIS(int[] nums) {
            if (nums == null) return 0;
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return 1;

            NavigableSet<Integer> set = new TreeSet<>();
            for (Integer a : nums) {
                if (!set.add(a)) continue;
                Integer it = set.higher(a);
                if (it != null) set.remove(it);
            }
            return set.size();
        }
    }

}
