package max_sum_of_rectangle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSumofRectangle {
  /*
      Max Sum of Rectangle
      http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
      Difficulty: Hard
   */
  public class Solution {
    /**
     * To find maxSum in 1d array
     * return {maxSum, left, right}
     */
    private int[] kadane(int[] a) {
      //result[0] == maxSum, result[1] == start, result[2] == end;
      int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
      int currentSum = 0;
      int localStart = 0;

      for (int i = 0; i < a.length; i++) {
        currentSum += a[i];
        if (currentSum < 0) {
          currentSum = 0;
          localStart = i + 1;
        } else if (currentSum > result[0]) {
          result[0] = currentSum;
          result[1] = localStart;
          result[2] = i;
        }
      }

      //all numbers in a are negative
      if (result[2] == -1) {
        result[0] = 0;
        for (int i = 0; i < a.length; i++) {
          if (a[i] > result[0]) {
            result[0] = a[i];
            result[1] = i;
            result[2] = i;
          }
        }
      }

      return result;
    }

    public int maxSumSubmatrix(int[][] matrix) {
      if (matrix == null || matrix.length == 0 ||
              matrix[0] == null || matrix[0].length == 0) return 0;

      int m = matrix.length;
      int n = matrix[0].length;
      int[] currentResult;
      int maxSum = Integer.MIN_VALUE;
      int left = 0;
      int top = 0;
      int right = 0;
      int bottom = 0;

      for (int leftCol = 0; leftCol < n; leftCol++) {
        int[] tmp = new int[m];

        for (int rightCol = leftCol; rightCol < n; rightCol++) {

          for (int i = 0; i < m; i++) {
            tmp[i] += matrix[i][rightCol];
          }
          currentResult = kadane(tmp);
          if (currentResult[0] > maxSum) {
            maxSum = currentResult[0];
            left = leftCol;
            top = currentResult[1];
            right = rightCol;
            bottom = currentResult[2];
          }
        }
      }

      return maxSum;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new MaxSumofRectangle().new Solution();
      int[][] matrix = {
              {1, 0, 1},
              {0, -2, 3}
      };
      assertEquals(4, sol.maxSumSubmatrix(matrix));
      matrix = new int[][]{
              {1, 2, -1, -4, -20},
              {-8, -3, 4, 2, 1},
              {3, 8, 10, 1, 3},
              {-4, -1, 1, 7, -6}
      };
      assertEquals(29, sol.maxSumSubmatrix(matrix));
    }
  }
}

