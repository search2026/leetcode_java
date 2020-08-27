package longest_consecutive_sequence;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class LongestConsecutiveSequence {
    /*
        Longest Consecutive Sequence
        https://leetcode.com/problems/longest-consecutive-sequence/
        leetcode 128
        Difficulty: Hard
     */
    public class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n);
            }
            int res = 0;
            for (int n : nums) {
                int i = n - 1;
                while (set.contains(i)) {
                    set.remove(i);
                    i--;
                }
                int j = n + 1;
                while (set.contains(j)) {
                    set.remove(j);
                    j++;
                }
                res = Math.max(res, j - i - 1);
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LongestConsecutiveSequence().new Solution();
            assertEquals(4, sol.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
            assertEquals(2, sol.longestConsecutive(new int[]{1, 2, 5, 6}));
            assertEquals(3, sol.longestConsecutive(new int[]{3, 5, 6, 12, 7}));
            assertEquals(3, sol.longestConsecutive(new int[]{1, 6, 2, 7, 3}));
        }
    }
}
