package com.search2026.leetcode.problems;

import java.util.ArrayList;

public class PermutationSequence {

    /*
        Permutation Sequence
        Leetcode #60
        https://leetcode.com/problems/permutation-sequence/
        Difficulty: Medium
     */
    public class Solution {
        public String getPermutation(int n, int k) {
            ArrayList<Integer> nums = new ArrayList<Integer>();
            int[] factors = new int[n + 1];
            factors[0] = 1;
            int tmp = 1;
            for (int i = 1; i <= n; i++) {
                tmp = tmp * i;
                factors[i] = tmp;
            }
            for (int i = 0; i < n; i++) nums.add(i + 1);

            StringBuilder res = new StringBuilder();
            k--;
            for (int i = 0; i < n; i++) {
                int digit = 0;
                int index = k / factors[n - i - 1];
                digit = nums.remove(index);
                k = k % factors[n - i - 1];
                res.append(digit);
            }
            return res.toString();
        }
    }

}
