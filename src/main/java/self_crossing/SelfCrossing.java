package self_crossing;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SelfCrossing {
    /*
        Self Crossing
        https://leetcode.com/problems/self-crossing/
        leetcode 335
        Difficulty: Medium
     */
    public class Solution {
        public boolean isSelfCrossing(int[] x) {
            if (x == null || x.length < 4) return false;
            int n = x.length;
            int x1 = 0, y1 = 0;
            int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
            for (int i = 0; i < n - 3; i++) {
                int a = x[i + 3] - x[i + 1];
                int b = x[i] - x[i + 2];
                if ((a >= x1) && (b >= y1)) return true;
            }

            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SelfCrossing().new Solution();
            assertTrue(sol.isSelfCrossing(new int[]{2, 1, 1, 2}));
            assertTrue(sol.isSelfCrossing(new int[]{1, 1, 1, 1}));
            assertFalse(sol.isSelfCrossing(new int[]{1, 2, 3, 4}));
            //assertTrue(sol.isSelfCrossing(new int[]{1,1,2,1,1}));
        }
    }
}

