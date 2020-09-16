package com.search2026.leetcode.problems;

public class SearchA2DMatrix {

    /*
        Search a 2D Matrix
        Leetcode #74
        https://leetcode.com/problems/search-a-2d-matrix/
        Difficulty: Medium
    */
    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int columns = matrix[0].length;
            int left = 0;
            int right = matrix.length * columns - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int val = matrix[mid / columns][mid % columns];
                if (val < target) {
                    left = mid + 1;
                } else if (val > target) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    /*
        Search a 2D Matrix II
        Leetcode #240
        https://leetcode.com/problems/search-a-2d-matrix-ii/
        Difficulty: Medium
    */
    public class Solution_2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            // check corner case
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            if (matrix[0] == null || matrix[0].length == 0) {
                return false;
            }

            // from bottom left to top right
            int n = matrix.length;
            int m = matrix[0].length;
            int x = n - 1;
            int y = 0;
            int count = 0;

            while (x >= 0 && y < m) {
                if (matrix[x][y] < target) {
                    y++;
                } else if (matrix[x][y] > target) {
                    x--;
                } else {
                    count++;
                    x--;
                    y++;
                }
            }
            if (count == 0) return false;
            return true;
        }
    }

}
