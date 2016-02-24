package longest_consecutive_sequence;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class LongestConsecutiveSequence {
    /*
        Longest Consecutive Sequence
        https://leetcode.com/problems/longest-consecutive-sequence/
        leetcode 128
        Difficulty: Hard
     */
    public class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> hs = new HashSet<Integer>();
            for (int n : nums) {
                hs.add(n);
            }
            int rslt = 0;
            for (int n : nums) {
                int i = n - 1;
                while (hs.contains(i)) {
                    hs.remove(i);
                    i--;
                }
                int j = n + 1;
                while (hs.contains(j)) {
                    hs.remove(j);
                    j++;
                }
                rslt = Math.max(rslt, j - i - 1);
            }
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LongestConsecutiveSequence().new Solution();
            assertEquals(3, 3);
        }
    }
}
