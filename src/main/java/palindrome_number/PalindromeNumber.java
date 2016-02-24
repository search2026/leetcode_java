package palindrome_number;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeNumber {
    /*
        Palindrome Number
        https://leetcode.com/problems/palindrome-number/
        leetcode 9
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
        https://leetcode.com/problems/palindrome-number/
        leetcode 9
        Difficulty: Easy
     */
    public class Solution_2 {
        public boolean isPalindrome(int x) {
            if (x == 0) return true;
            if (x < 0 || x % 10 == 0) return false;
            int div = 1;
            while (x / div >= 10) div *= 10;

            while (x != 0) {
                int l = x / div;
                int r = x % 10;
                if (l != r) return false;
                x = (x % div) / 10;
                div /= 100;
            }
            return true;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PalindromeNumber().new Solution();
            assertTrue(sol.isPalindrome(1234321));
            assertTrue(sol.isPalindrome(9));
            assertFalse(sol.isPalindrome(122));
        }

        @Test
        public void test2() {
            Solution sol = new PalindromeNumber().new Solution();
            assertTrue(sol.isPalindrome(1234321));
            assertTrue(sol.isPalindrome(9));
            assertFalse(sol.isPalindrome(122));
        }
    }
}
