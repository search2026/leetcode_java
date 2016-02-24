package longest_substring_with_at_most_two_distinct_characters;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    /*
        Longest Substring with At Most Two Distinct Characters
        http://www.cnblogs.com/EdwardLiu/p/4241421.html
        leetcode 159
        Difficulty: Hard
     */
    public class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int i = 0, j = -1, maxLen = 0;
            for (int k = 1; k < s.length(); k++) {
                if (s.charAt(k) == s.charAt(k - 1)) continue;
                if (j >= 0 && s.charAt(j) != s.charAt(k)) {
                    maxLen = Math.max(k - i, maxLen);
                    i = j + 1;
                }
                j = k - 1;
            }
            return Math.max(s.length() - i, maxLen);
        }
    }

    /*
        Longest Substring with At Most Two Distinct Characters
        https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems
        leetcode 159
        Difficulty: Hard
     */
    public class Solution_2 {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int[] map = new int[256];
            int counter = 0, p1 = 0, p2 = 0, dis = 0;
            while (p2 < s.length()) {
                if (map[s.charAt(p2++)]++ == 0) counter++;
                while (counter > 2) if (map[s.charAt(p1++)]-- == 1) counter--;
                dis = Math.max(dis, p2 - p1);
            }
            return dis;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LongestSubstringwithAtMostTwoDistinctCharacters().new Solution();
            assertEquals(3, sol.lengthOfLongestSubstringTwoDistinct("eceba"));
        }

        @Test
        public void test2() {
            Solution_2 sol = new LongestSubstringwithAtMostTwoDistinctCharacters().new Solution_2();
            assertEquals(3, sol.lengthOfLongestSubstringTwoDistinct("eceba"));
        }
    }
}
