package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    /*
        Expression Add Operators
        Leetcode #282
        https://leetcode.com/problems/expression-add-operators/
        Difficulty: Medium
     */
    public class Solution {
        public void search(List<String> res, String cur, String num, int pos, long sum, long preVal, long target) {
            if (pos == num.length()) {
                if (sum == target) {
                    res.add(cur);
                }
                return;
            }
            for (int i = pos + 1; i <= num.length(); i++) {
                if (num.charAt(pos) == '0' && i > pos + 1) break; // case like: 105  1+05 wrong, 1+0+5 right
                String curStr = num.substring(pos, i);
                long curNum = Long.parseLong(curStr);
                if (pos == 0) {
                    search(res, curStr, num, i, curNum, curNum, target);
                } else {
                    search(res, cur + "+" + curStr, num, i, sum + curNum, curNum, target);
                    search(res, cur + "-" + curStr, num, i, sum - curNum, -curNum, target);
                    search(res, cur + "*" + curStr, num, i, sum - preVal + preVal * curNum, preVal * curNum, target);
                }
            }
        }

        public List<String> addOperators(String num, int target) {
            List<String> res = new ArrayList<>();
            if (num == null || num.length() == 0) return res;
            search(res, "", num, 0, 0, 0, (long) target);
            return res;
        }
    }

}
