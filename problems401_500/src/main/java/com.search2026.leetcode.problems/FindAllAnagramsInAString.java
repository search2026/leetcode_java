package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    /*
        Find All Anagrams in a String - Substring template
        Leetcode #438
        https://leetcode.com/problems/find-all-anagrams-in-a-string/
        Difficulty: Easy
     */
    public class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;
            int[] map = new int[256];
            for (int i = 0; i < p.length(); i++) map[p.charAt(i)]++;

            int diff = p.length();
            for (int left = 0, right = 0; right < s.length(); right++) {
                if (map[s.charAt(right)]-- > 0) diff--;
                while (diff == 0) {
                    if (right - left + 1 == p.length()) {
                        res.add(left);
                    }
                    if (++map[s.charAt(left++)] > 0) diff++;
                }
            }
            return res;
        }
    }

}
