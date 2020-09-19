package com.search2026.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    /*
        Single Number - Set
        Leetcode #136
        https://leetcode.com/problems/single-number/
        Difficulty: Medium
     */
    public class Solution {
        public int singleNumber(int[] nums) {
            if (nums == null || nums.length == 0)
                throw new IllegalArgumentException("Input is null or empty.");
            Set<Integer> set = new HashSet<>();
            for (int e : nums) {
                if (set.contains(e)) set.remove(e);
                else set.add(e);
            }
            if (set.size() != 1)
                throw new IllegalArgumentException("Input array is not as desgined.");
            return set.iterator().next();
        }
    }

    /*
        Single Number - XOR
        Leetcode #136
        https://leetcode.com/problems/single-number/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int singleNumber(int[] nums) {
            if (nums == null || nums.length == 0)
                throw new IllegalArgumentException("Input is null or empty");
            int single = 0;
            for (int e : nums) {
                single ^= e;
            }
            return single;
        }
    }

    /*
        Single Number II
        Leetcode #137
        https://leetcode.com/problems/single-number-ii/
        Difficulty: Medium
     */
    public class Solution_3 {
        public int singleNumber(int[] nums) {
            int[] bitCount = new int[32];
            for (int n : nums) {
                for (int i = 0; i < 32; i++) {
                    if ((n & (1 << i)) != 0) {
                        bitCount[i]++;
                    }
                }
            }

            int single = 0;
            for (int i = 0; i < 32; i++) {
                if (bitCount[i] % 3 == 1) {
                    single |= (1 << i);
                }
            }
            return single;
        }
    }

    /*
      Single Number II
      Leetcode #137
      https://leetcode.com/problems/single-number-ii/
      Difficulty: Medium
   */
    public class Solution_4 {
        public int singleNumber(int[] nums) {
            int single = 0;
            for (int i = 0; i < 32; i++) {
                int bitCount = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (((nums[j] >> i) & 1) > 0) {
                        bitCount++;
                    }
                }
                single |= (bitCount % 3) << i;
            }

            return single;
        }
    }

    /*
        Single Number II
        Leetcode #137
        https://leetcode.com/problems/single-number-ii/
        Difficulty: Medium
     */
    public class Solution_5 {
        int singleNumber(int nums[]) {
            int ones = 0, twos = 0, threes = 0;
            for (int e : nums) {
                twos |= ones & e;
                ones ^= e;
                threes = ones & twos;
                ones &= ~threes;
                twos &= ~threes;
            }
            return ones;
        }
    }

    /*
      Single Number II - General Template
      Leetcode #137
      https://leetcode.com/problems/single-number-ii/
      https://leetcode.com/discuss/857/constant-space-solution?show=2542#a2542
      Difficulty: Medium
   */
    public class Solution_6 {
        public int singleNumber(int[] nums) {
            if (nums == null) return 0;
            int x0 = ~0, x1 = 0, x2 = 0, t;
            for (int i = 0; i < nums.length; i++) {
                t = x2;
                x2 = (x1 & nums[i]) | (x2 & ~nums[i]);
                x1 = (x0 & nums[i]) | (x1 & ~nums[i]);
                x0 = (t & nums[i]) | (x0 & ~nums[i]);
            }
            return x1;
        }
    }

    /*
        Single Number III
        Leetcode #260
        https://leetcode.com/discuss/questions/oj/single-number-iii?sort=votes
        http://www.cnblogs.com/grandyang/p/4741122.html
        Difficulty: Medium
     */
    public class Solution_7 {
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

            int[] singles = new int[]{xor1, xor2};

            return singles;
        }
    }

    /*
        Single Number III
        Leetcode #260
        https://leetcode.com/discuss/questions/oj/single-number-iii?sort=votes
        http://www.cnblogs.com/grandyang/p/4741122.html
        Difficulty: Medium
     */
    public class Solution_8 {
        public int[] singleNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            int diff = 0;
            for (int num : nums) {
                diff ^= num;
            }
            diff &= -diff;

            int[] singles = {0, 0};
            for (int num : nums) {
                if ((num & diff) == 0) {
                    singles[0] ^= num;
                } else {
                    singles[1] ^= num;
                }
            }

            return singles;
        }
    }

    /*
      Single Number IV
      every element appears k times except for one. find that single one which appears l times.
      https://leetcode.com/discuss/857/constant-space-solution?show=2542#a2542
      Difficulty: Medium
    */
    public class Solution_9 {
        public int singleNumber(int[] nums, int k, int l) {
            if (nums == null) return 0;
            int t;
            int[] x = new int[k];
            x[0] = ~0;
            for (int num : nums) {
                t = x[k - 1];
                for (int j = k - 1; j > 0; j--) {
                    x[j] = (x[j - 1] & num) | (x[j] & ~num);
                }
                x[0] = (t & num) | (x[0] & ~num);
            }
            return x[l];
        }
    }

}
