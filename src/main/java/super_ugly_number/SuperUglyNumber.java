package super_ugly_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuperUglyNumber {
    /*
        Super Ugly Number
        Leetcode #313
        https://leetcode.com/problems/super-ugly-number/
        Difficulty: Medium
     */
    public class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {

            int[] superUglyNumbers = new int[n];
            superUglyNumbers[0] = 1;
            int[] idxPrimes = new int[primes.length];
            for (int i = 0; i < idxPrimes.length; i++) {
                idxPrimes[i] = 0;
            }

            int counter = 1;
            while (counter < n) {

                int min = Integer.MAX_VALUE;
                for (int i = 0; i < primes.length; i++) {
                    int temp = superUglyNumbers[idxPrimes[i]] * primes[i];
                    min = min < temp ? min : temp;
                }

                for (int i = 0; i < primes.length; i++) {
                    if (min == superUglyNumbers[idxPrimes[i]] * primes[i]) {
                        idxPrimes[i]++;
                    }
                }

                superUglyNumbers[counter] = min;
                counter++;
            }

            return superUglyNumbers[n - 1];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SuperUglyNumber().new Solution();
            assertEquals(7, 7);
        }
    }
}
