package guess_number_higher_or_lower;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new GuessNumberHigherorLower().new Solution(6);
      assertEquals(6, sol.guessNumber(10));
      assertEquals(1, sol.guessNumber(5));
      assertEquals(6, sol.guessNumber(100));
    }
  }
}

