package line_reflection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class LineReflection {
  /*
    Line Reflection
    Leetcode #356
    https://leetcode.com/discuss/oj/line-reflection
    http://www.cnblogs.com/grandyang/p/5579271.html
    Difficulty: Medium
   */
  public class Solution {
    private final String DELIMITER = "a";

    public boolean isReflected(int[][] points) {
      if (points == null || points.length == 0 ||
              points[0] == null || points[0].length != 2) return false;

      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      Set<String> set = new HashSet<>();
      for (int[] p : points) {
        max = Math.max(max, p[0]);
        min = Math.min(min, p[0]);
        String str = p[0] + DELIMITER + p[1];
        set.add(str);
      }

      long sum = max + min;
      for (int[] p : points) {
        String str = (sum - p[0]) + DELIMITER + p[1];
        if (!set.contains(str)) return false;
      }
      return true;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new LineReflection().new Solution();
      int[][] test1 = {
              {1, 1},
              {-1, 1}
      };
      assertTrue(sol.isReflected(test1));
      int[][] test2 = {
              {1, 1},
              {-1, -1}
      };
      assertFalse(sol.isReflected(test2));
      int[][] test3 = {
              {1, 1},
              {9, 1},
              {8, 2}
      };
      assertFalse(sol.isReflected(test3));
    }
  }
}

