package coin_change;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinChange {
    /*
        Coin Changes
        https://leetcode.com/problems/coin-change/
        Difficulty: Medium
     */
    public class Solution {
        public int coinChange(int[] coins, int amount) {
            int length = coins.length;
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int i = 1; i <= amount; i++)
                dp[i] = Integer.MAX_VALUE;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < length; j++) {
                    if (coins[j] <= i) {
                        int local = dp[i - coins[j]];
                        if (local != Integer.MAX_VALUE && local + 1 < dp[i])
                            dp[i] = local + 1;
                    }
                }
            }
            if (dp[amount] != Integer.MAX_VALUE)
                return dp[amount];
            else
                return -1;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CoinChange().new Solution();
            int[] coins = new int[]{1, 2, 5};
            int amount = 11;
            //TODO: this unit actually failed, expected 2 instead of 3
            assertEquals(3, sol.coinChange(coins, amount));
        }
    }
}

