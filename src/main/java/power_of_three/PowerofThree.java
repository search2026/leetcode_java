package power_of_three;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PowerofThree {
    /*
        Power of Three - Divide by Three
        Leetcode #326
        https://leetcode.com/problems/power-of-three/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isPowerOfThree(int n) {
            if (n <= 0) return false;
            while (n > 1) {
                if (n % 3 != 0) return false;
                n /= 3;
            }
            return true;
        }
    }

    /*
        Power of Three - Recursively
        Leetcode #326
        https://leetcode.com/problems/power-of-three/
        Difficulty: Easy
     */
    public class Solution_2 {
        public boolean isPowerOfThree(int n) {
            if (n <= 0) return false;
            if (n == 1) return true;
            return n % 3 == 0 && isPowerOfThree(n / 3);
        }
    }

    /*
        Power of Three - No Loop
        https://leetcode.com/problems/power-of-three/
        Difficulty: Easy
     */
    public class Solution_3 {
        public boolean isPowerOfThree(int n) {
            return n > 0 && n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PowerofThree().new Solution();
            assertTrue(sol.isPowerOfThree(81));
            assertFalse(sol.isPowerOfThree(82));
        }
    }
}

