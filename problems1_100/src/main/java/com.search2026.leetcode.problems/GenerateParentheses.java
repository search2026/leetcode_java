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
            List<String> rslt = new ArrayList<String>();
            if (n <= 0)
                return rslt;
            search(n, n, "", rslt);
            return rslt;
        }

        private void search(int l, int r, String cur, List<String> rslt) {
            if (r < l)
                return;
            if (l == 0 && r == 0) {
                rslt.add(cur);
            }
            if (l > 0)
                search(l - 1, r, cur + "(", rslt);
            if (r > 0)
                search(l, r - 1, cur + ")", rslt);
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
            List<String> rslt = new ArrayList<String>();
            if (n == 0) {
                rslt.add("");
                return rslt;
            }

            search(n, 0, 0, rslt, "");
            return rslt;
        }

        public void search(int n, int left, int right, List<String> rslt, String cur) {
            // exit: all ( appeared
            if (left == n) {
                for (int i = 0; i < n - right; i++)
                    cur = cur + ")";
                rslt.add(cur);
                return;
            }

            // case1: number of ( > number of )
            if (left > right) {
                search(n, left + 1, right, rslt, cur + "(");
                search(n, left, right + 1, rslt, cur + ")");
            }

            // case2: number of ( == number of )
            else search(n, left + 1, right, rslt, cur + "(");
        }
    }

}
