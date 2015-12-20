package palindrome_number;

public class PalindromeNumber {

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

    }
}
