package basic_calculator;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class BasicCalculator {
    /*
        Basic Calculator - Recursive
        Leetcode #224
        https://leetcode.com/problems/basic-calculator/
        Difficulty: Medium
    */
    public class Solution {
        private int eval(String s, int[] p) {
            int val = 0;
            int i = p[0];
            int oper = 1; //1:+ -1:-
            int num = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                switch (c) {
                    case '+':
                        val = val + oper * num;
                        num = 0;
                        oper = 1;
                        i++;
                        break;// end of number and set operator
                    case '-':
                        val = val + oper * num;
                        num = 0;
                        oper = -1;
                        i++;
                        break;// end of number and set operator
                    case '(':
                        p[0] = i + 1;
                        val = val + oper * eval(s, p);
                        i = p[0];
                        break; // start a new eval
                    case ')':
                        p[0] = i + 1;
                        return val + oper * num; // end current eval and return. Note that we need to deal with the last num
                    case ' ':
                        i++;
                        continue;
                    default:
                        num = num * 10 + c - '0';
                        i++;
                }
            }
            return val;
        }

        public int calculate(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("input can not be empty");
            }
            s = "(" + s + ")";
            int[] p = {0};
            return eval(s, p);
        }
    }

    /*
        Basic Calculator - Stack
        Leetcode #224
        https://leetcode.com/problems/basic-calculator/
        Difficulty: Medium
    */
    public class Solution_2 {
        public int calculate(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("input can not be empty");
            }
            int len = s.length(), sign = 1, res = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    int sum = s.charAt(i) - '0';
                    while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                        sum = sum * 10 + s.charAt(i + 1) - '0';
                        i++;
                    }
                    res += sum * sign;
                } else if (s.charAt(i) == '+')
                    sign = 1;
                else if (s.charAt(i) == '-')
                    sign = -1;
                else if (s.charAt(i) == '(') {
                    stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1;
                } else if (s.charAt(i) == ')') {
                    res = res * stack.pop() + stack.pop();
                }
            }
            return res;
        }
    }

    /*
        Basic Calculator - Array
        Leetcode #224
        https://leetcode.com/problems/basic-calculator/
        Difficulty: Medium
    */
    public class Solution_3 {
        public int calculate(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("input can not be empty");
            }
            int res = 0, sign = 1, len = s.length(), top = 0;
            int[] stack = new int[len]; // custom stack based on array
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    int num = c - '0';
                    while (i + 1 < len && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
                        num = num * 10 + (s.charAt(i++ + 1) - '0');
                    res += num * sign;
                } else if (c == '+' || c == '-') {
                    sign = c == '+' ? 1 : -1;
                } else if (c == '(') {
                    stack[top++] = res; // push
                    stack[top++] = sign; // push
                    res = 0;
                    sign = 1;
                } else if (c == ')') {
                    res = res * stack[--top] + stack[--top]; // first pop is for sign which says negative or positive.
                }
            }
            return res;
        }
    }

    /*
        Basic Calculator II - Stack
        Leetcode #227
        https://leetcode.com/problems/basic-calculator-ii/
        Difficulty: Medium
    */
    public class Solution_4 {
        public int calculate(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("input can not be empty");
            }
            Deque<Integer> stack = new ArrayDeque<>();
            int num = 0, len = s.length();
            char sign = '+';
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                }
                if ((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                    if (sign == '-') {
                        stack.push(-num);
                    } else if (sign == '+') {
                        stack.push(num);
                    } else if (sign == '*') {
                        stack.push(stack.pop() * num);
                    } else if (sign == '/') {
                        stack.push(stack.pop() / num);
                    }
                    sign = c;
                    num = 0;
                }
            }

            int res = 0;
            for (int i : stack) {
                res += i;
            }
            return res;
        }
    }

    /*
        Basic Calculator II - Stack
        Leetcode #227
        https://leetcode.com/problems/basic-calculator-ii/
        Difficulty: Medium
    */
    public class Solution_5 {
        public int calculate(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("input can not be empty");
            }
            Deque<Integer> stack = new ArrayDeque<>();
            int res = 0;
            char op = '+';
            for (int i = 0, num = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c))
                    num = num * 10 + (c - '0');
                if ("+-*/".indexOf(c) >= 0 || i == s.length() - 1) {
                    if ("*/".indexOf(op) >= 0)
                        res -= stack.peek();
                    switch (op) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                    }
                    num = 0;
                    op = c;
                    res += stack.peek();
                }
            }
            return res;
        }
    }

    /*
        Basic Calculator II - Np Stack
        Leetcode #227
        https://leetcode.com/problems/basic-calculator-ii/
        Difficulty: Medium
    */
    public class Solution_6 {
        public int calculate(String s) {
            if (s == null || s.isEmpty()) return 0;
            s = s.replaceAll(" ", "");
            int n = s.length(), res = 0, i = 0;
            long prevVal = 0;
            char sign = '+';
            while (i < n) {
                long curVal = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    curVal = curVal * 10 + s.charAt(i) - '0';
                    i++;
                }
                switch (sign) {
                    case '+':
                        res += prevVal;
                        prevVal = curVal;
                        break;
                    case '-':
                        res += prevVal;
                        prevVal = -curVal;
                        break;
                    case '*':
                        prevVal *= curVal;
                        break;
                    case '/':
                        prevVal /= curVal;
                        break;
                    default:
                        break;
                }
                if (i < n) {
                    sign = s.charAt(i);
                    i++;
                }
            }
            res += prevVal;
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BasicCalculator().new Solution();
            assertEquals(2, sol.calculate("1 + 1"));
            assertEquals(3, sol.calculate(" 2-1 + 2 "));
            assertEquals(23, sol.calculate("(1+(4+5+2)-3)+(6+8)"));
        }

        @Test
        public void test2() {
            Solution_2 sol = new BasicCalculator().new Solution_2();
            assertEquals(2, sol.calculate("1 + 1"));
            assertEquals(3, sol.calculate(" 2-1 + 2 "));
            assertEquals(23, sol.calculate("(1+(4+5+2)-3)+(6+8)"));
        }

        @Test
        public void test3() {
            Solution_3 sol = new BasicCalculator().new Solution_3();
            assertEquals(2, sol.calculate("1 + 1"));
            assertEquals(3, sol.calculate(" 2-1 + 2 "));
            assertEquals(23, sol.calculate("(1+(4+5+2)-3)+(6+8)"));
        }

        @Test
        public void test4() {
            Solution_4 sol = new BasicCalculator().new Solution_4();
            assertEquals(7, sol.calculate("3+2*2"));
            assertEquals(1, sol.calculate(" 3/2 "));
            assertEquals(5, sol.calculate(" 3+5 / 2 "));
        }

        @Test
        public void test5() {
            Solution_5 sol = new BasicCalculator().new Solution_5();
            assertEquals(7, sol.calculate("3+2*2"));
            assertEquals(1, sol.calculate(" 3/2 "));
            assertEquals(5, sol.calculate(" 3+5 / 2 "));
        }

        @Test
        public void test6() {
            Solution_6 sol = new BasicCalculator().new Solution_6();
            assertEquals(7, sol.calculate("3+2*2"));
            assertEquals(1, sol.calculate(" 3/2 "));
            assertEquals(5, sol.calculate(" 3+5 / 2 "));
        }
    }
}

