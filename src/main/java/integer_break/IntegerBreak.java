package integer_break;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class IntegerBreak {
    /*
        Integer Break
        Leetcode #343
        https://leetcode.com/problems/integer-break/
        Difficulty: Medium
     */
    public class Solution {
        int integerBreak(int n) {
            if (n == 2 || n == 3) return n-1;
            int div = n / 3;
            int reminder = n % 3;
            if (reminder == 1)
                return (int)Math.pow(3, div-1) * 4;
            else if (reminder == 0)
                return (int)Math.pow(3, div);
            return (int)Math.pow(3, div) * 2;
        }
    }

    /*
        Integer Break - Dynamic Programming
        Leetcode #343
        https://leetcode.com/problems/integer-break/
        Difficulty: Medium
     */
    public class Solution_2 {
        int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for(int i = 2; i <= n; i ++) {
                for(int j = 1; 2*j <= i; j ++) {
                    dp[i] = Math.max(dp[i], (Math.max(j,dp[j])) * (Math.max(i - j, dp[i - j])));
                }
            }
            return dp[n];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new IntegerBreak().new Solution();
            assertEquals(1, sol.integerBreak(2));
            assertEquals(2, sol.integerBreak(3));
            assertEquals(4, sol.integerBreak(4));
            assertEquals(6, sol.integerBreak(5));
            assertEquals(9, sol.integerBreak(6));
            assertEquals(12, sol.integerBreak(7));
            assertEquals(18, sol.integerBreak(8));
            assertEquals(27, sol.integerBreak(9));
            assertEquals(36, sol.integerBreak(10));
        }

        @Test
        public void test2() {
            Solution_2 sol = new IntegerBreak().new Solution_2();
            assertEquals(1, sol.integerBreak(2));
            assertEquals(2, sol.integerBreak(3));
            assertEquals(4, sol.integerBreak(4));
            assertEquals(6, sol.integerBreak(5));
            assertEquals(9, sol.integerBreak(6));
            assertEquals(12, sol.integerBreak(7));
            assertEquals(18, sol.integerBreak(8));
            assertEquals(27, sol.integerBreak(9));
            assertEquals(36, sol.integerBreak(10));
        }
    }
}

