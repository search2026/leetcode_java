package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    /*
        4 Sum
        Leetcode #18
        https://leetcode.com/problems/4sum/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> fourSum(int[] num, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (num == null) {
                return res;
            }

            Arrays.sort(num);

            int len = num.length;
            for (int i = 0; i < len; i++) {
                if (i > 0 && num[i] == num[i - 1]) {
                    // skip duplicate.
                    continue;
                }

                for (int j = i + 1; j < len; j++) {
                    if (j > i + 1 && num[j] == num[j - 1]) {
                        // skip duplicate.
                        continue;
                    }

                    int left = j + 1;
                    int right = len - 1;

                    while (left < right) {
                        int sum = num[i] + num[j] + num[left] + num[right];
                        if (sum == target) {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(num[i]);
                            list.add(num[j]);
                            list.add(num[left]);
                            list.add(num[right]);

                            res.add(list);

                            do {
                                left++;
                            } while (left < right && num[left] == num[left - 1]);

                            do {
                                right--;
                            } while (left < right && num[right] == num[right + 1]);
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }

            return res;
        }
    }

}
