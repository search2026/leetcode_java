package com.search2026.leetcode.problems;

import java.util.*;

public class RemoveInvalidParentheses {

    /*
        Remove Invalid Parentheses - BFS
        Leetcode #301
        https://leetcode.com/problems/remove-invalid-parentheses/
        Difficulty: Hard
     */
    public class Solution {
        private boolean isValid(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') count++;
                if (c == ')' && count-- == 0) return false;
            }
            return count == 0;
        }

        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            if (s == null || s.length() == 0) return res;

            boolean found = false;
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.add(s);
            visited.add(s);
            while (!queue.isEmpty()) {
                s = queue.poll();
                if (isValid(s)) {
                    res.add(s);
                    found = true;
                }
                if (found) continue;

                // generate all possible states
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) != '(' && s.charAt(k) != ')')
                        continue;
                    //Avoid dup.
                    if (k > 0 && s.charAt(k) == s.charAt(k - 1))
                        continue;
                    String t = s.substring(0, k) + s.substring(k + 1);
                    if (!visited.contains(t)) {
                        queue.offer(t);
                        visited.add(t);
                    }
                }
            }

            return res;
        }
    }

    /*
        Remove Invalid Parentheses - DFS
        Leetcode #301
        https://leetcode.com/problems/remove-invalid-parentheses/
        Difficulty: Hard
     */
    public class Solution_2 {
        private void remove(String s, List<String> res, int last_i, int last_j, char[] par) {
            for (int stack = 0, i = last_i; i < s.length(); ++i) {
                if (s.charAt(i) == par[0]) stack++;
                if (s.charAt(i) == par[1]) stack--;
                if (stack >= 0) continue;
                for (int j = last_j; j <= i; ++j)
                    if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                        remove(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, par);
                return;
            }
            String reversed = new StringBuilder(s).reverse().toString();
            if (par[0] == '(')
                remove(reversed, res, 0, 0, new char[]{')', '('});
            else
                res.add(reversed);
        }

        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            if (s == null || s.length() == 0) return res;
            remove(s, res, 0, 0, new char[]{'(', ')'});
            return res;
        }
    }

}
