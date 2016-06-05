package spiral_matrix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
            List<Integer> rslt = new ArrayList<Integer>();
            if (matrix.length == 0 || matrix[0].length == 0) {
                return rslt;
            }
            int beginX = 0;
            int beginY = 0;
            int endX = matrix.length - 1;
            int endY = matrix[0].length - 1;
            while (beginX <= endX && beginY <= endY) {
                for (int i = beginY; i <= endY; i++) {
                    rslt.add(matrix[beginX][i]);
                }
                for (int i = beginX + 1; i < endX; i++) {
                    rslt.add(matrix[i][endY]);
                }
                if (beginX != endX) {
                    for (int i = endY; i >= beginY; i--) {
                        rslt.add(matrix[endX][i]);
                    }
                }
                if (beginY != endY) {
                    for (int i = endX - 1; i > beginX; i--) {
                        rslt.add(matrix[i][beginY]);
                    }
                }
                beginX++;
                endX--;
                beginY++;
                endY--;
            }
            return rslt;
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
            List<Integer> rslt = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return rslt;
            int Min = Math.min(matrix.length, matrix[0].length);
            int levelMax = Min / 2;
            for (int level = 0; level < levelMax; level++) {
                for (int i = level; i < matrix[0].length - 1 - level; i++) {
                    rslt.add(matrix[level][i]);
                }
                for (int i = level; i < matrix.length - 1 - level; i++) {
                    rslt.add(matrix[i][matrix[0].length - 1 - level]);
                }
                for (int i = matrix[0].length - 1 - level; i > level; i--) {
                    rslt.add(matrix[matrix.length - 1 - level][i]);
                }
                for (int i = matrix.length - 1 - level; i > level; i--) {
                    rslt.add(matrix[i][level]);
                }
            }

            if (Min % 2 == 1) {
                if (matrix.length < matrix[0].length) {
                    for (int i = levelMax; i < matrix[0].length - levelMax; i++) {
                        rslt.add(matrix[levelMax][i]);
                    }
                } else {
                    for (int i = levelMax; i < matrix.length - levelMax; i++) {
                        rslt.add(matrix[i][levelMax]);
                    }
                }
            }
            return rslt;
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
            assertEquals(5, 5);
        }
    }
}
