package largest_rectangle_in_histogram;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestRectangleinHistogram {
    /*
        Largest Rectangle in Histogram
        https://leetcode.com/problems/largest-rectangle-in-histogram/
        Difficulty: Hard
     */
    public class Solution {
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;

            int n = heights.length;
            int maxArea = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (stack.size() == 0 || heights[stack.peek()] < heights[i]) {
                    stack.push(i);
                } else {
                    int cur = stack.pop();
                    int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, heights[cur] * width);
                    i--;
                }
            }

            while (stack.size() != 0) {
                int cur = stack.pop();
                int width = (stack.isEmpty()) ? n : n - stack.peek() - 1;
                maxArea = Math.max(maxArea, heights[cur] * width);
            }

            return maxArea;
        }
    }

    /*
        Largest Rectangle in Histogram
        https://leetcode.com/problems/largest-rectangle-in-histogram/
        Difficulty: Hard
     */
    public class Solution_2 {
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;

            int n = heights.length;
            int maxArea = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i <= n; i++) {
                int curr = (i == n) ? 0 : heights[i];
                while (!stack.isEmpty() && heights[stack.peek()] > curr) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }

            return maxArea;
        }
    }

    /*
        Largest Rectangle in Histogram
        https://leetcode.com/problems/largest-rectangle-in-histogram/
        Difficulty: Hard
     */
    public class Solution_3 {
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;

            int n = heights.length;
            Deque<Integer> stack = new ArrayDeque<>();
            int maxArea = 0;
            for (int i = 0; i < n; i++) {
                if (stack.size() == 0 || heights[stack.peek()] < heights[i]) {
                    stack.push(i);
                } else {
                    int cur = stack.pop();
                    int width = (stack.size() == 0) ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, heights[cur] * width);
                    i--;
                }
            }

            while (stack.size() != 0) {
                int cur = stack.pop();
                int width = (stack.size() == 0) ? n : n - stack.peek() - 1;
                maxArea = Math.max(maxArea, heights[cur] * width);
            }

            return maxArea;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LargestRectangleinHistogram().new Solution();
            assertEquals(1, sol.largestRectangleArea(new int[]{1}));
            assertEquals(10, sol.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
            assertEquals(7, sol.largestRectangleArea(new int[]{2, 7, 1}));
            assertEquals(7, sol.largestRectangleArea(new int[]{1, 7, 2}));
            assertEquals(7, sol.largestRectangleArea(new int[]{2, 3, 7}));
        }

        @Test
        public void test2() {
            Solution_2 sol = new LargestRectangleinHistogram().new Solution_2();
            assertEquals(1, sol.largestRectangleArea(new int[]{1}));
            assertEquals(10, sol.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
            assertEquals(7, sol.largestRectangleArea(new int[]{2, 7, 1}));
            assertEquals(7, sol.largestRectangleArea(new int[]{1, 7, 2}));
        }

        @Test
        public void test3() {
            Solution_3 sol = new LargestRectangleinHistogram().new Solution_3();
            assertEquals(1, sol.largestRectangleArea(new int[]{1}));
            assertEquals(10, sol.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
            assertEquals(7, sol.largestRectangleArea(new int[]{2, 7, 1}));
            assertEquals(7, sol.largestRectangleArea(new int[]{1, 7, 2}));
        }
    }
}
