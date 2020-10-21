package com.search2026.leetcode.problems;

public class ReverseWordsInAString {

    /*
        Reverse Words in a String
        Leetcode #151
        https://leetcode.com/problems/reverse-words-in-a-string/
        Difficulty: Medium
     */
    public class Solution {
        public String reverseWords(String s) {
            String[] tokens = s.split(" +");
            StringBuilder r = new StringBuilder();
            boolean isFirst = true;
            for (int i = tokens.length - 1; i >= 0; i--) {
                String token = tokens[i];
                if (token.isEmpty()) {
                    continue;
                }
                if (isFirst) {
                    isFirst = false;
                } else {
                    r.append(' ');
                }
                r.append(token);
            }
            return r.toString();
        }
    }

    /*
        Reverse Words in a String II
        Leetcode #186
        https://github.com/search2026/leetcode_java/blob/master/problems101_200/resources/ReverseWordsInAStringII.md
        Difficulty: Medium
     */
    public class Solution_2 {
        private void reverse(char[] s, int start, int end) {
            for (int i = 0; i < (end - start) / 2; i++) {
                char temp = s[start + i];
                s[start + i] = s[end - i - 1];
                s[end - i - 1] = temp;
            }
        }

        public void reverseWords(char[] s) {
            if (s == null || s.length < 2) return;
            int n = s.length;
            reverse(s, 0, n);
            for (int p1 = 0, p2 = 0; p2 <= n; p2++) {
                if (p2 == n || s[p2] == ' ') {
                    reverse(s, p1, p2);
                    p1 = p2 + 1;
                }
            }
        }
    }

}
