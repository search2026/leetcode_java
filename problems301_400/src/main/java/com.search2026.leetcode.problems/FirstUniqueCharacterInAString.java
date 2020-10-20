package com.search2026.leetcode.problems;

public class FirstUniqueCharacterInAString {

    /*
        First Unique Character in a String
        Leetcode #387
        https://leetcode.com/problems/first-unique-character-in-a-string/
        Difficulty: Easy
     */
    public class Solution {
        public int firstUniqChar(String s) {
            int freq[] = new int[26];
            for (int i = 0; i < s.length(); i++)
                freq[s.charAt(i) - 'a']++;
            for (int i = 0; i < s.length(); i++)
                if (freq[s.charAt(i) - 'a'] == 1)
                    return i;
            return -1;
        }
    }

}
