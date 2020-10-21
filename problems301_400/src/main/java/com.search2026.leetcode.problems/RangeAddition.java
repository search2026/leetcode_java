package com.search2026.leetcode.problems;

public class RangeAddition {

    /*
        Range Addition - Brute Force
        Leetcode #370
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/RangeAddition.md
        Difficulty: Medium
     */
    public class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            if (length < 0 || updates == null || updates.length == 0) return null;
            if (updates[0] == null || updates[0].length != 3) return null;

            int[] nums = new int[length];
            for (int i = 0; i < updates.length; i++) {
                for (int j = updates[i][0]; j <= updates[i][1]; j++) {
                    nums[j] += updates[i][2];
                }
            }

            return nums;
        }
    }

    /*
        Range Addition - O(N+K) time complexity
        Leetcode #370
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/RangeAddition.md
        Difficulty: Medium
     */
    public class Solution_2 {
        public int[] getModifiedArray(int length, int[][] updates) {
            if (length < 0 || updates == null || updates.length == 0) return null;
            if (updates[0] == null || updates[0].length != 3) return null;

            int[] res = new int[length];
            for (int[] u : updates) {
                res[u[0]] += u[2];
                if (u[1] < length - 1)
                    res[u[1] + 1] -= u[2];
            }

            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += res[i];
                res[i] = sum;
            }

            return res;
        }
    }

}
