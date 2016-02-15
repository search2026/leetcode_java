package single_number;

public class SingleNumber {
    /*
        Single Number
        https://leetcode.com/problems/single-number/
        Difficulty: Medium
     */
    public class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i : nums) {
                ans ^= i;
            }
            return ans;
        }
    }

    /*
        Single Number II
        https://leetcode.com/problems/single-number-ii/
        Difficulty: Medium
     */
    public class SolutionII {
        public int singleNumber(int[] nums) {
            int[] bits = new int[32];
            for (int a : nums) {
                for (int i = 0; i < 32; i++) {
                    if ((a & (1 << i)) != 0) {
                        bits[i]++;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if (bits[i] % 3 == 1) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }
    }

    /*
        Single Number III
        https://leetcode.com/problems/single-number-iii/
        Difficulty: Medium
     */
    public class SolutionIII {
        public int[] singleNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            int xor = 0;

            // Step 1: calculate the xor for all numbers
            // So the result is the xor of the two single numbers
            for (int num : nums) {
                xor ^= num;
            }

            // Step 2: findRoot the first bit 1 from right
            int mask = 1;
            while ((mask & xor) == 0) {
                mask = mask << 1;
            }

            int xor1 = 0;
            int xor2 = 0;

            for (int num : nums) {
                if ((num & mask) == 0) {
                    xor1 ^= num;
                } else {
                    xor2 ^= num;
                }
            }

            int[] result = new int[]{xor1, xor2};

            return result;
        }
    }

    public static class UnitTest {

    }
}
