package rotate_image;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateImage {
    /*
        Rotate Image
        https://leetcode.com/problems/rotate-image/
        leetcode 48
        Difficulty: Medium
     */
    public class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int row = 0; row < n / 2; row++) {
                for (int i = row; i < n - row - 1; i++) {
                    int temp = matrix[row][i];
                    matrix[row][i] = matrix[n - i - 1][row];
                    matrix[n - i - 1][row] = matrix[n - row - 1][n - i - 1];
                    matrix[n - row - 1][n - i - 1] = matrix[i][n - row - 1];
                    matrix[i][n - row - 1] = temp;
                }
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RotateImage().new Solution();
            assertEquals(7, 7);
        }
    }
}
