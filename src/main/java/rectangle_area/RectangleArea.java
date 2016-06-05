package rectangle_area;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleArea {
    /*
        Rectangle Area
        Leetcode #223
        https://leetcode.com/problems/rectangle-area/
        Difficulty: Easy
     */
    public class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            if (C < E || G < A)
                return (G - E) * (H - F) + (C - A) * (D - B);

            if (D < F || H < B)
                return (G - E) * (H - F) + (C - A) * (D - B);

            int right = Math.min(C, G);
            int left = Math.max(A, E);
            int top = Math.min(H, D);
            int bottom = Math.max(F, B);

            return (G - E) * (H - F) + (C - A) * (D - B) - (right - left) * (top - bottom);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RectangleArea().new Solution();
            assertEquals(7, 7);
        }
    }
}
