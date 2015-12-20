package power_of_two;

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

    }
}
