package longest_consecutive_sequence;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> hs = new HashSet<Integer>();
            for (int n : nums) {
                hs.add(n);
            }
            int ans = 0;
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
                ans = Math.max(ans, j - i - 1);
            }
            return ans;
        }
    }

    public static class UnitTest {

    }
}
