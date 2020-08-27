package kth_smallest_element_in_a_sorted_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthSmallestElementinaSortedMatrix {
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
      int rslt = matrix[0][0];
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
            rslt = smallest;
          }
        }
        rows[colOfSmallest]++;
      }
      return rslt;
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

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new KthSmallestElementinaSortedMatrix().new Solution();
      int[][] matrix = {
              {1, 5, 9},
              {10, 11, 13},
              {12, 13, 15}
      };
      assertEquals(1, sol.kthSmallest(matrix, 1));
      assertEquals(9, sol.kthSmallest(matrix, 3));
      assertEquals(11, sol.kthSmallest(matrix, 5));
      assertEquals(12, sol.kthSmallest(matrix, 6));
      assertEquals(13, sol.kthSmallest(matrix, 7));
      assertEquals(13, sol.kthSmallest(matrix, 8));
      assertEquals(15, sol.kthSmallest(matrix, 9));
    }

    @Test
    public void test2() {
      Solution_2 sol = new KthSmallestElementinaSortedMatrix().new Solution_2();
      int[][] matrix = {
              {1, 5, 9},
              {10, 11, 13},
              {12, 13, 15}
      };
      assertEquals(1, sol.kthSmallest(matrix, 1));
      assertEquals(9, sol.kthSmallest(matrix, 3));
      assertEquals(11, sol.kthSmallest(matrix, 5));
      assertEquals(12, sol.kthSmallest(matrix, 6));
      assertEquals(13, sol.kthSmallest(matrix, 7));
      assertEquals(13, sol.kthSmallest(matrix, 8));
      assertEquals(15, sol.kthSmallest(matrix, 9));
    }
  }
}

