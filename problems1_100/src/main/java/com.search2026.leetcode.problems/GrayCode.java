package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    /*
        Gray Code - Recursive
        Leetcode #89
        https://leetcode.com/problems/gray-code/
        Difficulty: Medium
     */
    public class Solution {
        public ArrayList<Integer> grayCode(int n) {
            ArrayList<Integer> codeList = new ArrayList<Integer>();
            if (n < 0) return codeList;
            codeList.add(0);
            for (int i = 0; i < n; i++) {
                int inc = 1 << i;
                for (int j = codeList.size() - 1; j >= 0; j--) {
                    codeList.add(codeList.get(j) + inc);
                }
            }
            return codeList;
        }
    }

    /*
        Gray Code - Formula
        Leetcode #89
        https://leetcode.com/problems/gray-code/
        Difficulty: Medium
     */
    public class Solution_2 {
        public List<Integer> grayCode(int n) {
            List<Integer> codeList = new ArrayList<>();
            if (n < 0) return codeList;
            for (int i = 0; i < (1 << n); i++) {
                codeList.add(i ^ (i >> 1));
            }
            return codeList;
        }
    }

}
