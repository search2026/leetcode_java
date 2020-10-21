package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutation {

    /*
        Palindrome Permutation
        Leetcode #266
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/PalindromePermutation.md
        Difficulty: Easy
    */
    public class Solution {
        public boolean canPermutePalindrome(String s) {
            if (s == null || s.length() == 0) return true;
            int n = s.length();
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    int count = map.get(c) + 1;
                    map.put(c, count);
                } else {
                    map.put(c, 1);
                }
            }

            int countOdd = 0;
            for (Character c : map.keySet()) {
                if (map.get(c) % 2 != 0) {
                    countOdd++;
                    if (countOdd >= 2) {
                        return false;
                    }
                }
            }

            boolean isLenEven = ((n % 2) == 0);
            if (isLenEven) {
                return (countOdd == 0);
            }

            return (countOdd == 1);
        }
    }

    /*
        Palindrome Permutation II
        Leetcode #267
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/PalindromePermutationII.md
        Difficulty: Medium
    */
    public class Solution_2 {
        public List<String> generatePalindromes(String s) {
            List<String> res = new ArrayList<>();
            if (s.length() == 0)
                return res;

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i)))
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                else
                    map.put(s.charAt(i), 1);
            }

            String candidate = "";
            String single = "";
            boolean moreThan2Odds = false;

            for (Character c : map.keySet()) {
                int num = map.get(c) / 2;
                for (int i = 0; i < num; i++)
                    candidate += c;
                if (map.get(c) % 2 != 0) {
                    if (moreThan2Odds)
                        return res;
                    else {
                        moreThan2Odds = true;
                        single += c;
                    }
                }
            }

            if (candidate.length() == 0 && single.length() != 0) {
                res.add(single);
                return res;
            }

            permute("", candidate, single, candidate.length(), res);
            return res;
        }

        private void permute(String left, String candidate, String single, int l, List<String> res) {
            if (left.length() == l) {
                String right = new StringBuffer(left).reverse().toString();
                res.add(left + single + right);
            }
            for (int i = 0; i < candidate.length(); i++) {
                if (i > 0 && candidate.charAt(i) == candidate.charAt(i - 1))
                    continue;
                permute(left + candidate.charAt(i), candidate.substring(0, i) + candidate.substring(i + 1), single, l, res);
            }
        }
    }

}
