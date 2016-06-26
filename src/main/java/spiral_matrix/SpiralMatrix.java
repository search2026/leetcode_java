package spiral_matrix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SpiralMatrix {
  /*
      Spiral Matrix
      Leetcode #54
      https://leetcode.com/problems/spiral-matrix/
      Difficulty: Medium
   */
  public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> list = new ArrayList<Integer>();
      if (matrix.length == 0 || matrix[0].length == 0) return list;

      int rowStart = 0;
      int rowEnd = matrix.length - 1;
      int colStart = 0;
      int colEnd = matrix[0].length - 1;

      while (rowStart <= rowEnd && colStart <= colEnd) {
        for (int i = colStart; i <= colEnd; i++) list.add(matrix[rowStart][i]);
        rowStart++;
        if (rowStart > rowEnd) break;

        for (int i = rowStart; i <= rowEnd; i++) list.add(matrix[i][colEnd]);
        colEnd--;
        if (colStart > colEnd) break;

        for (int i = colEnd; i >= colStart; i--) list.add(matrix[rowEnd][i]);
        rowEnd--;
        if (rowStart > rowEnd) break;

        for (int i = rowEnd; i >= rowStart; i--) list.add(matrix[i][colStart]);
        colStart++;
        if (colStart > colEnd) break;
      }

      return list;
    }
  }

  /*
    Spiral Matrix II
    Leetcode #59
    https://leetcode.com/problems/spiral-matrix-ii/
    Difficulty: Medium
 */
  public class Solution_2 {
    public int[][] generateMatrix(int n) {
      int[][] matrix = new int[n][n];
      if (n == 0) return matrix;

      int rowStart = 0;
      int rowEnd = n - 1;
      int colStart = 0;
      int colEnd = n - 1;
      int num = 1; //change

      while (rowStart <= rowEnd && colStart <= colEnd) {
        for (int i = colStart; i <= colEnd; i++) {
          matrix[rowStart][i] = num++;
        }
        rowStart++;

        for (int i = rowStart; i <= rowEnd; i++) {
          matrix[i][colEnd] = num++;
        }
        colEnd--;

        for (int i = colEnd; i >= colStart; i--) {
          if (rowStart <= rowEnd)
            matrix[rowEnd][i] = num++;
        }
        rowEnd--;

        for (int i = rowEnd; i >= rowStart; i--) {
          if (colStart <= colEnd)
            matrix[i][colStart] = num++;
        }
        colStart++;
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
  public class Solution_3 {
    public int[][] generateMatrix(int n) {
      int[][] matrix = new int[n][n];
      if (n == 0) return matrix;

      int num = 0;
      int begin = 0;
      int end = n - 1;
      while (begin <= end) {
        for (int i = begin; i <= end; i++) {
          matrix[begin][i] = ++num;
        }
        for (int i = begin + 1; i < end; i++) {
          matrix[i][end] = ++num;
        }
        if (begin != end) {
          for (int i = end; i >= begin; i--) {
            matrix[end][i] = ++num;
          }
          for (int i = end - 1; i > begin; i--) {
            matrix[i][begin] = ++num;
          }
        }
        begin++;
        end--;
      }
      return matrix;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new SpiralMatrix().new Solution();
      int[][] matrix = {
              {1, 2, 3},
              {4, 5, 6},
              {7, 8, 9}
      };
      List<Integer> printed = sol.spiralOrder(matrix);
      assertEquals(9, printed.size());
      assertEquals(1, (int) printed.get(0));
      assertEquals(2, (int) printed.get(1));
      assertEquals(3, (int) printed.get(2));
      assertEquals(6, (int) printed.get(3));
      assertEquals(9, (int) printed.get(4));
      assertEquals(8, (int) printed.get(5));
      assertEquals(7, (int) printed.get(6));
      assertEquals(4, (int) printed.get(7));
      assertEquals(5, (int) printed.get(8));
    }

    @Test
    public void test2() {
      Solution_2 sol = new SpiralMatrix().new Solution_2();
      int[][] matrix = {
              {1, 2, 3},
              {8, 9, 4},
              {7, 6, 5}
      };
      int[][] printed = sol.generateMatrix(3);
      assertEquals(3, printed.length);
      assertEquals(3, printed[0].length);
      for (int i = 0; i < 3; i++) {
        assertArrayEquals(matrix[i], printed[i]);
      }
    }

    @Test
    public void test3() {
      Solution_3 sol = new SpiralMatrix().new Solution_3();
      int[][] matrix = {
              {1, 2, 3},
              {8, 9, 4},
              {7, 6, 5}
      };
      int[][] printed = sol.generateMatrix(3);
      assertEquals(3, printed.length);
      assertEquals(3, printed[0].length);
      for (int i = 0; i < 3; i++) {
        assertArrayEquals(matrix[i], printed[i]);
      }
    }
  }
}
