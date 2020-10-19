package com.search2026.leetcode.problems;

import java.util.PriorityQueue;

public class SortTransformedArray {

    /*
        Sort Transformed Array - Heap
        Leetcode #360
        https://github.com/search2026/leetcode_java/blob/master/resources/SortTransformedArray.md
        Difficulty: Medium
     */
    public class Solution {
        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            if (nums == null || nums.length == 0) return new int[]{};
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = a * nums[i] * nums[i] + b * nums[i] + c;
                q.offer(temp);
            }

            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) res[i] = q.poll();

            return res;
        }
    }

    /*
        Sort Transformed Array - Two Pointers
        Leetcode #360
        https://github.com/search2026/leetcode_java/blob/master/resources/SortTransformedArray.md
        Difficulty: Medium
     */
    public class Solution_2 {
        private int cal(int x, int a, int b, int c) {
            return a * x * x + b * x + c;
        }

        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            if (nums == null || nums.length == 0) return new int[]{};
            int n = nums.length, p1 = 0, p2 = n - 1;
            int[] res = new int[n];
            int idx = a >= 0 ? n - 1 : 0;
            while (p1 <= p2) {
                if (a >= 0) {
                    res[idx--] = cal(nums[p1], a, b, c) >= cal(nums[p2], a, b, c) ? cal(nums[p1++], a, b, c) : cal(nums[p2--], a, b, c);
                } else {
                    res[idx++] = cal(nums[p1], a, b, c) >= cal(nums[p2], a, b, c) ? cal(nums[p2--], a, b, c) : cal(nums[p1++], a, b, c);
                }
            }
            return res;
        }
    }

}
