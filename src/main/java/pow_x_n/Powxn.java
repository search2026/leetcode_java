package pow_x_n;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Powxn {
  /*
      Pow(x, n) - Iterative
      Leetcode #50
      https://leetcode.com/problems/powx-n/
      Difficulty: Medium
   */
  public class Solution {
    public double pow(double x, int n) {
      boolean overflow = false;
      if (n == Integer.MIN_VALUE) {
        overflow = true;
        n++;
      }
      boolean negative = n < 0;
      n = Math.abs(n);
      double rslt = 1;
      double times = x;
      while (n != 0) {
        if ((n & 1) == 1) {
          rslt *= times;
        }
        times *= times;
        n >>= 1;
      }
      if (negative) {
        return overflow ? 1 / (rslt * x) : 1 / rslt;
      }
      return rslt;
    }
  }

  /*
      Pow(x, n) - Recursion
      Leetcode #50
      https://leetcode.com/problems/powx-n/
      Difficulty: Medium
   */
  public class Solution_2 {
    public double pow(double x, int n) {
      if (n == 0)
        return 1;
      if (n < 0) {
        n = -n;
        x = 1 / x;
      }
      return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new Powxn().new Solution();
      assertEquals(4096.0, sol.pow(2.0, 12), 1E-6);
      assertEquals(998001.0, sol.pow(999.0, 2), 1E-6);
      assertEquals(0.333333, sol.pow(3.0, -1), 1E-6);
    }

    @Test
    public void test2() {
      Solution_2 sol = new Powxn().new Solution_2();
      assertEquals(4096.0, sol.pow(2.0, 12), 1E-6);
      assertEquals(998001.0, sol.pow(999.0, 2), 1E-6);
      assertEquals(0.333333, sol.pow(3.0, -1), 1E-6);
    }
  }
}
