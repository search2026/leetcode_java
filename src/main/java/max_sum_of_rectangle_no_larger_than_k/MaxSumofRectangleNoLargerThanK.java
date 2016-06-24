package max_sum_of_rectangle_no_larger_than_k;

import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class MaxSumofRectangleNoLargerThanK {
  /*
      Max Sum of Rectangle No Larger Than K
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
  }
}

