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
            for (char c : s.toCharArray()) {
                if (c == '(')
                    stack.push(')');
                else if (c == '{')
                    stack.push('}');
                else if (c == '[')
                    stack.push(']');
                else if (stack.isEmpty() || stack.pop() != c)
                    return false;
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

    /*
        Valid Parentheses
        Leetcode #20
        https://leetcode.com/problems/valid-parentheses/
        Difficulty: Easy
     */
    public class Solution_3 {
        private final String pattern = "(){}[]";

        public boolean isValid(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                int q = pattern.indexOf(s.substring(i, i + 1));
                if (q % 2 == 1) {
                    if (stack.isEmpty() || stack.pop() != q - 1) return false;
                } else stack.push(q);
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
            Solution_3 sol = new ValidParentheses().new Solution_3();
            assertTrue(sol.isValid("()"));
            assertTrue(sol.isValid("()[]{}"));
            assertFalse(sol.isValid("(]"));
            assertFalse(sol.isValid("([)]"));
        }
    }
}
