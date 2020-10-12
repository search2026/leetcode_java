package com.search2026.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    /*
        Longest Substring with At Most Two Distinct Characters
        leetcode #159
        https://github.com/search2026/leetcode_java/blob/master/resources/LongestSubstringWithAtMostTwoDistinctCharacters.md
        Difficulty: Hard
     */
    public class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            if (s == null || s.length() == 0) return 0;
            int maxDist = 0, lastSeen = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); ++i) {
                map.put(s.charAt(i), i);
                while (map.size() > 2) {
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
        Longest Substring with At Most Two Distinct Characters - Sliding Windows
        leetcode #159
        https://github.com/search2026/leetcode_java/blob/master/resources/LongestSubstringWithAtMostTwoDistinctCharacters.md
        Difficulty: Hard
     */
    public class Solution_2 {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            if (s == null || s.length() == 0) return 0;
            int p1 = 0, p2 = -1, maxDist = 0;
            for (int k = 1; k < s.length(); k++) {
                if (s.charAt(k) == s.charAt(k - 1)) continue;
                if (p2 >= 0 && s.charAt(p2) != s.charAt(k)) {
                    maxDist = Math.max(k - p1, maxDist);
                    p1 = p2 + 1;
                }
                p2 = k - 1;
            }
            return Math.max(s.length() - p1, maxDist);
        }
    }

    /*
        Longest Substring with At Most Two Distinct Characters - Template
        leetcode #159
        https://github.com/search2026/leetcode_java/blob/master/resources/LongestSubstringWithAtMostTwoDistinctCharacters.md
        Difficulty: Hard
     */
    public class Solution_3 {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            if (s == null || s.length() == 0) return 0;
            int[] map = new int[Character.MAX_VALUE];
            int counter = 0, p1 = 0, p2 = 0, maxDist = 0;
            while (p2 < s.length()) {
                if (map[s.charAt(p2++)]++ == 0) counter++;
                while (counter > 2) if (map[s.charAt(p1++)]-- == 1) counter--;
                maxDist = Math.max(maxDist, p2 - p1);
            }
            return maxDist;
        }
    }

}
