package com.search2026.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

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

}
