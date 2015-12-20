package sparse_matrix_multiplication;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SparseMatrixMultiplication {
    /*
        Sparse Matrix Multiplication
        http://blog.csdn.net/u012175043/article/details/50093937
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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SparseMatrixMultiplication().new Solution();
        }
    }
}
