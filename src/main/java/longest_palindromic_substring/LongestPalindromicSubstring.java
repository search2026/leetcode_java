package longest_palindromic_substring;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubstring {
    /*
        Longest Palindromic Substring - Dynamic Programming
        https://leetcode.com/problems/longest-palindromic-substring/
        Difficulty: Medium
     */
    public class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return null;
            int n = s.length();
            if (n == 1) return s;
            boolean[][] dp = new boolean[2][n];
            int idx = 0, maxLen = 0;
            int cur = 1, last = 0;
            for (int i = 0; i < n; ++i) {
                cur = cur + last - (last = cur);
                for (int j = i; j >= 0; --j) {
                    if (j == i || j == i - 1)
                        dp[cur][j] = (s.charAt(i) == s.charAt(j));
                    else dp[cur][j] = (s.charAt(i) == s.charAt(j)) && dp[last][j + 1];
                    if (dp[cur][j] && (i - j + 1) > maxLen) {
                        idx = j;
                        maxLen = i - j + 1;
                    }
                }
            }
            return s.substring(idx, idx + maxLen);
        }
    }

    /*
        Longest Palindromic Substring - Expanding Around Center
        https://leetcode.com/problems/longest-palindromic-substring/
        Difficulty: Medium
    */
    public class Solution_2 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return null;
            int n = s.length();
            if (n == 1) return s;
            int idx = 0, maxLen = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j <= 1; ++j) {
                    boolean isP = true;
                    for (int k = 0; i - k >= 0 && i + j + k < n && isP; ++k) {
                        isP = (s.charAt(i - k) == s.charAt(i + j + k));
                        if (isP && (j + 1 + k * 2) > maxLen) {
                            idx = i - k;
                            maxLen = j + 1 + k * 2;
                        }
                    }
                }
            }
            return s.substring(idx, idx + maxLen);
        }
    }

    /*
        Longest Palindromic Substring - O(N)
        https://leetcode.com/problems/longest-palindromic-substring/
        Difficulty: Hard
    */
    public class Solution_3 {
        public String longestPalindrome(String s) {
            int n = s.length();
            int idx = 0, maxLen = 0;
            int mx = 0, id = 0;
            int[] p = new int[2 * n + 1];
            Arrays.fill(p, 0);
            for (int i = 0; i < 2 * n + 1; ++i) {
                p[i] = (mx > i) ? Math.min(p[2 * id - i], mx - i) : 0;
                int left = i - 1 - p[i], right = i + 1 + p[i];
                while (left >= 0 && right <= 2 * n) {
                    if (left % 2 == 0 || s.charAt(left / 2) == s.charAt(right / 2)) {
                        ++p[i];
                    } else break;
                    --left;
                    ++right;
                }
                if (i + p[i] > mx) {
                    id = i;
                    mx = i + p[i];
                }
                if (p[i] > maxLen) {
                    idx = i;
                    maxLen = p[i];
                }
            }
            idx = (idx - maxLen) / 2;
            return s.substring(idx, idx + maxLen);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LongestPalindromicSubstring().new Solution();
            assertEquals("a", sol.longestPalindrome("a"));
            assertEquals("aaaaaa", sol.longestPalindrome("aaaaaa"));
            assertEquals("aaaa", sol.longestPalindrome("aaaabb"));
        }

        @Test
        public void test2() {
            Solution_2 sol = new LongestPalindromicSubstring().new Solution_2();
            assertEquals("a", sol.longestPalindrome("a"));
            assertEquals("aaaaaa", sol.longestPalindrome("aaaaaa"));
            assertEquals("aaaa", sol.longestPalindrome("aaaabb"));
        }

        @Test
        public void test3() {
            Solution_3 sol = new LongestPalindromicSubstring().new Solution_3();
            assertEquals("a", sol.longestPalindrome("a"));
            assertEquals("aaaaaa", sol.longestPalindrome("aaaaaa"));
            assertEquals("aaaa", sol.longestPalindrome("aaaabb"));
        }
    }
}
