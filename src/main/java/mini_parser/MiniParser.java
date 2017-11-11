package mini_parser;

import common.NestedInteger;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class MiniParser {
    /*
        Mini Parser - Iterative
        Leetcode #385
        Difficulty: Medium
        https://leetcode.com/problems/mini-parser/
     */
    public class Solution {
        public NestedInteger deserialize(String s) {
            if (s.isEmpty())
                return null;
            if (s.charAt(0) != '[') // ERROR: special case
                return new NestedInteger((Integer.valueOf(s)));

            Stack<NestedInteger> stack = new Stack<>();
            NestedInteger res = null;
            int left = 0; // l shall point to the start of a number substring;
            // r shall point to the end+1 of a number substring
            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                if (c == '[') {
                    if (res != null) {
                        stack.push(res);
                    }
                    res = new NestedInteger();
                    left = right + 1;
                } else if (c == ']') {
                    String num = s.substring(left, right);
                    if (!num.isEmpty())
                        res.add(new NestedInteger(Integer.valueOf(num)));
                    if (!stack.isEmpty()) {
                        NestedInteger pop = stack.pop();
                        pop.add(res);
                        res = pop;
                    }
                    left = right + 1;
                } else if (c == ',') {
                    if (s.charAt(right - 1) != ']') {
                        String num = s.substring(left, right);
                        res.add(new NestedInteger(Integer.valueOf(num)));
                    }
                    left = right + 1;
                }
            }

            return res;
        }
    }

    /*
        Mini Parser - Recursive
        Leetcode #385
        Difficulty: Medium
        https://leetcode.com/problems/mini-parser/
     */
    public class Solution_2 {
        public NestedInteger deserialize(String s) {
            NestedInteger res = new NestedInteger();
            if (s == null || s.length() == 0) return res;
            if (s.charAt(0) != '[') {
                res.setInteger(Integer.parseInt(s));
            }
            else if (s.length() > 2) {
                int start = 1, count = 0;
                for (int i = 1; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (count == 0 && (c == ',' || i == s.length() - 1)) {
                        res.add(deserialize(s.substring(start, i)));
                        start = i + 1;
                    }
                    else if (c == '[') count++;
                    else if (c == ']') count--;
                }
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MiniParser().new Solution();
            NestedInteger res = sol.deserialize("324");
            assertEquals(324, (int) res.getInteger());
            res = sol.deserialize("[123,[456,[789]]]");
            assertEquals(2, (int) res.getList().size());
        }

        @Test
        public void test2() {
            Solution_2 sol = new MiniParser().new Solution_2();
            NestedInteger res = sol.deserialize("324");
            assertEquals(324, (int) res.getInteger());
            res = sol.deserialize("[123,[456,[789]]]");
            assertEquals(2, (int) res.getList().size());
        }
    }
}

