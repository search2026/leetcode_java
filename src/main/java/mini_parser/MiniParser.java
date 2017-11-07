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
            int l = 0; // l shall point to the start of a number substring;
            // r shall point to the end+1 of a number substring
            for (int r = 0; r < s.length(); r++) {
                char ch = s.charAt(r);
                if (ch == '[') {
                    if (res != null) {
                        stack.push(res);
                    }
                    res = new NestedInteger();
                    l = r + 1;
                } else if (ch == ']') {
                    String num = s.substring(l, r);
                    if (!num.isEmpty())
                        res.add(new NestedInteger(Integer.valueOf(num)));
                    if (!stack.isEmpty()) {
                        NestedInteger pop = stack.pop();
                        pop.add(res);
                        res = pop;
                    }
                    l = r + 1;
                } else if (ch == ',') {
                    if (s.charAt(r - 1) != ']') {
                        String num = s.substring(l, r);
                        res.add(new NestedInteger(Integer.valueOf(num)));
                    }
                    l = r + 1;
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
            assertEquals(324, (int)res.getInteger());
            res = sol.deserialize("[123,[456,[789]]]");
            assertEquals(2, (int)res.getList().size());
        }
    }
}

