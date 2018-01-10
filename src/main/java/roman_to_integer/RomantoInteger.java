package roman_to_integer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomantoInteger {
  /*
      Roman to Integer
      Leetcode #13
      https://leetcode.com/problems/roman-to-integer/
      Difficulty: Easy
   */
  public class Solution {
    private final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
      put('M', 1000);
      put('D', 500);
      put('C', 100);
      put('L', 50);
      put('X', 10);
      put('V', 5);
      put('I', 1);
    }};


    public int romanToInt(String s) {
      if (s == null || s.length() == 0)
        throw new IllegalArgumentException("empty input");

      int prev = 0, num = 0;
      for (char c : s.toCharArray()) {
        int curr = map.get(c);
        num += (curr > prev) ? (curr - 2 * prev) : curr;
        prev = curr;
      }

      return num;
    }
  }

  /*
      Roman to Integer
      Leetcode #13
      https://leetcode.com/problems/roman-to-integer/
      Difficulty: Easy
   */
  public class Solution_2 {
    private final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
      put('I', 1);
      put('V', 5);
      put('X', 10);
      put('L', 50);
      put('C', 100);
      put('D', 500);
      put('M', 1000);
    }};

    public int romanToInt(String s) {
      if (s == null || s.length() == 0)
        throw new IllegalArgumentException("empty input");

      int num = 0, prev = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
        int curr = map.get(s.charAt(i));
        num += (curr >= prev) ? curr : -curr;
        prev = curr;
      }

      return num;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new RomantoInteger().new Solution();
      assertEquals(3, sol.romanToInt("III"));
      assertEquals(15, sol.romanToInt("XV"));
      assertEquals(49, sol.romanToInt("XLIX"));
      assertEquals(97, sol.romanToInt("XCVII"));
      assertEquals(99, sol.romanToInt("XCIX"));
      assertEquals(300, sol.romanToInt("CCC"));
      assertEquals(1010, sol.romanToInt("MX"));
      assertEquals(1090, sol.romanToInt("MXC"));
      assertEquals(1095, sol.romanToInt("MXCV"));
      assertEquals(1096, sol.romanToInt("MXCVI"));
      assertEquals(2300, sol.romanToInt("MMCCC"));
    }

    @Test
    public void test2() {
      Solution_2 sol = new RomantoInteger().new Solution_2();
      assertEquals(3, sol.romanToInt("III"));
      assertEquals(15, sol.romanToInt("XV"));
      assertEquals(49, sol.romanToInt("XLIX"));
      assertEquals(97, sol.romanToInt("XCVII"));
      assertEquals(99, sol.romanToInt("XCIX"));
      assertEquals(300, sol.romanToInt("CCC"));
      assertEquals(1010, sol.romanToInt("MX"));
      assertEquals(1090, sol.romanToInt("MXC"));
      assertEquals(1095, sol.romanToInt("MXCV"));
      assertEquals(1096, sol.romanToInt("MXCVI"));
      assertEquals(2300, sol.romanToInt("MMCCC"));
    }
  }
}
