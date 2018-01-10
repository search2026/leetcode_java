package max_sum_of_rectangle_no_larger_than_k;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSumofRectangleNoLargerThanK {
  /*
      Max Sum of Rectangle No Larger Than K - Kadane's Algorithm
      Leetcode #363
      https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/
      http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
      Difficulty: Hard
   */
  public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
      if (matrix == null || matrix.length == 0 ||
              matrix[0] == null || matrix[0].length == 0) return 0;

      int m = matrix.length, n = matrix[0].length;
      int maxSum = Integer.MIN_VALUE;

      for (int leftCol = 0; leftCol < n; leftCol++) {
        int[] sums = new int[m];
        for (int rightCol = leftCol; rightCol < n; rightCol++) {
          for (int i = 0; i < m; i++) {
            sums[i] += matrix[i][rightCol];
          }

          TreeSet<Integer> set = new TreeSet<>();
          set.add(0);
          int currSum = 0;

          for (int sum : sums) {
            currSum += sum;
            //we use sum subtraction (curSum - sum) to get the subarray with sum <= k
            //therefore we need to look for the smallest sum >= currSum - k
            Integer num = set.ceiling(currSum - k);
            if (num != null) maxSum = Math.max(maxSum, currSum - num);
            set.add(currSum);
          }
        }
      }

      return maxSum;
    }
  }

  /*
      Max Sum of Rectangle No Larger Than K - Kadane's Algorithm
      Leetcode #363
      https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/
      Difficulty: Hard
   */
  public class Solution_2 {
    public int maxSumSubmatrix(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0 ||
              matrix[0] == null || matrix[0].length == 0) return 0;

      int row = matrix.length, col = matrix[0].length;
      // optimization of space usage
      boolean colIsBig = col > row;
      int m = Math.min(row, col);
      int n = Math.max(row, col);
      int maxSum = Integer.MIN_VALUE;

      for (int i = 0; i < m; i++) {
        int[] sumArray = new int[n];
        for (int j = i; j >= 0; j--) {
          int val = 0;
          TreeSet<Integer> set = new TreeSet<Integer>();
          set.add(0); // padding
          for (int k = 0; k < n; k++) {
            sumArray[k] = sumArray[k] + (colIsBig ? matrix[j][k] : matrix[k][j]);
            val = val + sumArray[k];
            Integer currSum = set.ceiling(val - target);
            if (null != currSum) {
              maxSum = Math.max(maxSum, val - currSum);
            }
            set.add(val);
          }
        }
      }

      return maxSum;
    }
  }

  /*
      Max Sum of Rectangle No Larger Than K - Binary Search (O(n^3logn)
      Leetcode #363
      https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/
      Difficulty: Hard
   */
  public class Solution_3 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
      if (matrix == null || matrix.length == 0 ||
              matrix[0] == null || matrix[0].length == 0) return 0;

      int m = matrix.length, n = matrix[0].length;
      int[][] areas = new int[m][n];
      for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
          int area = matrix[r][c];
          if (r - 1 >= 0)
            area += areas[r - 1][c];
          if (c - 1 >= 0)
            area += areas[r][c - 1];
          if (r - 1 >= 0 && c - 1 >= 0)
            area -= areas[r - 1][c - 1];
          areas[r][c] = area;
        }
      }

      int maxSum = Integer.MIN_VALUE;
      for (int r1 = 0; r1 < m; r1++) {
        for (int r2 = r1; r2 < m; r2++) {
          TreeSet<Integer> tree = new TreeSet<>();
          tree.add(0); // padding
          for (int c = 0; c < n; c++) {
            int area = areas[r2][c];
            if (r1 - 1 >= 0)
              area -= areas[r1 - 1][c];
            Integer ceiling = tree.ceiling(area - k);
            if (ceiling != null)
              maxSum = Math.max(maxSum, area - ceiling);
            tree.add(area);
          }
        }
      }
      return maxSum;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new MaxSumofRectangleNoLargerThanK().new Solution();
      int[][] matrix = {
              {1, 0, 1},
              {0, -2, 3}
      };
      assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
      matrix = new int[][]{
              {1, 2, -1, -4, -20},
              {-8, -3, 4, 2, 1},
              {3, 8, 10, 1, 3},
              {-4, -1, 1, 7, -6}
      };
      assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
      assertEquals(8, sol.maxSumSubmatrix(matrix, 9));
    }

    @Test
    public void test2() {
      Solution_2 sol = new MaxSumofRectangleNoLargerThanK().new Solution_2();
      int[][] matrix = {
              {1, 0, 1},
              {0, -2, 3}
      };
      assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
      matrix = new int[][]{
              {1, 2, -1, -4, -20},
              {-8, -3, 4, 2, 1},
              {3, 8, 10, 1, 3},
              {-4, -1, 1, 7, -6}
      };
      assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
      assertEquals(8, sol.maxSumSubmatrix(matrix, 9));
    }

    @Test
    public void test3() {
      Solution_3 sol = new MaxSumofRectangleNoLargerThanK().new Solution_3();
      int[][] matrix = {
              {1, 0, 1},
              {0, -2, 3}
      };
      assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
      matrix = new int[][]{
              {1, 2, -1, -4, -20},
              {-8, -3, 4, 2, 1},
              {3, 8, 10, 1, 3},
              {-4, -1, 1, 7, -6}
      };
      assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
      assertEquals(8, sol.maxSumSubmatrix(matrix, 9));
    }
  }
}

