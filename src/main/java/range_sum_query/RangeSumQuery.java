package range_sum_query;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RangeSumQuery {
    /*
        Range Sum Query - Immutable
        https://leetcode.com/problems/range-sum-query-immutable/
        Difficulty: Easy
     */
    public class NumArray {
        private int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sums[i] = sum;
            }
        }

        public int sumRange(int i, int j) {
            int toMinus = 0;
            if (i > 0)
                toMinus = sums[i - 1];
            return sums[j] - toMinus;
        }
    }

    /*
        Range Sum Query 2D - Immutable
        https://leetcode.com/problems/range-sum-query-immutable/
        Difficulty: Medium
    */
    public class NumMatrix {
        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
                sum = new int[][]{};
                return;
            }

            sum = new int[matrix.length][matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0) {
                        if (j == 0)
                            sum[i][j] = matrix[0][0];
                        else
                            sum[i][j] = sum[i][j - 1] + matrix[i][j];
                    } else {
                        if (j == 0)
                            sum[i][j] = matrix[i][j] + sum[i - 1][j];
                        else
                            sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i][j] - sum[i - 1][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int left = 0;
            if (col1 > 0)
                left = sum[row2][col1 - 1];

            int top = 0;
            if (row1 > 0)
                top = sum[row1 - 1][col2];

            int leftTop = 0;
            if (row1 > 0 && col1 > 0)
                leftTop = sum[row1 - 1][col1 - 1];

            return sum[row2][col2] - left - top + leftTop;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            int[] tests = new int[]{-2, 0, 3, -5, 2, -1};
            NumArray sol = new RangeSumQuery().new NumArray(tests);
            assertEquals(sol.sumRange(0, 2), 1);
            assertEquals(sol.sumRange(2, 5), -1);
            assertEquals(sol.sumRange(0, 5), -3);
        }
    }
}
