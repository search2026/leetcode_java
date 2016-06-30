package string_to_integer_atoi;

import org.junit.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.Assert.assertEquals;

public class StringtoIntegeratoi {
  /*
      String to Integer (atoi)
      Leetcode #8
      https://leetcode.com/problems/string-to-integer-atoi/
      Difficulty: Easy
   */
  public class Solution {
    private final int maxDiv10 = Integer.MAX_VALUE / 10;

    public int myAtoi(String str) {
      if (str.length() == 0) return 0;
      int idx = 0, sign = 1;

      while (str.charAt(idx) == ' ' && idx < str.length()) idx++;

      if (str.charAt(idx) == '+' || str.charAt(idx) == '-') {
        sign = str.charAt(idx) == '+' ? 1 : -1;
        idx++;
      }

      int num = 0;
      while (idx < str.length()) {
        int digit = str.charAt(idx) - '0';
        if (digit < 0 || digit > 9) break;

        //check if num will be overflow after 10 times and add digit
        if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
          return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        num = num * 10 + digit;
        idx++;
      }

      return num * sign;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new StringtoIntegeratoi().new Solution();
      assertEquals(0, sol.myAtoi("0"));
      assertEquals(7, sol.myAtoi("7"));
      assertEquals(-1, sol.myAtoi("-1"));
      assertEquals(66666666, sol.myAtoi("66666666"));
      assertEquals(-12345, sol.myAtoi("-12345"));
      assertEquals(2147483647, sol.myAtoi("2147483648"));
    }
  }
}
