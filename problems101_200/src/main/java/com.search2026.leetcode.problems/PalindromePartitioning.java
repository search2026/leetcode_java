package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /*
        Palindrome Partitioning - Backtracking
        Leetcode #131
        https://leetcode.com/problems/palindrome-partitioning/
        Difficulty: Medium
     */
    public class Solution {
        private boolean isPalindrome(String str) {
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        }

        private void search(String s, int pos, List<List<String>> res, List<String> cur) {
            if (pos == s.length()) {
                res.add(new ArrayList<String>(cur));
                return;
            }
            for (int i = pos + 1; i <= s.length(); i++) {
                String prefix = s.substring(pos, i);
                if (isPalindrome(prefix)) {
                    cur.add(prefix);
                    search(s, i, res, cur);
                    cur.remove(cur.size() - 1);
                }
            }
        }

        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            if (s == null || s.length() == 0) return res;
            search(s, 0, res, new ArrayList<>());
            return res;
        }
    }

    /*
        Palindrome Partitioning - Dynamic Programming
        Leetcode #131
        https://leetcode.com/problems/palindrome-partitioning/
        Difficulty: Medium
     */
    public class Solution_2 {
        private void search(String s, boolean[][] dp, int pos, List<String> cur, List<List<String>> rslt) {
            if (pos == s.length()) {
                rslt.add(new ArrayList<>(cur));
                return;
            }
            for (int i = pos; i < s.length(); i++) {
                if (dp[pos][i]) {
                    cur.add(s.substring(pos, i + 1));
                    search(s, dp, i + 1, cur, rslt);
                    cur.remove(cur.size() - 1);
                }
            }
        }

        private boolean[][] getdict(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if ((s.charAt(i) == s.charAt(j)) && ((j - i <= 2) || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                    }
                }
            }
            return dp;
        }

        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return res;
            }
            boolean[][] dp = getdict(s);
            search(s, dp, 0, new ArrayList<>(), res);
            return res;
        }
    }

    /*
        Palindrome Partitioning II
        Leetcode #132
        https://leetcode.com/problems/palindrome-partitioning-ii/
        Difficulty: Medium
     */
    public class Solution_3 {
        public int minCut(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            boolean[][] isPalindrome = new boolean[s.length()][s.length()];
            int[] dp = new int[s.length() + 1];
            dp[0] = -1;
            for (int i = 0; i < s.length(); i++) {
                dp[i + 1] = i;
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
                        isPalindrome[j][i] = true;
                        dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
                    }
                }
            }
            return dp[s.length()];
        }
    }

}
