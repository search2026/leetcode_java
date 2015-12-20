package reverse_bits;

public class ReverseBits {

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

}

