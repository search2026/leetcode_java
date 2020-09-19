package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {

    /*
        Word Break
        Leetcode #139
        https://leetcode.com/problems/word-break/
        Difficulty: Medium
     */
    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0) return true;
            if (wordDict == null || wordDict.size() == 0) return false;

            int sLen = s.length();
            boolean[] dp = new boolean[sLen + 1];
            dp[0] = true;

            for (int i = 1; i <= sLen; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[sLen];
        }
    }

    /*
        Word Break II - Backtracking + Hashmap
        Leetcode #140
        https://leetcode.com/problems/word-break-ii/
        Difficulty: Hard
     */
    public class Solution_2 {
        private List<String> search(String s, List<String> dict, HashMap<Integer, List<String>> map, int start) {
            if (map.containsKey(start)) return map.get(start);

            List<String> res = new ArrayList<>();
            if (start == s.length()) {
                res.add("");
                return res;
            }

            String curr = s.substring(start);
            for (String word : dict) {
                if (curr.startsWith(word)) {
                    List<String> sublist = search(s, dict, map, start + word.length());
                    for (String sub : sublist) {
                        res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                    }
                }
            }

            map.put(start, res);
            return res;
        }

        public List<String> wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
                return new ArrayList<>();
            return search(s, wordDict, new HashMap<>(), 0);
        }
    }

    /*
        Word Break II - Backtracking (Timeout)
        https://leetcode.com/problems/word-break-ii/
        Difficulty: Hard
     */
    public class Solution_3 {
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> res = new ArrayList<>();
            if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
                return res;
            int sLen = s.length();
            for (int i = sLen - 1; i >= 0; i--) {
                String last = s.substring(i, sLen);
                if (wordDict.contains(last)) {
                    if (i == 0) {
                        res.add(last);
                    } else {
                        String remain = s.substring(0, i);
                        List<String> remainSet = wordBreak(remain, wordDict);
                        if (remainSet != null) {
                            for (String item : remainSet) {
                                res.add(item + " " + last);
                            }
                        }
                    }
                }
            }
            return res;
        }
    }

}
