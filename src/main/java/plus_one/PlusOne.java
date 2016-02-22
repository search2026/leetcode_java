package plus_one;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PlusOne {
    /*
        Plus One
        https://leetcode.com/problems/plus-one/
        leetcode 66
        Difficulty: Easy
     */
    public class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int sum = digits[i] + carry;
                carry = sum / 10;
                digits[i] = sum % 10;
            }
            if (carry == 1) {
                int[] re = new int[digits.length + 1];
                System.arraycopy(digits, 0, re, 1, digits.length);
                re[0] = 1;
                return re;
            }
            return digits;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PlusOne().new Solution();
            assertArrayEquals(sol.plusOne(new int[]{9, 9, 8}), new int[]{9, 9, 9});
            assertArrayEquals(sol.plusOne(new int[]{9, 9, 9}), new int[]{1, 0, 0, 0});
        }
    }
}
