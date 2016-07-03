package valid_parentheses;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParentheses {
  /*
      Valid Parentheses
      Leetcode #20
      https://leetcode.com/problems/valid-parentheses/
      Difficulty: Easy
   */
  public class Solution {
    public boolean isValid(String s) {
      Deque<Character> stack = new ArrayDeque<>();
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(' || c == '[' || c == '{') {
          stack.push(c);
        } else if (stack.isEmpty()) {
          return false;
        } else {
          char top = stack.pop();
          if (c == ')' && top != '(') {
            return false;
          }
          if (c == ']' && top != '[') {
            return false;
          }
          if (c == '}' && top != '{') {
            return false;
          }
        }
      }
      return stack.isEmpty();
    }
  }

  /*
      Valid Parentheses
      Leetcode #20
      https://leetcode.com/problems/valid-parentheses/
      Difficulty: Easy
   */
  public class Solution_2 {
    private final Map<Character, Character> map =
            new HashMap<Character, Character>() {{
              put('(', ')');
              put('{', '}');
              put('[', ']');
            }};

    public boolean isValid(String s) {
      Deque<Character> stack = new ArrayDeque<>();
      for (char c : s.toCharArray()) {
        if (map.containsKey(c)) {
          stack.push(c);
        } else if (stack.isEmpty() || (map.get(stack.pop()) != c)) {
          return false;
        }
      }
      return stack.isEmpty();
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new ValidParentheses().new Solution();
      assertTrue(sol.isValid("()"));
      assertTrue(sol.isValid("()[]{}"));
      assertFalse(sol.isValid("(]"));
      assertFalse(sol.isValid("([)]"));
    }

    @Test
    public void test2() {
      Solution_2 sol = new ValidParentheses().new Solution_2();
      assertTrue(sol.isValid("()"));
      assertTrue(sol.isValid("()[]{}"));
      assertFalse(sol.isValid("(]"));
      assertFalse(sol.isValid("([)]"));
    }
  }
}
