package com.search2026.leetcode.problems;

public class PalindromeNumber {
    /*
    Palindrome Number
    Leetcode #9
    https://leetcode.com/problems/palindrome-number/
    Difficulty: Easy
 */
    public class Solution {
        public boolean isPalindrome(int x) {
            if (x == 0) return true;
            if (x < 0 || x % 10 == 0) return false;

            int y = 0;
            do {
                if (y == x / 10 || y == x) return true;
                y = y * 10 + x % 10;
                x = x / 10;
            } while (x > y);

            return y == x;
        }
    }

    /*
        Palindrome Number
        Leetcode #9
        https://leetcode.com/problems/palindrome-number/
        Difficulty: Easy
     */
    public class Solution_2 {
        public boolean isPalindrome(int x) {
            if (x == 0) return true;
            if (x < 0 || x % 10 == 0) return false;
            int div = 1;
            while (x / div >= 10) {
                div *= 10;
            }

            while (x != 0) {
                int left = x / div;
                int right = x % 10;
                if (left != right) return false;
                x = (x % div) / 10;
                div /= 100;
            }

            return true;
        }
    }

}
