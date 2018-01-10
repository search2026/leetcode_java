package valid_perfect_square;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class ValidPerfectSquare {
  /*
      Valid Perfect Square
      Leetcode #367
      https://leetcode.com/problems/valid-perfect-square/
      Difficulty: Medium
   */
  public class Solution {
    boolean isPerfectSquare(int num) {
      if (num < 1) return false;
      for (int i = 1; num > 0; i += 2) {
        num -= i;
      }
      return num == 0;
    }
  }

  /*
    Valid Perfect Square - Binary Search
    Leetcode #367
    https://leetcode.com/problems/valid-perfect-square/
    Difficulty: Medium
 */
  public class Solution_2 {
    public boolean isPerfectSquare(int num) {
      if (num < 1) return false;
      long left = 1, right = num;// long type to avoid 2147483647 case

      while (left <= right) {
        long mid = left + (right - left) / 2;
        long t = mid * mid;
        if (t > num) {
          right = mid - 1;
        } else if (t < num) {
          left = mid + 1;
        } else {
          return true;
        }
      }

      return false;
    }
  }

  /*
      Valid Perfect Square - Newton Method
      Leetcode #367
      https://leetcode.com/problems/valid-perfect-square/
      Difficulty: Medium
   */
  public class Solution_3 {
    boolean isPerfectSquare(int num) {
      if (num < 1) return false;
      if (num == 1) return true;
      long t = num / 2;
      while (t * t > num) {
        t = (t + num / t) / 2;
      }
      return t * t == num;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new ValidPerfectSquare().new Solution();
      assertFalse(sol.isPerfectSquare(0));
      assertTrue(sol.isPerfectSquare(1));
      assertFalse(sol.isPerfectSquare(8));
      assertTrue(sol.isPerfectSquare(9));
      assertFalse(sol.isPerfectSquare(10));
      assertFalse(sol.isPerfectSquare(99));
      assertTrue(sol.isPerfectSquare(100));
      assertFalse(sol.isPerfectSquare(101));
      assertFalse(sol.isPerfectSquare(808200));
      assertTrue(sol.isPerfectSquare(808201));
      assertFalse(sol.isPerfectSquare(808202));
      assertFalse(sol.isPerfectSquare(2147483647));
    }

    @Test
    public void test2() {
      Solution_2 sol = new ValidPerfectSquare().new Solution_2();
      assertFalse(sol.isPerfectSquare(0));
      assertTrue(sol.isPerfectSquare(1));
      assertFalse(sol.isPerfectSquare(8));
      assertTrue(sol.isPerfectSquare(9));
      assertFalse(sol.isPerfectSquare(10));
      assertFalse(sol.isPerfectSquare(99));
      assertTrue(sol.isPerfectSquare(100));
      assertFalse(sol.isPerfectSquare(101));
      assertFalse(sol.isPerfectSquare(808200));
      assertTrue(sol.isPerfectSquare(808201));
      assertFalse(sol.isPerfectSquare(808202));
      assertFalse(sol.isPerfectSquare(2147483647));
    }

    @Test
    public void test3() {
      Solution_3 sol = new ValidPerfectSquare().new Solution_3();
      assertFalse(sol.isPerfectSquare(0));
      assertTrue(sol.isPerfectSquare(1));
      assertFalse(sol.isPerfectSquare(8));
      assertTrue(sol.isPerfectSquare(9));
      assertFalse(sol.isPerfectSquare(10));
      assertFalse(sol.isPerfectSquare(99));
      assertTrue(sol.isPerfectSquare(100));
      assertFalse(sol.isPerfectSquare(101));
      assertFalse(sol.isPerfectSquare(808200));
      assertTrue(sol.isPerfectSquare(808201));
      assertFalse(sol.isPerfectSquare(808202));
      assertFalse(sol.isPerfectSquare(2147483647));
    }
  }
}

