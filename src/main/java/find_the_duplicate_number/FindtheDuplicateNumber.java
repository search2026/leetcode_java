package find_the_duplicate_number;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindtheDuplicateNumber {
  /*
      Find the Duplicate Number
      Leetcode #287
      https://leetcode.com/problems/find-the-duplicate-number/
      Difficulty: Medium
   */
  public class Solution {
    private int countNumbers(int[] nums, int mid) {
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= mid) {
          count++;
        }
      }

      return count;
    }

    public int findDuplicate(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }

      int left = 1;
      int right = nums.length - 1;

      while (left < right) {
        int mid = left + (right - left) / 2;
        int count = countNumbers(nums, mid);

        if (count <= mid) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }

      return right; // Or lo
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new FindtheDuplicateNumber().new Solution();
      int[] test = {4, 1, 5, 2, 3, 1};
      assertEquals(1, sol.findDuplicate(test));
    }
  }
}
