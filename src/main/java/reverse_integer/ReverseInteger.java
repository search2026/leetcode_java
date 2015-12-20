package reverse_integer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class ReverseInteger {

    public class Solution {
        public int reverse(int x) {
            if (x == MIN_VALUE) {
                return 0;
            }
            boolean negative = x < 0;
            if (negative) {
                x = -x;
            }
            int y = 0;
            while (x != 0) {
                int mod = x % 10;
                if (y > (MAX_VALUE - mod) / 10) {
                    // y * 10 + mod > Integer.MAX_VALUE
                    return 0;
                }
                y = y * 10 + mod;
                x /= 10;
            }
            return negative ? -y : y;
        }
    }

    public static class UnitTest {

    }
}
