package increasing_triplet_subsequence;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IncreasingTripletSubsequence {
    /*
        Increasing Triplet Subsequence - O(N) Space
        https://leetcode.com/problems/increasing-triplet-subsequence/
        Difficulty: Medium
     */
    public class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums == null || nums.length <= 0) return false;
            int n = nums.length;
            if (n < 3) return false;

            int[] rmax = new int[n];
            int max = nums[0];
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > max)
                    max = nums[i];
                rmax[i] = max;
            }

            int lmin = nums[0];
            for (int i = 1; i < n - 1; i++) {
                if (nums[i] > lmin && nums[i] < rmax[i])
                    return true;
                if (nums[i] < lmin)
                    lmin = nums[i];
            }
            return false;
        }
    }

    /*
        Increasing Triplet Subsequence - O(1) Space
        https://leetcode.com/problems/increasing-triplet-subsequence/
        Difficulty: Medium
     */
    public class Solution_2 {
        public boolean increasingTriplet(int[] nums) {
            if (nums == null || nums.length <= 0) return false;
            int n = nums.length;
            if (n < 3) return false;

            int lmin = nums[0];
            int middle = nums[0];
            boolean sawOnce = false;
            for (int i = 1; i < n; i++) {
                if (nums[i] <= lmin) {
                    lmin = nums[i];
                } else if (!sawOnce || nums[i] <= middle) {
                    middle = nums[i];
                    sawOnce = true;
                } else {
                    return true;
                }
            }

            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new IncreasingTripletSubsequence().new Solution();
            assertTrue(sol.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
            assertFalse(sol.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
            assertTrue(sol.increasingTriplet(new int[]{1, 7, 3, 5}));
            assertFalse(sol.increasingTriplet(new int[]{5, 6, 2, 3}));
            assertFalse(sol.increasingTriplet(new int[]{1, 7, 3, 2}));
            assertTrue(sol.increasingTriplet(new int[]{5, 6, 5, 7}));
            assertTrue(sol.increasingTriplet(new int[]{1, 0, 0, 0, 0, 10, 0, 0, 1000}));
            assertFalse(sol.increasingTriplet(new int[]{1, 2, 1, 2, 1, 1, 2}));
            assertTrue(sol.increasingTriplet(new int[]{1, 2, -10, -8, -7}));
        }

        @Test
        public void test2() {
            Solution sol = new IncreasingTripletSubsequence().new Solution();
            assertTrue(sol.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
            assertFalse(sol.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
            assertTrue(sol.increasingTriplet(new int[]{1, 7, 3, 5}));
            assertFalse(sol.increasingTriplet(new int[]{5, 6, 2, 3}));
            assertFalse(sol.increasingTriplet(new int[]{1, 7, 3, 2}));
            assertTrue(sol.increasingTriplet(new int[]{5, 6, 5, 7}));
            assertTrue(sol.increasingTriplet(new int[]{1, 0, 0, 0, 0, 10, 0, 0, 1000}));
            assertFalse(sol.increasingTriplet(new int[]{1, 2, 1, 2, 1, 1, 2}));
            assertTrue(sol.increasingTriplet(new int[]{1, 2, -10, -8, -7}));
        }
    }
}

