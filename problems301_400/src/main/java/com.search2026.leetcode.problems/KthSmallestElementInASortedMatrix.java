package com.search2026.leetcode.problems;

public class KthSmallestElementInASortedMatrix {

    /*
        Kth Smallest Element in a Sorted Matrix
        Leetcode #378
        https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
        Difficulty: Medium
     */
    public class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int[] rows = new int[n];
            int res = matrix[0][0];
            while (k-- > 0) {
                int smallest = Integer.MAX_VALUE;
                int colOfSmallest = 0;
                for (int col = 0; col < n; col++) {
                    if (rows[col] == n) {
                        continue;
                    }
                    if (matrix[rows[col]][col] <= smallest) {
                        smallest = matrix[rows[col]][col];
                        colOfSmallest = col;
                        res = smallest;
                    }
                }
                rows[colOfSmallest]++;
            }
            return res;
        }
    }

    /*
        Kth Smallest Element in a Sorted Matrix - Binary Search
        Leetcode #378
        https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
        Difficulty: Medium
   */
    public class Solution_2 {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int left = matrix[0][0], right = matrix[n - 1][n - 1];
            while (left < right) {
                int mid = left + right >> 1;
                int cnt = 0, j = n - 1;
                for (int i = 0; i < n; i++) {
                    while (j >= 0 && matrix[i][j] > mid) {
                        j--;
                    }
                    cnt += j + 1;
                }
                if (cnt < k)
                    left = mid + 1;
                else
                    right = mid;
            }
            return left;
        }
    }

}
