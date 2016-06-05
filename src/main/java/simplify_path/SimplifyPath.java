package simplify_path;

import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.Assert.assertEquals;

public class SimplifyPath {
    /*
        Simplify Path
        Leetcode #71
        https://leetcode.com/problems/simplify-path/
        Difficulty: Medium
     */
    public class Solution {
        public String simplifyPath(String path) {
            String[] splits = path.split("/");
            ArrayDeque<String> stack = new ArrayDeque<String>();
            for (String split : splits) {
                if (!split.isEmpty()) {
                    if (split.equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.removeLast();
                        }
                    } else if (split.equals(".")) {
                        continue;
                    } else {
                        stack.offerLast(split);
                    }
                }
            }
            StringBuilder newPath = new StringBuilder();
            for (String s : stack) {
                newPath.append('/');
                newPath.append(s);
            }
            return newPath.length() == 0 ? "/" : newPath.toString();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SimplifyPath().new Solution();
            assertEquals(7, 7);
        }
    }
}
