package basic_calculator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class BasicCalculator {
    /*
        Basic Calculator
        Leetcode #224
        https://leetcode.com/problems/basic-calculator/
        Difficulty: Medium
    */
    public class Solution {
        public int calculate(String s) {
            // delete white spaces
            s = s.replaceAll(" ", "");

            Stack<String> stack = new Stack<String>();
            char[] arr = s.toCharArray();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == ' ')
                    continue;

                if (arr[i] >= '0' && arr[i] <= '9') {
                    sb.append(arr[i]);

                    if (i == arr.length - 1) {
                        stack.push(sb.toString());
                    }
                } else {
                    if (sb.length() > 0) {
                        stack.push(sb.toString());
                        sb = new StringBuilder();
                    }

                    if (arr[i] != ')') {
                        stack.push(new String(new char[]{arr[i]}));
                    } else {
                        // when meet ')', pop and calculate
                        ArrayList<String> t = new ArrayList<String>();
                        while (!stack.isEmpty()) {
                            String top = stack.pop();
                            if (top.equals("(")) {
                                break;
                            } else {
                                t.add(0, top);
                            }
                        }

                        int temp = 0;
                        if (t.size() == 1) {
                            temp = Integer.valueOf(t.get(0));
                        } else {
                            for (int j = t.size() - 1; j > 0; j = j - 2) {
                                if (t.get(j - 1).equals("-")) {
                                    temp += 0 - Integer.valueOf(t.get(j));
                                } else {
                                    temp += Integer.valueOf(t.get(j));
                                }
                            }
                            temp += Integer.valueOf(t.get(0));
                        }
                        stack.push(String.valueOf(temp));
                    }
                }
            }

            ArrayList<String> t = new ArrayList<String>();
            while (!stack.isEmpty()) {
                String elem = stack.pop();
                t.add(0, elem);
            }

            int temp = 0;
            for (int i = t.size() - 1; i > 0; i = i - 2) {
                if (t.get(i - 1).equals("-")) {
                    temp += 0 - Integer.valueOf(t.get(i));
                } else {
                    temp += Integer.valueOf(t.get(i));
                }
            }
            temp += Integer.valueOf(t.get(0));

            return temp;
        }
    }

    // Basic Calculator II
    // https://leetcode.com/problems/basic-calculator-ii/
    // Difficulty: Medium
    public class SolutionII {
        int rank(char op) {
            // the bigger the number, the higher the rank
            switch (op) {
                case '+':
                    return 1;
                case '-':
                    return 1;
                case '*':
                    return 2;
                case '/':
                    return 2;
                default:
                    return 0; // '('
            }
        }

        List<Object> infixToPostfix(String s) {
            Stack<Character> operators = new Stack<Character>();
            List<Object> postfix = new LinkedList<Object>();

            int numberBuffer = 0;
            boolean bufferingOperand = false;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    numberBuffer = numberBuffer * 10 + c - '0';
                    bufferingOperand = true;
                } else {
                    if (bufferingOperand)
                        postfix.add(numberBuffer);
                    numberBuffer = 0;
                    bufferingOperand = false;

                    if (c == ' ' || c == '\t')
                        continue;

                    if (c == '(') {
                        operators.push('(');
                    } else if (c == ')') {
                        while (operators.peek() != '(')
                            postfix.add(operators.pop());
                        operators.pop(); // popping "("
                    } else { // operator
                        while (!operators.isEmpty() && rank(c) <= rank(operators.peek()))
                            postfix.add(operators.pop());
                        operators.push(c);
                    }
                }

            }
            if (bufferingOperand)
                postfix.add(numberBuffer);

            while (!operators.isEmpty())
                postfix.add(operators.pop());

            return postfix;
        }

        int evaluatePostfix(List<Object> postfix) {
            Stack<Integer> operands = new Stack<Integer>();
            int a = 0, b = 0;
            for (Object s : postfix) {
                if (s instanceof Character) {
                    char c = (Character) s;
                    b = operands.pop();
                    a = operands.pop();
                    switch (c) {
                        case '+':
                            operands.push(a + b);
                            break;
                        case '-':
                            operands.push(a - b);
                            break;
                        case '*':
                            operands.push(a * b);
                            break;
                        default:
                            operands.push(a / b);
                    }
                } else { // instanceof Integer
                    operands.push((Integer) s);
                }
            }
            return operands.pop();
        }

        public int calculate(String s) {
            return evaluatePostfix(infixToPostfix(s));
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BasicCalculator().new Solution();
            assertTrue(true);
        }
    }
}

