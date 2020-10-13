package com.search2026.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfaString {

    /*
        Reverse Vowels of a String
        leetcode #345
        https://leetcode.com/problems/reverse-vowels-of-a-string/
        Difficulty: Easy
     */
    public class Solution {
        private final Set<Character> VOWELS = new HashSet<>() {{
            add('a');
            add('o');
            add('i');
            add('u');
            add('e');
            add('A');
            add('O');
            add('I');
            add('U');
            add('E');
        }};

        public String reverseVowels(String s) {
            if (s == null || s.length() == 0) return "";
            int n = s.length();
            if (n == 1) return s;
            char[] sChars = s.toCharArray();
            int p1 = 0, p2 = n-1;
            while (p1 < p2) {
                while (p1 < p2 && !VOWELS.contains(sChars[p1])) {
                    p1++;
                }
                while (p1 < p2 && !VOWELS.contains(sChars[p2]))  {
                    p2--;
                }
                if (p1 >= p2) break;
                char t = sChars[p1];
                sChars[p1] = sChars[p2];
                sChars[p2] = t;
                p1++;
                p2--;
            }

            return new String(sChars);
        }
    }

}
