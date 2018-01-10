package climbing_stairs;

import org.junit.jupiter.api.Test;

import java.lang.Math;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingStairs {
  /*
      Climbing Stairs
      Leetcode #70
      https://leetcode.com/problems/climbing-stairs/
      Difficulty: Easy
   */
  public class Solution {
    public int climbStairs(int n) {
      int f1 = 1;
      int f2 = 1;
      for (int i = 2; i <= n; i++) {
        int temp = f1 + f2;
        f1 = f2;
        f2 = temp;
      }
      return f2;
    }
  }

  /*
      Climbing Stairs
      Leetcode #70
      https://leetcode.com/problems/climbing-stairs/
      Difficulty: Easy
   */
  public class Solution_2 {
    public int climbStairs(int n) {
      double root5 = Math.sqrt(5);
      return (int) ((Math.pow((1 + root5) / 2, n + 1) - Math.pow((1 - root5) / 2, n + 1)) / root5 + 0.5);
    }
  }

  /*
      Climbing Stairs
      Leetcode #70
      https://leetcode.com/problems/climbing-stairs/
      Difficulty: Easy
   */
  public class Solution_3 {
    public int climbStairs(int n) {
      double root5 = Math.sqrt(5);
      double phi = (1 + root5) / 2;
      return (int) (Math.pow(phi, n + 1) / root5 + 0.5);
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new ClimbingStairs().new Solution();
      assertEquals(1, sol.climbStairs(1));
      assertEquals(2, sol.climbStairs(2));
      assertEquals(3, sol.climbStairs(3));
      assertEquals(5, sol.climbStairs(4));
      assertEquals(8, sol.climbStairs(5));
      assertEquals(13, sol.climbStairs(6));
      assertEquals(21, sol.climbStairs(7));
    }

    @Test
    public void test2() {
      Solution_2 sol = new ClimbingStairs().new Solution_2();
      assertEquals(1, sol.climbStairs(1));
      assertEquals(2, sol.climbStairs(2));
      assertEquals(3, sol.climbStairs(3));
      assertEquals(5, sol.climbStairs(4));
      assertEquals(8, sol.climbStairs(5));
      assertEquals(13, sol.climbStairs(6));
      assertEquals(21, sol.climbStairs(7));
    }

    @Test
    public void test3() {
      Solution_3 sol = new ClimbingStairs().new Solution_3();
      assertEquals(1, sol.climbStairs(1));
      assertEquals(2, sol.climbStairs(2));
      assertEquals(3, sol.climbStairs(3));
      assertEquals(5, sol.climbStairs(4));
      assertEquals(8, sol.climbStairs(5));
      assertEquals(13, sol.climbStairs(6));
      assertEquals(21, sol.climbStairs(7));
    }
  }
}
