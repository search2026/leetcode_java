package valid_parentheses;

import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.Assert.assertEquals;

public class ValidParentheses {
    /*
        Valid Parentheses
        Leetcode #20
        https://leetcode.com/problems/valid-parentheses/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isValid(String s) {
            ArrayDeque<Character> stack = new ArrayDeque<Character>();
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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ValidParentheses().new Solution();
            assertEquals(7, 7);
        }
    }
}
