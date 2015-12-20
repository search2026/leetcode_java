package add_digits;

public class AddDigits {
    /*
        Add Digits
        https://leetcode.com/problems/add-digits/
        Difficulty: Easy
     */
    public class Solution {
        public int addDigits(int num) {
            if (num < 10) {
                return num;
            }

            int result = num;

            while (result >= 10) {
                // Get each digit of the number
                int digit = 0;
                while (result > 0) {
                    digit += result % 10;
                    result /= 10;
                }

                result = digit;
            }

            return result;
        }
    }

    public static class UnitTest {

    }
}
