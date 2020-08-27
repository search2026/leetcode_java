package missing_ranges;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingRanges {
  /*
      Missing Ranges
      Leetcode #163
      https://leetcode.com/discuss/questions/oj/missing-ranges?sort=votes
      http://www.cnblogs.com/grandyang/p/5184890.html
      Difficulty: Medium
   */
  public class Solution {
    private String getRange(int from, int to) {
      return (from == to) ? String.valueOf(from) : from + "->" + to;
    }

    public List<String> findMissingRanges(int[] vals, int start, int end) {
      List<String> ranges = new ArrayList<>();
      if (vals == null || vals.length == 0 || start > end) return ranges;
      int prev = start - 1;
      for (int i = 0; i <= vals.length; i++) {
        int curr = (i == vals.length) ? end + 1 : vals[i];
        if (curr - prev >= 2) {
          ranges.add(getRange(prev + 1, curr - 1));
        }
        prev = curr;
      }
      return ranges;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new MissingRanges().new Solution();
      int[] test = {0, 1, 3, 50, 75};
      List<String> results = sol.findMissingRanges(test, 0, 99);
      assertEquals(4, results.size());
      assertEquals("2", results.get(0));
      assertEquals("4->49", results.get(1));
      assertEquals("51->74", results.get(2));
      assertEquals("76->99", results.get(3));
    }
  }
}
