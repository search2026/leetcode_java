package integer_to_roman;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class IntegertoRoman {
  /*
      Integer to Roman
      leetcode #12
      https://leetcode.com/problems/integer-to-roman/
      Difficulty: Medium
   */
  public class Solution {
    private final char[] symbols = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    private String repeat(char c, int times) {
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < times; i++) {
        result.append(c);
      }
      return result.toString();
    }

    public String intToRoman(int num) {
      if (num < 1 || num > 3999)
        throw new IllegalArgumentException("input is out of range");

      StringBuilder roman = new StringBuilder();
      int scala = 1000;
      for (int i = 0; i < symbols.length; i += 2) {
        int digit = num / scala;
        num %= scala;
        scala /= 10;
        if (digit == 9) {
          roman.append(symbols[i]);
          roman.append(symbols[i-2]);
        } else if (digit >= 5) {
          roman.append(symbols[i-1]);
          roman.append(repeat(symbols[i], digit - 5));
        } else if (digit == 4) {
          roman.append(symbols[i]);
          roman.append(symbols[i-1]);
        } else {
          roman.append(repeat(symbols[i], digit));
        }
      }
      return roman.toString();
    }
  }

  /*
      Integer to Roman
      leetcode #12
      https://leetcode.com/problems/integer-to-roman/
      Difficulty: Medium
   */
  public class Solution_2 {
    private final int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4,
            1
    };

    private final String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV",
            "I"
    };

    public String intToRoman(int num) {
      if (num < 1 || num > 3999)
        throw new IllegalArgumentException("input is out of range");

      StringBuilder roman = new StringBuilder();

      for (int i = 0; i < values.length && num > 0; i++) {
        while (num / values[i] > 0) {
          roman.append(symbols[i]);
          num -= values[i];
        }
      }
      return roman.toString();
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new IntegertoRoman().new Solution();
      assertEquals("III", sol.intToRoman(3));
      assertEquals("XV", sol.intToRoman(15));
      assertEquals("XLIX", sol.intToRoman(49));
      assertEquals("XCVII", sol.intToRoman(97));
      assertEquals("XCIX", sol.intToRoman(99));
      assertEquals("CCC", sol.intToRoman(300));
      assertEquals("MXCVI", sol.intToRoman(1096));
      assertEquals("MMCCC", sol.intToRoman(2300));
    }

    @Test
    public void test2() {
      Solution_2 sol = new IntegertoRoman().new Solution_2();
      assertEquals("III", sol.intToRoman(3));
      assertEquals("XV", sol.intToRoman(15));
      assertEquals("XLIX", sol.intToRoman(49));
      assertEquals("XCVII", sol.intToRoman(97));
      assertEquals("XCIX", sol.intToRoman(99));
      assertEquals("CCC", sol.intToRoman(300));
      assertEquals("MXCVI", sol.intToRoman(1096));
      assertEquals("MMCCC", sol.intToRoman(2300));
    }
  }
}
