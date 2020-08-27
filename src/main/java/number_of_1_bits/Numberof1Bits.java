package number_of_1_bits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Numberof1Bits {
    /*
        Number of 1 Bits
        Leetcode #191
        https://leetcode.com/problems/number-of-1-bits/
        Difficulty: Easy
     */
    public class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count++;
                n &= (n - 1);
            }
            return count;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new Numberof1Bits().new Solution();
            assertEquals(3, 3);
        }
    }
}

