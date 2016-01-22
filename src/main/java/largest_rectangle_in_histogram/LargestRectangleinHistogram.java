package largest_rectangle_in_histogram;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class LargestRectangleinHistogram {
    /*
        Largest Rectangle in Histogram
        https://leetcode.com/problems/largest-rectangle-in-histogram/
        Difficulty: Hard
     */
    public class Solution {
        public int largestRectangleArea(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            LinkedList<Integer> stack = new LinkedList<Integer>();
            int maxArea = 0;
            for (int i = 0; i < height.length; i++) {
                if (stack.size() == 0 || height[stack.peek()] < height[i]) {
                    stack.push(i);
                } else {
                    int temp = stack.pop();
                    int width = (stack.size() == 0) ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height[temp] * width);
                    i--;
                }
            }
            while (stack.size() != 0) {
                int temp = stack.pop();
                int width = (stack.size() == 0) ? height.length : height.length - stack.peek() - 1;
                maxArea = Math.max(maxArea, height[temp] * width);
            }
            return maxArea;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LargestRectangleinHistogram().new Solution();
            assertEquals(10, sol.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        }
    }
}
