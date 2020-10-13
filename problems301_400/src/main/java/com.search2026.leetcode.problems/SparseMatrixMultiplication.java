package com.search2026.leetcode.problems;

public class SparseMatrixMultiplication {

    /*
        Sparse Matrix Multiplication
        Leetcode #311
        https://github.com/search2026/leetcode_java/blob/master/resources/SparseMatrixMultiplication.md
        Difficulty: Easy
     */
    public class Solution {
        public int[][] multiply(int[][] A, int[][] B) {
            int rowA = A.length;
            int colA = A[0].length;
            int rowB = B.length;
            int colB = B[0].length;

            int[][] res = new int[rowA][colB];

            for (int i = 0; i < rowA; i++) {
                for (int k = 0; k < colA; k++) {
                    if (A[i][k] != 0) {
                        for (int j = 0; j < colB; j++) {
                            res[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }

            return res;
        }
    }

}
