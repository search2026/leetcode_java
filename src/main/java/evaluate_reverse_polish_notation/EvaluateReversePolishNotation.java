package evaluate_reverse_polish_notation;

import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.Assert.assertTrue;

public class EvaluateReversePolishNotation {
    /*
        Evaluate Reverse Polish Notation
        https://leetcode.com/problems/evaluate-reverse-polish-notation/
        Difficulty: Medium
     */
    public class Solution {
        public int evalRPN(String[] tokens) {
            ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
            for (String token : tokens) {
                if (token.equals("+")) {
                    int num2 = stack.removeLast();
                    int num1 = stack.removeLast();
                    stack.offerLast(num1 + num2);
                } else if (token.equals("-")) {
                    int num2 = stack.removeLast();
                    int num1 = stack.removeLast();
                    stack.offerLast(num1 - num2);
                } else if (token.equals("*")) {
                    int num2 = stack.removeLast();
                    int num1 = stack.removeLast();
                    stack.offerLast(num1 * num2);
                } else if (token.equals("/")) {
                    int num2 = stack.removeLast();
                    int num1 = stack.removeLast();
                    stack.offerLast(num1 / num2);
                } else {
                    stack.offerLast(Integer.parseInt(token));
                }
            }
            return stack.removeLast();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new EvaluateReversePolishNotation().new Solution();
            assertTrue(true);
        }
    }
}
