package plus_one;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PlusOne {
  /*
      Plus One
      Leetcode #66
      https://leetcode.com/problems/plus-one/
      Difficulty: Easy
   */
  public class Solution {
    public int[] plusOne(int[] digits) {
      if (digits == null || digits.length == 0) return new int[]{};

      for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] < 9) {
          digits[i]++;
          return digits;
        } else {
          digits[i] = 0;
        }
      }

      int[] newArray = new int[digits.length + 1];
      System.arraycopy(digits, 0, newArray, 1, digits.length);
      newArray[0] = 1;
      return newArray;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new PlusOne().new Solution();
      assertArrayEquals(sol.plusOne(new int[]{9, 9, 8}), new int[]{9, 9, 9});
      assertArrayEquals(sol.plusOne(new int[]{9, 9, 9}), new int[]{1, 0, 0, 0});
    }
  }
}
