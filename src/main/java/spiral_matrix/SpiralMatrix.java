package spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<Integer>();
            if (matrix.length == 0 || matrix[0].length == 0) {
                return ans;
            }
            int beginX = 0;
            int beginY = 0;
            int endX = matrix.length - 1;
            int endY = matrix[0].length - 1;
            while (beginX <= endX && beginY <= endY) {
                for (int i = beginY; i <= endY; i++) {
                    ans.add(matrix[beginX][i]);
                }
                for (int i = beginX + 1; i < endX; i++) {
                    ans.add(matrix[i][endY]);
                }
                if (beginX != endX) {
                    for (int i = endY; i >= beginY; i--) {
                        ans.add(matrix[endX][i]);
                    }
                }
                if (beginY != endY) {
                    for (int i = endX - 1; i > beginX; i--) {
                        ans.add(matrix[i][beginY]);
                    }
                }
                beginX++;
                endX--;
                beginY++;
                endY--;
            }
            return ans;
        }

        // Spiral Matrix II
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

    }
}
