package com.search2026.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    /*
        Roman to Integer
        Leetcode #13
        https://leetcode.com/problems/roman-to-integer/
        Difficulty: Easy
     */
    public class Solution {
        private final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('M', 1000);
            put('D', 500);
            put('C', 100);
            put('L', 50);
            put('X', 10);
            put('V', 5);
            put('I', 1);
        }};


        public int romanToInt(String s) {
            if (s == null || s.length() == 0)
                throw new IllegalArgumentException("empty input");

            int prev = 0, num = 0;
            for (char c : s.toCharArray()) {
                int curr = map.get(c);
                num += (curr > prev) ? (curr - 2 * prev) : curr;
                prev = curr;
            }

            return num;
        }
    }

    /*
        Roman to Integer
        Leetcode #13
        https://leetcode.com/problems/roman-to-integer/
        Difficulty: Easy
     */
    public class Solution_2 {
        private final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        public int romanToInt(String s) {
            if (s == null || s.length() == 0)
                throw new IllegalArgumentException("empty input");

            int num = 0, prev = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                int curr = map.get(s.charAt(i));
                num += (curr >= prev) ? curr : -curr;
                prev = curr;
            }

            return num;
        }
    }

}
