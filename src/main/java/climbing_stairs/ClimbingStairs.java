package climbing_stairs;

import org.junit.Test;

import java.lang.Math;

import static org.junit.Assert.assertTrue;

public class ClimbingStairs {
    /*
        Climbing Stairs
        Leetcode #70
        https://leetcode.com/problems/climbing-stairs/
        Difficulty: Easy
     */
    public class Solution {
        public int climbStairs(int n) {
            int f1 = 1;
            int f2 = 1;
            for (int i = 2; i <= n; i++) {
                int temp = f1 + f2;
                f1 = f2;
                f2 = temp;
            }
            return f2;
        }
    }

    /*
        Climbing Stairs
        Leetcode #70
        https://leetcode.com/problems/climbing-stairs/
        Difficulty: Easy
     */
    public class Solution_2 {
        public int climbStairs(int n) {
            double s = Math.sqrt(5);
            return (int) ((Math.pow((1 + s) / 2, n + 1) - Math.pow((1 - s) / 2, n + 1)) / s + 0.5);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ClimbingStairs().new Solution();
            assertTrue(true);
        }
    }
}
