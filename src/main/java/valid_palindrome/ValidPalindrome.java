package valid_palindrome;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class ValidPalindrome {
  /*
      Valid Palindrome
      Leetcode #125
      https://leetcode.com/problems/valid-palindrome/
      Difficulty: Easy
   */
  public class Solution {
    public boolean isPalindrome(String s) {
      if (s == null || s.length() == 0) return true;
      int p1 = 0, p2 = s.length() - 1;

      while (p1 < p2) {
        while (p1 < p2 && !Character.isLetterOrDigit(s.charAt(p1))) p1++;
        while (p1 < p2 && !Character.isLetterOrDigit(s.charAt(p2))) p2--;
        if (Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2))) {
          return false;
        }
        p1++;
        p2--;
      }

      return true;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new ValidPalindrome().new Solution();
      assertTrue(sol.isPalindrome("A man, a plan, a canal: Panama"));
      assertFalse(sol.isPalindrome("race a car"));
    }
  }
}
