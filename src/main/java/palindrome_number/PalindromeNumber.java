package palindrome_number;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeNumber {
    /*
        Palindrome Number
        https://leetcode.com/problems/palindrome-number/
        leetcode 9
        Difficulty: Easy
     */
    public class Solution {
        public boolean isPalindrome(int x) {
            if (x == 0) {
                return true;
            }
            if (x < 0 || x % 10 == 0) {
                return false;
            }
            int y = 0;
            do {
                if (y == x / 10 || y == x) {
                    return true;
                }
                y = y * 10 + x % 10;
                x = x / 10;
            } while (x > y);
            return y == x;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PalindromeNumber().new Solution();
            assertEquals(7, 7);
        }
    }
}
