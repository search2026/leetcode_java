package water_and_jug_problem;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class WaterandJugProblem {
  /*
      Water and Jug Problem
      Leetcode #365
      https://leetcode.com/problems/water-and-jug-problem/
      Difficulty: Medium
   */
  public class Solution {
    private int gcd(int x, int y) {
      return y == 0 ? x : gcd(y, x % y);
    }

    public boolean canMeasureWater(int x, int y, int z) {
      if (x < 0 || y < 0 || z < 0) return false;
      if (z > (x + y)) return false;
      if (z == 0) return true;

      int g = gcd(x, y);

      return z % gcd(x, y) == 0;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new WaterandJugProblem().new Solution();
      assertTrue(sol.canMeasureWater(3, 5, 4));
      assertFalse(sol.canMeasureWater(2, 6, 5));
    }
  }
}

