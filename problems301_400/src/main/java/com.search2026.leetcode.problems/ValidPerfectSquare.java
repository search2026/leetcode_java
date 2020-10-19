package com.search2026.leetcode.problems;

public class ValidPerfectSquare {

    /*
        Valid Perfect Square
        Leetcode #367
        https://leetcode.com/problems/valid-perfect-square/
        Difficulty: Medium
     */
    public class Solution {
        boolean isPerfectSquare(int num) {
            if (num < 1) return false;
            for (int i = 1; num > 0; i += 2) {
                num -= i;
            }
            return num == 0;
        }
    }

    /*
      Valid Perfect Square - Binary Search
      Leetcode #367
      https://leetcode.com/problems/valid-perfect-square/
      Difficulty: Medium
   */
    public class Solution_2 {
        public boolean isPerfectSquare(int num) {
            if (num < 1) return false;
            long left = 1, right = num;// long type to avoid 2147483647 case

            while (left <= right) {
                long mid = left + (right - left) / 2;
                long t = mid * mid;
                if (t > num) {
                    right = mid - 1;
                } else if (t < num) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }

            return false;
        }
    }

    /*
        Valid Perfect Square - Newton Method
        Leetcode #367
        https://leetcode.com/problems/valid-perfect-square/
        Difficulty: Medium
     */
    public class Solution_3 {
        boolean isPerfectSquare(int num) {
            if (num < 1) return false;
            if (num == 1) return true;
            long t = num / 2;
            while (t * t > num) {
                t = (t + num / t) / 2;
            }
            return t * t == num;
        }
    }

}
