package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /*
    Spiral Matrix
    Leetcode #54
    https://leetcode.com/problems/spiral-matrix/
    Difficulty: Medium
 */
    public class Solution {
        int[][] dirs = new int[][] {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0 ||
                        matrix[0] == null || matrix[0].length == 0) return res;

            int m = matrix.length, n = matrix[0].length;
            boolean[][] seen = new boolean[m][n];
            int row = 0, col = 0, di = 0;
            for (int i = 0; i < m * n; i++) {
                res.add(matrix[row][col]);
                seen[row][col] = true;
                int newRow = row + dirs[di][0];
                int newCol = col + dirs[di][1];
                if (0 <= newRow && newRow < m && 0 <= newCol && newCol < n && !seen[newRow][newCol]) {
                    row = newRow;
                    col = newCol;
                } else {
                    di = (di + 1) % 4;
                    row += dirs[di][0];
                    col += dirs[di][1];
                }
            }
            return res;
        }
    }

    /*
        Spiral Matrix
        Leetcode #54
        https://leetcode.com/problems/spiral-matrix/
        Difficulty: Medium
     */
    public class Solution_2 {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> spiralList = new ArrayList<>();
            if (matrix == null || matrix.length == 0 ||
                        matrix[0] == null || matrix[0].length == 0) return spiralList;

            int rowStart = 0;
            int rowEnd = matrix.length - 1;
            int colStart = 0;
            int colEnd = matrix[0].length - 1;

            while (rowStart <= rowEnd && colStart <= colEnd) {
                for (int j = colStart; j <= colEnd; j++) spiralList.add(matrix[rowStart][j]);
                if (++rowStart > rowEnd) break;

                for (int i = rowStart; i <= rowEnd; i++) spiralList.add(matrix[i][colEnd]);
                if (--colEnd < colStart) break;

                for (int j = colEnd; j >= colStart; j--) spiralList.add(matrix[rowEnd][j]);
                if (--rowEnd < rowStart) break;

                for (int i = rowEnd; i >= rowStart; i--) spiralList.add(matrix[i][colStart]);
                if (colStart++ > colEnd) break;
            }

            return spiralList;
        }
    }

    /*
        Spiral Matrix
        Leetcode #54
        https://leetcode.com/problems/spiral-matrix/
        Difficulty: Medium
     */
    public class Solution_3 {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> spiralList = new ArrayList<>();
            if (matrix == null || matrix.length == 0 ||
                        matrix[0] == null || matrix[0].length == 0) return spiralList;

            int rowStart = 0;
            int rowEnd = matrix.length - 1;
            int colStart = 0;
            int colEnd = matrix[0].length - 1;

            while (rowStart <= rowEnd && colStart <= colEnd) {
                // Traverse Right
                for (int j = colStart; j <= colEnd; j++) {
                    spiralList.add(matrix[rowStart][j]);
                }
                rowStart++;

                // Traverse Down
                for (int i = rowStart; i <= rowEnd; i++) {
                    spiralList.add(matrix[i][colEnd]);
                }
                colEnd--;

                if (rowStart <= rowEnd) {
                    // Traverse Left
                    for (int j = colEnd; j >= colStart; j--) {
                        spiralList.add(matrix[rowEnd][j]);
                    }
                }
                rowEnd--;

                if (colStart <= colEnd) {
                    // Traver Up
                    for (int i = rowEnd; i >= rowStart; i--) {
                        spiralList.add(matrix[i][colStart]);
                    }
                }
                colStart++;
            }

            return spiralList;
        }
    }

    /*
        Spiral Matrix II
        Leetcode #59
        https://leetcode.com/problems/spiral-matrix-ii/
        Difficulty: Medium
     */
    public class Solution_4 {
        public int[][] generateMatrix(int n) {
            if (n < 0) return new int[][]{};
            int[][] matrix = new int[n][n];
            if (n == 0) return matrix;

            int num = 1;
            int rowStart = 0, rowEnd = n - 1;
            int colStart = 0, colEnd = n - 1;

            while (rowStart <= rowEnd && colStart <= colEnd) {
                for (int j = colStart; j <= colEnd; j++) {
                    matrix[rowStart][j] = num++;
                }
                if (++rowStart > rowEnd) break;

                for (int i = rowStart; i <= rowEnd; i++) {
                    matrix[i][colEnd] = num++;
                }
                if (--colEnd < colStart) break;

                for (int j = colEnd; j >= colStart; j--) {
                    matrix[rowEnd][j] = num++;
                }
                if (--rowEnd < rowStart) break;

                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = num++;
                }
                if (++colStart > colEnd) break;
            }

            return matrix;
        }
    }

    /*
        Spiral Matrix II
        Leetcode #59
        https://leetcode.com/problems/spiral-matrix-ii/
        Difficulty: Medium
     */
    public class Solution_5 {
        public int[][] generateMatrix(int n) {
            if (n < 0) return new int[][]{};
            int[][] matrix = new int[n][n];
            if (n == 1) return matrix;

            int rowStart = 0, rowEnd = n - 1;
            int colStart = 0, colEnd = n - 1;
            int num = 1;

            while (rowStart <= rowEnd && colStart <= colEnd) {
                for (int j = colStart; j <= colEnd; j++) {
                    matrix[rowStart][j] = num++;
                }
                rowStart++;

                for (int i = rowStart; i <= rowEnd; i++) {
                    matrix[i][colEnd] = num++;
                }
                colEnd--;

                if (rowStart <= rowEnd) {
                    for (int j = colEnd; j >= colStart; j--) {
                        matrix[rowEnd][j] = num++;
                    }
                    rowEnd--;
                }

                if (colStart <= colEnd) {
                    for (int i = rowEnd; i >= rowStart; i--) {
                        matrix[i][colStart] = num++;
                    }
                    colStart++;
                }
            }

            return matrix;
        }
    }

}
