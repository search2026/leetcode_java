package bitwise_and_of_numbers_range;

public class BitwiseANDofNumbersRange {

    public class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int r = 0;
            for (int i = 0; i < 32 && n != 0; i++) {
                if ((m & 1) != 0 && n == m) {
                    r |= (1 << i);
                }
                n >>>= 1;
                m >>>= 1;
            }
            return r;
        }
    }
}

