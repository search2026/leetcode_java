package coins_in_a_line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class CoinsinaLine {
  /*
      Coins in a Line
      lintcode #394
      http://www.lintcode.com/en/problem/coins-in-a-line/
      Difficuty: Medium
   */
  public class Solution {
    public boolean firstWillWin(int n) {
      return n % 3 != 0;
    }
  }

  /*
      Coins in a Line II
      lintcode #395
      http://www.lintcode.com/en/problem/coins-in-a-line-ii/
      Difficuty: Medium
   */
  public class Solution_2 {
    public boolean firstWillWin(int[] values) {
      if (values == null) return true;
      int n = values.length;
      if (n <= 2) return true;

      // dp[i] means the largest value you (the first player)
      // can get when you start from values[i]
      int[] dp = new int[n+1];
      dp[n] = 0;
      //when you happen to have the last coin, yes, consider the last first
      dp[n-1] = values[n-1];
      //sure we should get the last two for most value
      dp[n-2] = values[n-1] + values[n-2];
      //same rules, why leave two(len-1, len-2) for the other player
      dp[n-3] = values[n-2] + values[n-3];
      //next we are gonna sum up
      for (int i = n-4; i >= 0; i--) {
        //you have to have values[i] and the non-optimal later choice
        //because the other player is smart to leave you the worse one
        //between two of your optimal choices
        dp[i] = values[i] + Math.min(dp[i+2], dp[i+3]);
        dp[i] = Math.max(dp[i], values[i] + values[i+1] + Math.min(dp[i+3], dp[i+4]));
        //equals to: dp[i] = Math.max(values[i] + Math.min(dp[i+2],dp[i+3]), values[i] + values[i+1] + Math.min(dp[i+3], dp[i+4]));
      }
      //compute the total value of coins
      int sum = 0;
      for (int a: values) {
        sum += a;
      }
      //compare your final value to the other player's
      return dp[0] > sum - dp[0];
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new CoinsinaLine().new Solution();
      assertTrue(sol.firstWillWin(1));
      assertTrue(sol.firstWillWin(2));
      assertFalse(sol.firstWillWin(3));
      assertTrue(sol.firstWillWin(4));
      assertTrue(sol.firstWillWin(5));
      assertFalse(sol.firstWillWin(6));
    }

    @Test
    public void test2() {
      Solution_2 sol = new CoinsinaLine().new Solution_2();
      int[] coins = {1, 2, 2};
      assertTrue(sol.firstWillWin(coins));

      coins = new int[]{1, 2, 4};
      assertFalse(sol.firstWillWin(coins));
    }
  }
}

