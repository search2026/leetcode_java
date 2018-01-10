package guess_number_higher_or_lower;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessNumberHigherorLower {
  /*
      Guess Number Higher or Lower
      Leetcode #374
      https://leetcode.com/problems/guess-number-higher-or-lower/
      Difficulty: Easy
   */
  public class Solution {
    private int num;

    Solution(int target) {
      num = target;
    }

    /*
      The guess API is defined in the parent class GuessGame.
      @param num, your guess
      @return -1 if my number is lower than guess number,
        1 if my number is higher than guess number, otherwise return 0
      */
    public int guess(int guess) {
      if (guess < num) {
        return 1;
      } else if (guess > num) {
        return -1;
      }

      return 0;
    }

    public int guessNumber(int n) {
      int left = 1, right = n;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        int gResult = guess(mid);
        if (gResult == -1) {
          right = mid - 1;
        } else if (gResult == 1) {
          left = mid + 1;
        } else {
          return mid;
        }
      }
      return left;
    }
  }

  /*
      Guess Number Higher or Lower II
      Leetcode #375
      https://leetcode.com/problems/guess-number-higher-or-lower-ii/
      Difficulty: Medium
   */
  public class Solution_2 {
    public int getMoneyAmount(int n) {
      if (n == 1) return 0;

      int[][] dp = new int[n + 1][n + 1];
      // the calculations of longer intervals rely on shorter ones
      for (int l = 2; l <= n; l++) {
        // iterate all the intervals with length l, the start of which is i.
        // Hence the interval will be [i, i + (l - 1)]
        for (int i = 1; i <= n - (l - 1); i++) {
          dp[i][i + (l - 1)] = Integer.MAX_VALUE;
          // iterate all the first guesses g
          for (int g = i; g <= i + (l - 1); g++) {
            int currMinCost;
            // since if g is the last integer, g + 1 does not exist, we have to separate this case
            // cost for [i, i + (l - 1)]: g (first guess) + max{the cost of left part [i, g - 1],
            // the cost of right part [g + 1, i + (l - 1)]}
            if (g == n) {
              currMinCost = dp[i][g - 1] + g;
            } else {
              currMinCost = g + Math.max(dp[i][g - 1], dp[g + 1][i + (l - 1)]);
            }
            dp[i][i + (l - 1)] = Math.min(dp[i][i + (l - 1)], currMinCost);
          }
        }
      }
      return dp[1][n];
    }
  }

  /*
      Guess Number Higher or Lower II
      Leetcode #375
      https://leetcode.com/problems/guess-number-higher-or-lower-ii/
      Difficulty: Medium
   */
  public class Solution_3 {
    public int getMoneyAmount(int n) {
      if (n == 1) return 0;
      int[][] dp = new int[n + 2][n + 2];
      for (int i = 1; i <= n; ++i) {
        for (int j = i - 1; j >= 1; --j) {
          int currMinCost = Integer.MAX_VALUE;
          for (int k = j; k <= i; ++k) {
            int tmp = k + Math.max(dp[j][k - 1], dp[k + 1][i]);
            currMinCost = Math.min(currMinCost, tmp);
          }
          dp[j][i] = currMinCost;
        }
      }
      return dp[1][n];
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new GuessNumberHigherorLower().new Solution(6);
      assertEquals(6, sol.guessNumber(10));
      assertEquals(6, sol.guessNumber(5));
      assertEquals(6, sol.guessNumber(100));
    }

    @Test
    public void test2() {
      Solution_2 sol = new GuessNumberHigherorLower().new Solution_2();
      assertEquals(16, sol.getMoneyAmount(10));
      assertEquals(6, sol.getMoneyAmount(5));
      assertEquals(400, sol.getMoneyAmount(100));
    }

    @Test
    public void test3() {
      Solution_3 sol = new GuessNumberHigherorLower().new Solution_3();
      assertEquals(16, sol.getMoneyAmount(10));
      assertEquals(6, sol.getMoneyAmount(5));
      assertEquals(400, sol.getMoneyAmount(100));
    }
  }
}

