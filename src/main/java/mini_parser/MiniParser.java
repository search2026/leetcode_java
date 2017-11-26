package mini_parser;

import common.NestedInteger;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
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
            if (!s.startsWith("[")) {
                return new NestedInteger(Integer.valueOf(s));
            }
            Deque<NestedInteger> stack = new ArrayDeque<>();
            NestedInteger res = new NestedInteger();
            stack.push(res);
            int start = 1;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    NestedInteger ni = new NestedInteger();
                    stack.peek().add(ni);
                    stack.push(ni);
                    start = i + 1;
                } else if (c == ',' || c == ']') {
                    if (i > start) {
                        Integer val = Integer.valueOf(s.substring(start, i));
                        stack.peek().add(new NestedInteger(val));
                    }
                    start = i + 1;
                    if (c == ']') {
                        stack.pop();
                    }
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

