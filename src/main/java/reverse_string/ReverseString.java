package reverse_string;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseString {
  /*
      Reverse String
      Leetcode #344
      https://leetcode.com/problems/reverse-string/
      Difficulty: Easy
   */
  public class Solution {
    public String reverseString(String s) {
      if (s == null || s.length() == 0) return "";
      int n = s.length();
      if (n == 1) return s;
      char[] sChars = s.toCharArray();
      for (int i = 0; i < n / 2; i++) {
        char t = sChars[i];
        sChars[i] = sChars[n - i - 1];
        sChars[n - i - 1] = t;
      }
      return new String(sChars);
    }
  }

  /*
      Reverse String
      Leetcode #344
      https://leetcode.com/problems/reverse-string/
      Difficulty: Easy
   */
  public class Solution_2 {
    private void reverseStringArray(char[] s) {
      int n = s.length;
      for (int i = 0; i < n / 2; i++) {
        char t = s[i];
        s[i] = s[n - i - 1];
        s[n - i - 1] = t;
      }
    }

    public String reverseString(String s) {
      if (s == null || s.length() == 0) return "";
      int n = s.length();
      if (n == 1) return s;
      char[] sChars = s.toCharArray();
      reverseStringArray(sChars);
      return new String(sChars);
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new ReverseString().new Solution();
      assertTrue(sol.reverseString("").equals(""));
      assertTrue(sol.reverseString(null).equals(""));
      assertTrue(sol.reverseString("s").equals("s"));
      assertEquals("olleh", sol.reverseString("hello"));
      assertTrue(sol.reverseString("abcccd").equals("dcccba"));
    }

    @Test
    public void test2() {
      Solution_2 sol = new ReverseString().new Solution_2();
      assertTrue(sol.reverseString("").equals(""));
      assertTrue(sol.reverseString(null).equals(""));
      assertTrue(sol.reverseString("s").equals("s"));
      assertEquals("olleh", sol.reverseString("hello"));
      assertTrue(sol.reverseString("abcccd").equals("dcccba"));
    }
  }
}

