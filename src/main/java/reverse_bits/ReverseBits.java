package reverse_bits;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseBits {
    /*
        Reverse Bits
        https://leetcode.com/problems/reverse-bits/
        leetcode 190
        Difficulty: Easy
     */
    public class Solution {
        public int reverseBits(int n) {
            int reversed = 0;
            int i;
            for (i = 32; i > 0 && n != 0; i--) {
                reversed = (reversed << 1) + (n & 1);
                n >>= 1;
            }
            reversed <<= i;
            return reversed;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ReverseBits().new Solution();
            assertEquals(7, 7);
        }
    }
}

