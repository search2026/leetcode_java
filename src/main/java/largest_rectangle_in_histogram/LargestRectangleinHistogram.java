package largest_rectangle_in_histogram;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
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
            if (height == null || height.length == 0) return 0;
            int n = height.length;
            Deque<Integer> stack = new ArrayDeque<Integer>();
            int maxArea = 0;

            for (int i = 0; i < n; i++) {
                if (stack.size() == 0 || height[stack.peek()] < height[i]) {
                    stack.push(i);
                } else {
                    int cur = stack.pop();
                    int width = (stack.size() == 0) ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height[cur] * width);
                    i--;
                }
            }

            while (stack.size() != 0) {
                int cur = stack.pop();
                int width = (stack.size() == 0) ? n : n - stack.peek() - 1;
                maxArea = Math.max(maxArea, height[cur] * width);
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
