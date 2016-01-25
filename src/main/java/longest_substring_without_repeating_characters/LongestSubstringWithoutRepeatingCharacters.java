package longest_substring_without_repeating_characters;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
        Longest Substring Without Repeating Characters - Dynamic Programming
        https://leetcode.com/problems/longest-substring-without-repeating-characters/
        Difficulty: Medium
     */
    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            int[] map = new int[Character.MAX_VALUE + 1];
            Arrays.fill(map, -1);
            int last_seen = 0;
            int global_max = 0;
            for (int i = 0; i < s.length(); i++) {
                last_seen = Math.max(last_seen, map[s.charAt(i)] + 1);
                global_max = Math.max(global_max, i - last_seen + 1);
                map[s.charAt(i)] = i;
            }
            return global_max;
        }
    }

    /*
        Longest Substring Without Repeating Characters - Sliding Window
        https://leetcode.com/problems/longest-substring-without-repeating-characters/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            HashSet<Character> set = new HashSet<Character>();
            int global_max = 0;
            int p0 = 0, p1 = 0;
            while (p1 < s.length()) {
                if (set.contains(s.charAt(p1))) {
                    global_max = Math.max(global_max, p1-p0);
                    while (s.charAt(p0) != s.charAt(p1)) {
                        set.remove(s.charAt(p0));
                        p0++;
                    }
                    p0++;
                } else {
                    set.add(s.charAt(p1));
                }
                p1++;
            }
            global_max = Math.max(global_max, p1 - p0);
            return global_max;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LongestSubstringWithoutRepeatingCharacters().new Solution();
            assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"));
            assertEquals(1, sol.lengthOfLongestSubstring("bbbb"));
        }

        @Test
        public void test2() {
            Solution_2 sol = new LongestSubstringWithoutRepeatingCharacters().new Solution_2();
            assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"));
            assertEquals(1, sol.lengthOfLongestSubstring("bbbb"));
        }
    }
}
