package com.search2026.leetcode.problems;

public class NextPermutation {

    /*
        Next Permutation
        Leetcode #31
        https://leetcode.com/problems/next-permutation/
        Difficulty: Medium
     */
    public class Solution {
        public void nextPermutation(int[] num) {
            if (num == null || num.length == 0 || num.length == 1) return;
            int i = num.length - 2;
            while (i >= 0 && num[i] >= num[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = i;
                while (j < num.length - 1 && num[j + 1] > num[i]) {
                    j++;
                }
                swap(num, i, j);
            }
            reverse(num, i + 1, num.length - 1);
        }

        public void reverse(int[] num, int left, int right) {
            while (left < right) {
                swap(num, left, right);
                left++;
                right--;
            }
        }

        private void swap(int[] num, int i, int j) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }

}
