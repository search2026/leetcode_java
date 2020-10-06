package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {

    /*
        Ugly Number
        Leetcode #263
        https://leetcode.com/problems/ugly-number/
        Difficulty: Easy
    */
    public class Solution {
        public boolean isUgly(int num) {
            if (num <= 0) {
                return false;
            }

            while (num > 1 && num % 2 == 0) {
                num /= 2;
            }

            while (num > 1 && num % 3 == 0) {
                num /= 3;
            }

            while (num > 1 && num % 5 == 0) {
                num /= 5;
            }

            if (num == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    /*
        Ugly Number II
        Leetcode #264
        https://leetcode.com/problems/ugly-number-ii/
        Difficulty: Medium
    */
    public class Solution_2 {
        public int nthUglyNumber(int n) {
            if (n <= 0) {
                return 0;
            }

            List<Integer> nums = new ArrayList<Integer>();
            nums.add(1);

            int i = 0;
            int j = 0;
            int k = 0;

            while (nums.size() < n) {
                int m2 = nums.get(i) * 2;
                int m3 = nums.get(j) * 3;
                int m5 = nums.get(k) * 5;

                int mn = Math.min(Math.min(m2, m3), m5);
                nums.add(mn);

                if (mn == m2) {
                    i++;
                }

                if (mn == m3) {
                    j++;
                }

                if (mn == m5) {
                    k++;
                }
            }

            return nums.get(nums.size() - 1);
        }
    }

}
