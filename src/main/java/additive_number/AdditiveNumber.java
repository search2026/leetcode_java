package additive_number;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdditiveNumber {
    /*
        Additive Number
        https://leetcode.com/problems/additive-number/
        Difficulty: Medium
     */
    public class Solution {
        private int MAX_LEN = String.valueOf(Integer.MAX_VALUE).length();

        public boolean isAdditiveNumber(String num) {
            for (int i = 0; i < MAX_LEN && i < num.length(); i++) {
                for (int j = i + 1; j - (i + 1) < MAX_LEN && j < num.length(); j++) {
                    // first number: [0,i], second number: [i+1,j]

                    String firstStr = num.substring(0, i + 1);
                    if (firstStr.startsWith("0") && firstStr.length() > 1)
                        continue;
                    long first = Long.parseLong(firstStr);

                    String secondStr = num.substring(i + 1, j + 1);
                    if (secondStr.startsWith("0") && secondStr.length() > 1)
                        continue;
                    long second = Long.parseLong(secondStr);

                    if (first > Integer.MAX_VALUE || second > Integer.MAX_VALUE)
                        continue;

                    if (isAdditiveNumber(first, second, num.substring(j + 1)))
                        return true;
                }
            }

            return false;
        }

        private boolean isAdditiveNumber(long first, long second, String num) {
            long sum = first + second;

            String sumStr = String.valueOf(sum);
            if (!num.startsWith(sumStr))
                return false;
            if (num.equals(sumStr))
                return true;

            String rest = num.substring(sumStr.length());
            return isAdditiveNumber(second, sum, rest);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new AdditiveNumber().new Solution();
        }
    }
}
