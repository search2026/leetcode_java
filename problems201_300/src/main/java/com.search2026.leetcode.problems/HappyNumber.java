package com.search2026.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    /*
        Happy Number
        leetcode #202
        https://leetcode.com/problems/happy-number/
        Difficulty: Easy
     */
    public class Solution {
        private int cal(int n) {
            int res = 0;
            while (n > 0) {
                res += (n % 10) * (n % 10);
                n = n / 10;
            }
            return res;
        }

        public boolean isHappy(int n) {
            int x = n;
            int y = n;
            while (x > 1) {
                x = cal(x);
                if (x == 1) return true;
                y = cal(cal(y));
                if (y == 1) return true;
                if (x == y) return false;

            }
            return true;
        }
    }

    /*
        Happy Number
        leetcode #202
        https://leetcode.com/problems/happy-number/
        Difficulty: Easy
     */
    public class Solution_2 {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            int squareSum, remain;
            while (set.add(n)) {
                squareSum = 0;
                while (n > 0) {
                    remain = n % 10;
                    squareSum += remain * remain;
                    n /= 10;
                }
                if (squareSum == 1)
                    return true;
                else
                    n = squareSum;
            }
            return false;
        }
    }

}
