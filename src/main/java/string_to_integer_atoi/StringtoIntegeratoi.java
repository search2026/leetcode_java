package string_to_integer_atoi;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class StringtoIntegeratoi {

    public class Solution {
        public int myAtoi(String str) {
            int index = 0;
            while (index < str.length()
                    && Character.isWhitespace(str.charAt(index))) {
                index++;
            }
            if (index == str.length()) {
                return 0;
            }
            boolean negative = false;
            if (str.charAt(index) == '+') {
                index++;
            } else if (str.charAt(index) == '-') {
                index++;
                negative = true;
            }
            long ans = 0;
            while (index < str.length() && Character.isDigit(str.charAt(index))) {
                ans = ans * 10 + str.charAt(index) - '0';
                if (ans > MAX_VALUE + 1L) {
                    break;
                }
                index++;
            }
            if (negative) {
                ans = -ans;
                if (ans < MIN_VALUE) {
                    return MIN_VALUE;
                }
            } else {
                if (ans > MAX_VALUE) {
                    return MAX_VALUE;
                }
            }
            return (int) ans;
        }
    }

    public static class UnitTest {

    }
}
