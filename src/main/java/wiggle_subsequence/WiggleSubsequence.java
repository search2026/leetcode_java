package wiggle_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WiggleSubsequence {
  /*
      Wiggle Subsequence
      Leetcode #376
      https://leetcode.com/problems/wiggle-subsequence/
      Difficulty: Medium
   */
  public class Solution {
    public int wiggleMaxLength(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int n = nums.length;
      if (n == 1) return 1;
      int maxCount = 1, flag = 0; //flag 1 (up), 0 (flat), -1 (down)

      for (int i = 1; i < n; i++) {
        if (nums[i] > nums[i-1] && (flag == -1 || flag == 0)) {
          maxCount++;
          flag = 1;
        } else if (nums[i] < nums[i-1] && (flag == 1 || flag == 0)) {
          maxCount++;
          flag = -1;
        }
      }

      return maxCount;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new WiggleSubsequence().new Solution();
      assertEquals(6, sol.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
      assertEquals(7, sol.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
      assertEquals(2, sol.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
  }
}

