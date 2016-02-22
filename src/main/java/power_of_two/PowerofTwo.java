package power_of_two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowerofTwo {
    /*
        Power of Two
        https://leetcode.com/problems/power-of-two/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }

            return (n & (n - 1)) == 0;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PowerofTwo().new Solution();
            assertEquals(7, 7);
        }
    }
}
