package com.search2026.leetcode.problems;

public class RemoveElement {

    /*
        Remove Element
        leetcode #27
        https://leetcode.com/problems/remove-element/
        Difficulty: Easy
     */
    public class Solution {
        public int removeElement(int[] nums, int val) {
            int len = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[len++] = nums[i];
                }
            }
            return len;
        }
    }

}
