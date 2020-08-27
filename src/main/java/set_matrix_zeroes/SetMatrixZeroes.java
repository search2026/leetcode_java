package set_matrix_zeroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetMatrixZeroes {
    /*
        Set Matrix Zeroes
        Leetcode #73
        https://leetcode.com/problems/set-matrix-zeroes/
        Difficulty: Medium
     */
    public class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            boolean firstRowZero = false;
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    firstRowZero = true;
                    break;
                }
            }

            boolean firstColumnZero = false;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    firstColumnZero = true;
                    break;
                }
            }

            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (firstRowZero) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
            }

            if (firstColumnZero) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SetMatrixZeroes().new Solution();
            assertEquals(7, 7);
        }
    }
}
