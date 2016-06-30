package range_addition;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class RangeAddition {
  /*
      Range Addition
      Leetcode #370
      https://leetcode.com/discuss/questions/oj/range-addition?sort=votes
      http://www.cnblogs.com/grandyang/p/5628786.html
      Difficulty: Medium
   */
  public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
      if (length < 0 || updates == null || updates.length == 0) return null;
      if (updates[0] == null || updates[0].length != 3) return null;

      int[] modified = new int[length];
      for (int[] upd : updates) {
        modified[upd[0]] += upd[2];
        if (upd[1] < length -1)
          modified[upd[1] + 1] -= upd[2];
      }

      int sum = 0;
      for (int i = 0; i < length; i++) {
        sum += modified[i];
        modified[i] = sum;
      }

      return modified;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new RangeAddition().new Solution();
      int length = 5;
      int[][] updates = {
              {1, 3, 2},
              {2, 4, 3},
              {0, 2, -2}
      };
      int[] increased = sol.getModifiedArray(length, updates);
      int[] expected = {-2, 0, 3, 5, 3};
      assertArrayEquals(expected, increased);
    }
  }
}

