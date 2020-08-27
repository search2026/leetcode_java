package one_edit_distance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class OneEditDistance {
  /*
      One Edit Distance
      leetcode #161
      https://leetcode.com/discuss/questions/oj/one-edit-distance?sort=votes
      http://www.cnblogs.com/grandyang/p/5184698.html
      Difficulty: Medium
   */
  public class Solution {
    public boolean isOneEditDistance(String s, String t) {
      if (s == null && t == null) return true;
      if (s == null || t == null) return false;
      int m = s.length(), n = t.length();
      if (m > n) return isOneEditDistance(t, s);
      if (n - m > 1) return false;
      int i = 0, shift = n - m;
      while (i < m && s.charAt(i) == t.charAt(i)) i++;
      // if two string are the same (shift==0), return false
      if (i == m) return shift > 0;
      // if n==m skip current char in s (modify operation in s)
      if (shift == 0) i++;
      // use shift to skip one char in t
      while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
      return i == m;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new OneEditDistance().new Solution();
      assertFalse(sol.isOneEditDistance("acdbegh", "acdbegh"));
      assertTrue(sol.isOneEditDistance("acdbegh", "cdbegh"));
      assertTrue(sol.isOneEditDistance("acdbegh", "acdegh"));
      assertTrue(sol.isOneEditDistance("acdbegh", "acdbeg"));
      assertTrue(sol.isOneEditDistance("acdbegh", "#acdbegh"));
      assertTrue(sol.isOneEditDistance("acdbegh", "acdbiegh"));
      assertTrue(sol.isOneEditDistance("acdbegh", "acdbeghi"));
      assertTrue(sol.isOneEditDistance("acdbegh", "hcdbegh"));
      assertTrue(sol.isOneEditDistance("acdbegh", "addbegh"));
      assertTrue(sol.isOneEditDistance("acdbegh", "acdbegc"));
      assertFalse(sol.isOneEditDistance("acdbegh", "cdbqgh"));
    }
  }
}
