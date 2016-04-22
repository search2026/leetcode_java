package power_of_two;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PowerofTwo {
    /*
        Power of Two
        https://leetcode.com/problems/power-of-two/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isPowerOfTwo(int num) {
            return num > 0 && (num & (num - 1)) == 0;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PowerofTwo().new Solution();
            assertFalse(sol.isPowerOfTwo(7));
            assertTrue(sol.isPowerOfTwo(8));
        }
    }
}
