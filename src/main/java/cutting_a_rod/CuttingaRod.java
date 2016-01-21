package cutting_a_rod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CuttingaRod {
    /*
        Cutting a Rod - Brute Force
        http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
        Difficulty: Medium
     */
    public class Solution {
        int search(int[] price, int end) {
            if (end<=0) return 0;
            int rslt = Integer.MIN_VALUE;

            for (int i = 0; i < end; i++)
                rslt = Math.max(rslt, price[i] + search(price, end - i - 1));

            return rslt;
        }

        int cutRod(int[] price) {
            if (price == null || price.length == 0) return 0;
            return search(price, price.length);
        }
    }

    /*
        Cutting a Rod - Dynamic Program
        http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
        Difficulty: Medium
    */
    public class Solution_2 {
        int cutRod(int[] price) {
            if (price == null || price.length == 0) return 0;
            int n = price.length;
            int[] dp = new int[n+1];

            for (int i = 1; i <= n; i++)  {
                int maxVal = Integer.MIN_VALUE;
                for (int j=0; j<i; j++)
                    maxVal = Math.max(maxVal, dp[i-j-1]+price[j]);
                dp[i] = maxVal;
            }

            return dp[n];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution_2 sol = new CuttingaRod().new Solution_2();
            assertEquals(22, sol.cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
            assertEquals(24, sol.cutRod(new int[]{3, 5, 8, 9, 10, 17, 17, 20}));
        }
    }
}

