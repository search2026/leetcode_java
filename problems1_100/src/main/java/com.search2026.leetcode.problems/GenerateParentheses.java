package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /*
        Generate Parentheses
        Leetcode #22
        https://leetcode.com/problems/generate-parentheses/
        Difficulty: Medium
     */
    public class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n <= 0)
                return res;
            search(n, n, "", res);
            return res;
        }

        private void search(int l, int r, String cur, List<String> res) {
            if (r < l)
                return;
            if (l == 0 && r == 0) {
                res.add(cur);
            }
            if (l > 0)
                search(l - 1, r, cur + "(", res);
            if (r > 0)
                search(l, r - 1, cur + ")", res);
        }
    }

    /*
        Generate Parentheses
        Leetcode #22
        https://leetcode.com/problems/generate-parentheses/
        Difficulty: Medium
    */
    public class Solution_2 {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                res.add("");
                return res;
            }

            search(n, 0, 0, res, "");
            return res;
        }

        public void search(int n, int left, int right, List<String> res, String curr) {
            // exit: all ( appeared
            if (left == n) {
                res.add(curr + ")".repeat(Math.max(0, n - right)));
//                for (int i = 0; i < n - right; i++)
//                    curr = curr + ")";
                return;
            }

            // case1: number of ( > number of )
            if (left > right) {
                search(n, left + 1, right, res, curr + "(");
                search(n, left, right + 1, res, curr + ")");
            }

            // case2: number of ( == number of )
            else search(n, left + 1, right, res, curr + "(");
        }
    }

}
