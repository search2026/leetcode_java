package paint_fence;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaintFence {
    /*
        Paint Fence
        Leetcode #276
        https://leetcode.com/discuss/oj/paint-fence
        http://buttercola.blogspot.com/2015/09/leetcode-paint-fence.html
        Difficulty: Medium
     */
    public class Solution {
        public int numWays(int n, int k) {
            if (n <= 0 || k <= 0) return 0;
            if (n == 1) return k;

            int preSame = 0;
            int preDiff = k;
            for (int i = 1; i < n; i++) {
                int curDiff = (k - 1) * (preSame + preDiff);
                preSame = preDiff;
                preDiff = curDiff;
            }

            return preSame + preDiff;
        }
    }

    /*
        Paint Fence
        Leetcode #276
        https://leetcode.com/discuss/oj/paint-fence
        http://buttercola.blogspot.com/2015/09/leetcode-paint-fence.html
        Difficulty: Easy
    */
    public class SolutionII {
        public int numWays(int n, int k) {
            if (n <= 0 || k <= 0) {
                return 0;
            }

            if (n == 1) {
                return k;
            }

            // i -1 and i -2 with the same color
            int[] dp1 = new int[n];
            // i - 1 and i - 2 with diff. color
            int[] dp2 = new int[n];

            // Initialization
            dp1[0] = 0;
            dp2[0] = k;

            for (int i = 1; i < n; i++) {
                dp1[i] = dp2[i - 1];
                dp2[i] = (k - 1) * (dp1[i - 1] + dp2[i - 1]);
            }

            // Final state
            return dp1[n - 1] + dp2[n - 1];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PaintFence().new Solution();
            assertEquals(7, 7);
        }
    }
}
