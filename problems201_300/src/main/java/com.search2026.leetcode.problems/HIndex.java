package com.search2026.leetcode.problems;

public class HIndex {

    /*
        H-Index
        Leetcode #274
        https://leetcode.com/problems/h-index/
        Difficulty: Medium
    */
    public class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] countArray = new int[n + 1];

            for (int i = 0; i < n; i++) {
                if (citations[i] >= n) countArray[n]++;
                else countArray[citations[i]]++;
            }

            if (countArray[n] >= n) return n;

            for (int i = n - 1; i >= 0; i--) {
                countArray[i] = countArray[i] + countArray[i + 1];
                if (countArray[i] >= i) return i;
            }
            return 0;
        }
    }

    /*
        H-Index II
        leetcode #275
        https://leetcode.com/problems/h-index-ii/
        Difficulty: Medium
    */
    public class Solution_2 {
        public int hIndex(int[] citations) {
            int n = citations.length;

            int low = 0, high = n - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (citations[mid] == n - mid) return n - mid;
                else if (citations[mid] < n - mid) low = mid + 1;
                else high = mid - 1;
            }
            return n - low;
        }
    }

}
