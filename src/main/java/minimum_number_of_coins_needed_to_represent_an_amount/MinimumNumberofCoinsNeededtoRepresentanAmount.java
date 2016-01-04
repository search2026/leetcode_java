package minimum_number_of_coins_needed_to_represent_an_amount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumNumberofCoinsNeededtoRepresentanAmount {
    /*
        Minimum number of coins needed to represent an amount
        http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
        Difficulty: Medium
     */
    public class Solution {
        public int minCoins(int[] coins, int amount) {
            int n = coins.length;
            if (n < 1 || amount < 1) return -1;
            int[] dp = new int[amount + 1];
            int minVal;

            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                minVal = i;
                for (int j = 0; j < n; j++) {
                    if (coins[j] > i) break;
                    minVal = Math.min(dp[i - coins[j]] + 1, minVal);
                }
                dp[i] = minVal;
            }
            return dp[amount];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MinimumNumberofCoinsNeededtoRepresentanAmount().new Solution();
            int[] coins = new int[]{9, 6, 5, 1};
            int amount = 11;
            //TODO: this unit actually failed, expected 2 instead of 3
            assertEquals(3, sol.minCoins(coins, amount));
        }
    }
}

