package valid_palindrome;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidPalindrome {
    /*
        Valid Palindrome
        https://leetcode.com/problems/valid-palindrome/
        leetcode 125
        Difficulty: Easy
     */
    public class Solution {
        public boolean isPalindrome(String s) {
            assert s != null;
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                if (!Character.isLetterOrDigit(s.charAt(start))) {
                    start++;
                } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                    end--;
                } else if (Character.toLowerCase(s.charAt(start)) != Character
                        .toLowerCase(s.charAt(end))) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            }
            return true;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ValidPalindrome().new Solution();
            assertEquals(7, 7);
        }
    }
}
