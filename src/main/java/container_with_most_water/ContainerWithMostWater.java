package container_with_most_water;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerWithMostWater {
    /*
        Container with Most Water
        Leetcode #11
        https://leetcode.com/problems/container-with-most-water/
        Difficulty: Medium
     */
    public class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            int start = 0;
            int end = height.length - 1;
            while (start < end) {
                if (height[start] < height[end]) {
                    maxArea = Math.max(maxArea, (end - start) * height[start]);
                    start++;
                } else {
                    maxArea = Math.max(maxArea, (end - start) * height[end]);
                    end--;
                }
            }
            return maxArea;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ContainerWithMostWater().new Solution();
            assertTrue(true);
        }
    }
}
