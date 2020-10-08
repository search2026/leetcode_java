package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

    /*
        Factor Combinations
        Leetcode #254
        https://github.com/search2026/leetcode_java/blob/master/resources/FactorCombinations.md
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> getFactors(int n) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            if (n <= 3) return res;
            search(2, n, res, cur);
            return res;
        }

        public void search(int start, int n, List<List<Integer>> res, List<Integer> cur) {
            if (n == 1) {
                if (cur.size() > 1) {
                    res.add(new ArrayList<>(cur));
                    return;
                }
            }
            for (int i = start; i <= n; i++) {
                if (n % i == 0) {
                    cur.add(i);
                    search(i, n / i, res, cur);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

}
