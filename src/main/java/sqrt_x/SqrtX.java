package sqrt_x;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SqrtX {
  /*
      Sqrt(x) - Binary Search
      Leetcode #69
      https://leetcode.com/problems/sqrtx/
      Difficulty: Medium
   */
  public class Solution {
    public int sqrt(int x) {
      int left = 1, right = x / 2;
      if (x < 2) return x;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (x / mid == mid) return mid;
        if (x / mid > mid) left = mid + 1;
        else right = mid - 1;
      }
      return right;
    }
  }

  /*
      Sqrt(x) - Newton's Method
      Leetcode #69
      https://leetcode.com/problems/sqrtx/
      Difficulty: Medium
   */
  public class Solution_2 {
    public int sqrt(int x) {
      double root = 1.0;
      while (Math.abs(root * root - x) > 10E-6) {
        root = (root + x / root) / 2;
      }
      return (int) root;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new SqrtX().new Solution();
      assertEquals(2, sol.sqrt(5));
      assertEquals(4, sol.sqrt(16));
      assertEquals(4, sol.sqrt(17));
    }

    @Test
    public void test2() {
      Solution_2 sol = new SqrtX().new Solution_2();
      assertEquals(2, sol.sqrt(5));
      assertEquals(4, sol.sqrt(16));
      assertEquals(4, sol.sqrt(17));
    }
  }
}
