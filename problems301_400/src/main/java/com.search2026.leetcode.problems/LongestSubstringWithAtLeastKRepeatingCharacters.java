package com.search2026.leetcode.problems;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /*
        Longest Substring with At Least K Repeating Characters - O(N) Two-Pointer
        Leetcode #395
        https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
        Difficulty: Medium
     */
    public class Solution {
        public int longestSubstring(String s, int k) {
            char[] str = s.toCharArray();
            int[] counts = new int[26];
            int h, i, j, idx, max = 0, unique, noLessThanK;

            for (h = 1; h <= 26; h++) {
                Arrays.fill(counts, 0);
                i = 0;
                j = 0;
                unique = 0;
                noLessThanK = 0;
                while (j < str.length) {
                    if (unique <= h) {
                        idx = str[j] - 'a';
                        if (counts[idx] == 0)
                            unique++;
                        counts[idx]++;
                        if (counts[idx] == k)
                            noLessThanK++;
                        j++;
                    }
                    else {
                        idx = str[i] - 'a';
                        if (counts[idx] == k)
                            noLessThanK--;
                        counts[idx]--;
                        if (counts[idx] == 0)
                            unique--;
                        i++;
                    }
                    if (unique == h && unique == noLessThanK)
                        max = Math.max(j - i, max);
                }
            }

            return max;
        }
    }

    /*
        Longest Substring with At Least K Repeating Characters
        Leetcode #395
        https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int longestSubstring(String s, int k) {
            if (s == null || s.length() == 0) return 0;
            char[] chars = new char[26];
            // record the frequency of each character
            for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
            boolean flag = true;
            for (int i = 0; i < chars.length; i += 1) {
                if (chars[i] < k && chars[i] > 0) flag = false;
            }
            // return the length of string if this string is a valid string
            if (flag) return s.length();
            int res = 0;
            int start = 0, curr = 0;
            // otherwise we use all the infrequent elements as splits
            while (curr < s.length()) {
                if (chars[s.charAt(curr) - 'a'] < k) {
                    res = Math.max(res, longestSubstring(s.substring(start, curr), k));
                    start = curr + 1;
                }
                curr++;
            }
            res = Math.max(res, longestSubstring(s.substring(start), k));
            return res;
        }
    }

}
