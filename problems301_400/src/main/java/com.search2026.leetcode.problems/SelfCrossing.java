package com.search2026.leetcode.problems;

public class SelfCrossing {

    /*
        Self Crossing
        Leetcode #335
        https://leetcode.com/problems/self-crossing/
        Difficulty: Medium
     */
    public class Solution {
        public boolean isSelfCrossing(int[] x) {
            if (x == null || x.length < 4) return false;
            int n = x.length;
            int[] table = new int[4];
            boolean longer = false;

            table[0] = 0;
            for (int i = 0; i < 3; i++)
                table[i + 1] = x[i];

            if (table[1] < table[3]) longer = true;
            else longer = false;

            for (int i = 3; i < n; i++) {
                if (!longer && x[i] >= table[2]) return true;

                if (longer && x[i] <= table[2]) {
                    if (x[i] + table[0] < table[2] || (i + 1 < n && x[i + 1] + table[1] < table[3]))
                        longer = false;
                    else if (i + 1 < n) {
                        return true;
                    }
                }

                for (int j = 0; j < 3; j++)
                    table[j] = table[j + 1];
                table[3] = x[i];
            }

            return false;
        }
    }

}
