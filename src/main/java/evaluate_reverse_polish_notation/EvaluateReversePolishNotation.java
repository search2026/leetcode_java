package evaluate_reverse_polish_notation;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class EvaluateReversePolishNotation {
  /*
      Evaluate Reverse Polish Notation
      Leetcode #150
      https://leetcode.com/problems/evaluate-reverse-polish-notation/
      Difficulty: Medium
   */
  public class Solution {
    private final Set<String> OPERATORS =
            new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    private int eval(int x, int y, String operator) {
      switch (operator) {
        case "+":
          return x + y;
        case "-":
          return x - y;
        case "*":
          return x * y;
        case "/":
          return x / y;
        default:
          throw new IllegalArgumentException("Illeal Operators");
      }
    }

    public int evalRPN(String[] tokens) {
      if (tokens == null || tokens.length < 3)
        throw new IllegalArgumentException("Invalidate inputs");
      Deque<Integer> stack = new ArrayDeque<>();
      for (String token : tokens) {
        if (OPERATORS.contains(token)) {
          int num2 = stack.pop();
          int num1 = stack.pop();
          stack.push(eval(num1, num2, token));
        } else {
          stack.push(Integer.parseInt(token));
        }
      }
      return stack.pop();
    }
  }

  /*
    Evaluate Reverse Polish Notation
    Leetcode #150
    https://leetcode.com/problems/evaluate-reverse-polish-notation/
    Difficulty: Medium
 */
  interface Operator {
    int eval(int x, int y);
  }

  public class Solution_2 {
    private final Map<String, Operator> OPERATORS =
        new HashMap<String, Operator>() {{
          put("+", new Operator() {
            public int eval(int x, int y) {
              return x + y;
            }
          });
          put("-", new Operator() {
            public int eval(int x, int y) {
              return x - y;
            }
          });
          put("*", new Operator() {
            public int eval(int x, int y) {
              return x * y;
            }
          });
          put("/", new Operator() {
            public int eval(int x, int y) {
              return x / y;
            }
          });
        }};

    public int evalRPN(String[] tokens) {
      if (tokens == null || tokens.length < 3)
        throw new IllegalArgumentException("Invalidate inputs");
      Deque<Integer> stack = new ArrayDeque<>();
      for (String token : tokens) {
        if (OPERATORS.containsKey(token)) {
          int num2 = stack.pop();
          int num1 = stack.pop();
          stack.push(OPERATORS.get(token).eval(num1, num2));
        } else {
          stack.push(Integer.parseInt(token));
        }
      }
      return stack.pop();
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new EvaluateReversePolishNotation().new Solution();
      String[] test1 = {"2", "1", "+", "3", "*"};
      assertEquals(9, sol.evalRPN(test1));

      String[] test2 = {"4", "13", "5", "/", "+"};
      assertEquals(6, sol.evalRPN(test2));
    }

    @Test
    public void test2() {
      Solution_2 sol = new EvaluateReversePolishNotation().new Solution_2();
      String[] test1 = {"2", "1", "+", "3", "*"};
      assertEquals(9, sol.evalRPN(test1));

      String[] test2 = {"4", "13", "5", "/", "+"};
      assertEquals(6, sol.evalRPN(test2));
    }
  }
}
