package maximal_rectangle;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class MaximalRectangle {
    /*
        Maximal Rectangle
        https://leetcode.com/problems/maximal-rectangle/
        Difficulty: Hard
     */
    public class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
            int[] height = new int[matrix[0].length];
            int maxArea = 0;

            for (int row=0; row<matrix.length; row++) {
                LinkedList<Integer> stack = new LinkedList<Integer>();
                for (int i=0; i<matrix[0].length; i++) {
                    if (matrix[row][i] != '0') height[i] = height[i] + 1;
                    else height[i] = 0;
                }
                for (int col=0; col<matrix[0].length; col++) {
                    if (stack.size()==0 || height[col]>height[stack.peek()]) {
                        stack.push(col);
                    }
                    else {
                        int temp = stack.pop();
                        int width = (stack.size()==0)? col : col-stack.peek()-1;
                        maxArea = Math.max(maxArea, width*height[temp]);
                        col--;
                    }
                }
                while (stack.size() != 0) {
                    int temp = stack.pop();
                    int width = (stack.size()==0)? height.length : height.length-stack.peek()-1;
                    maxArea = Math.max(maxArea, width*height[temp]);
                }
            }

            return maxArea;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MaximalRectangle().new Solution();
            char[][] grid = new char[][]{
                    new char[]{'1', '0', '1', '0', '0'},
                    new char[]{'1', '0', '1', '1', '1'},
                    new char[]{'1', '1', '1', '1', '1'},
                    new char[]{'1', '0', '0', '1', '0'}
            };
            assertEquals(6, sol.maximalRectangle(grid));
        }
    }
}
