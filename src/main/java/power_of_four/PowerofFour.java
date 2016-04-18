package power_of_four;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PowerofFour {
    /*
        Power of Four
        https://leetcode.com/problems/power-of-four/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isPowerOfFour(int num) {
            return num > 0 && (num & (num - 1)) ==0  && (num & 0x55555555) !=0;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PowerofFour().new Solution();
            assertTrue(sol.isPowerOfFour(1));
            assertFalse(sol.isPowerOfFour(6));
            assertFalse(sol.isPowerOfFour(8));
            assertFalse(sol.isPowerOfFour(14));
            assertFalse(sol.isPowerOfFour(15));
            assertTrue(sol.isPowerOfFour(16));
        }        
    }
}

