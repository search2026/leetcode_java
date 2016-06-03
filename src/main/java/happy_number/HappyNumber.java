package happy_number;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class HappyNumber {
    /*
        Happy Number
        leetcode #202
        https://leetcode.com/problems/happy-number/
        Difficulty: Easy
     */
    public class Solution {
        public int[] getDigits(int n) {
            String s = String.valueOf(n);
            int[] result = new int[s.length()];
            int i = 0;

            while (n > 0) {
                int m = n % 10;
                result[i++] = m;
                n = n / 10;
            }

            return result;
        }

        public int sum(int[] arr) {
            int sum = 0;
            for (int i : arr) {
                sum = sum + i * i;
            }
            return sum;
        }

        public boolean isHappy(int n) {
            HashSet<Integer> set = new HashSet<Integer>();

            while (!set.contains(n)) {
                set.add(n);

                n = sum(getDigits(n));
                if (n == 1)
                    return true;
            }

            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new HappyNumber().new Solution();
            assertEquals(3, 3);
        }
    }
}
