package com.search2026.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    /*
        Longest Substring with At Most K Distinct Characters - Sliding Window
        leetcode #340
        https://github.com/search2026/leetcode_java/blob/master/resources/LongestSubstringWithAtMostKDistinctCharacters.md
        Difficulty: Hard
     */
    public class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (s == null || s.length() == 0) return 0;
            int maxDist = 0, lastSeen = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); ++i) {
                map.put(s.charAt(i), i);
                while (map.size() > k) {
                    int currLeft = map.get(s.charAt(lastSeen));
                    if (currLeft == lastSeen) map.remove(s.charAt(lastSeen));
                    ++lastSeen;
                }
                maxDist = Math.max(maxDist, i - lastSeen + 1);
            }
            return maxDist;
        }
    }

    /*
        Longest Substring with At Most K Distinct Characters - template
        leetcode #340
        https://github.com/search2026/leetcode_java/blob/master/resources/LongestSubstringWithAtMostKDistinctCharacters.md
        Difficulty: Hard
   */
    public class Solution_2 {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (s == null || s.length() == 0) return 0;
            int[] map = new int[Character.MAX_VALUE];
            int counter = 0, p1 = 0, p2 = 0, maxDist = 0;
            while (p2 < s.length()) {
                if (map[s.charAt(p2++)]++ == 0) counter++;
                while (counter > k) if (map[s.charAt(p1++)]-- == 1) counter--;
                maxDist = Math.max(maxDist, p2 - p1);
            }
            return maxDist;
        }
    }

}
