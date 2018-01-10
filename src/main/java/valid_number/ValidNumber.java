package valid_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class ValidNumber {
  /*
      Valid Number
      leetcode #65
      https://leetcode.com/problems/valid-number/
      Difficulty: Hard
   */
  public enum Status {
    INIT, SYMBOL, INT, DOT, FRAC, E, SYMBOL_E, INT_E
  }

  public class Solution {
    public boolean isNumber(String s) {
      if (s == null || s.length() == 0) return false;
      s = s.trim();
      Status status = Status.INIT;
      boolean hasInt = false;

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        switch (status) {
          case INIT:
            if (c == '+' || c == '-') {
              status = Status.SYMBOL;
            } else if (Character.isDigit(c)) {
              status = Status.INT;
              hasInt = true;
            } else if (c == '.') {
              status = Status.DOT;
            } else {
              return false;
            }
            break;
          case SYMBOL:
            if (Character.isDigit(c)) {
              status = Status.INT;
              hasInt = true;
            } else if (c == '.') {
              status = Status.DOT;
            } else {
              return false;
            }
            break;
          case INT:
            if (Character.isDigit(c)) {

            } else if (c == '.') {
              status = Status.DOT;
            } else if (c == 'E' || c == 'e') {
              status = Status.E;
            } else {
              return false;
            }
            break;
          case DOT:
            if (Character.isDigit(c)) {
              status = Status.FRAC;
            } else if (c == 'E' || c == 'e') {
              if (!hasInt) {
                return false;
              }
              status = Status.E;
            } else {
              return false;
            }
            break;
          case FRAC:
            if (Character.isDigit(c)) {
            } else if (c == 'E' || c == 'e') {
              status = Status.E;
            } else {
              return false;
            }
            break;
          case E:
            if (Character.isDigit(c)) {
              status = Status.INT_E;
            } else if (c == '+' || c == '-') {
              status = Status.SYMBOL_E;
            } else {
              return false;
            }
            break;
          case SYMBOL_E:
            if (Character.isDigit(c)) {
              status = Status.INT_E;
            } else {
              return false;
            }
            break;
          case INT_E:
            if (Character.isDigit(c)) {
            } else {
              return false;
            }
            break;
        }
      }

      return (hasInt && status == Status.DOT) || status == Status.INT
              || status == Status.FRAC || status == Status.INT_E;
    }
  }

  /*
      Valid Number
      leetcode #65
      https://leetcode.com/problems/valid-number/
      Difficulty: Hard
    */
  public class Solution_2 {
    public boolean isNumber(String s) {
      if (s == null || s.length() == 0) return false;
      s = s.trim();
      boolean pointSeen = false;
      boolean eSeen = false;
      boolean numberSeen = false;
      boolean numberAfterE = true;

      for (int i = 0; i < s.length(); i++) {
        if (Character.isDigit(s.charAt(i))) {
          numberSeen = true;
          numberAfterE = true;
        } else if (s.charAt(i) == '.') {
          if (eSeen || pointSeen) {
            return false;
          }
          pointSeen = true;
        } else if ((s.charAt(i) == 'e') || (s.charAt(i) == 'E')) {
          if (eSeen || !numberSeen) {
            return false;
          }
          numberAfterE = false;
          eSeen = true;
        } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
          if (i != 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
            return false;
          }
        } else {
          return false;
        }
      }

      return numberSeen && numberAfterE;
    }
  }

  /*
      Valid Number
      leetcode #65
      https://leetcode.com/problems/valid-number/
      Difficulty: Hard
    */
  public class Solution_3 {
    public boolean isNumber(String s) {
      if (s == null || s.length() == 0) return false;
      s = s.trim();
      int i = 0, n = s.length();
      if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
      boolean isNumeric = false;
      while ( i < n && Character.isDigit(s.charAt(i))) {
        i++;
        isNumeric = true;
      }
      if (i<n && s.charAt(i) == '.') {
        i++;
        while ( i < n && Character.isDigit(s.charAt(i))) {
          i++;
          isNumeric = true;
        }
      }
      if (isNumeric && i<n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
        i++;
        isNumeric = false;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        while ( i < n && Character.isDigit(s.charAt(i))) {
          i++;
          isNumeric = true;
        }
      }

      return isNumeric && i == n;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new ValidNumber().new Solution();
      assertTrue(sol.isNumber("0"));
      assertTrue(sol.isNumber(" 0.1"));
      assertFalse(sol.isNumber("abc"));
      assertFalse(sol.isNumber("1 a"));
      assertTrue(sol.isNumber("2e10"));
      assertTrue(sol.isNumber("20.355E-235"));
    }

    @Test
    public void test2() {
      Solution_2 sol = new ValidNumber().new Solution_2();
      assertTrue(sol.isNumber("0"));
      assertTrue(sol.isNumber(" 0.1"));
      assertFalse(sol.isNumber("abc"));
      assertFalse(sol.isNumber("1 a"));
      assertTrue(sol.isNumber("2e10"));
      assertTrue(sol.isNumber("20.355E-235"));
    }

    @Test
    public void test3() {
      Solution_3 sol = new ValidNumber().new Solution_3();
      assertTrue(sol.isNumber("0"));
      assertTrue(sol.isNumber(" 0.1"));
      assertFalse(sol.isNumber("abc"));
      assertFalse(sol.isNumber("1 a"));
      assertTrue(sol.isNumber("2e10"));
      assertTrue(sol.isNumber("20.355E-235"));
    }
  }
}
