package longest_palindromic_substring;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubstring {
  /*
      Longest Palindromic Substring - Dynamic Programming
      leetcode #5
      https://leetcode.com/problems/longest-palindromic-substring/
      Difficulty: Medium
   */
  public class Solution {
    public String longestPalindrome(String s) {
      if (s == null) return null;
      int n = s.length();
      if (n == 0) return null;
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
      leetcode #5
      https://leetcode.com/problems/longest-palindromic-substring/
      Difficulty: Medium
  */
  public class Solution_2 {
    private int expandAroundCenter(String s, int left, int right) {
      while( left >= 0 && right < s.length() && s. charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      return right-left-1;
    }

    public String longestPalindrome(String s) {
      if (s == null) return null;
      int n = s.length();
      if (n == 0) return null;
      if (n == 1) return s;

      int start = 0, end = 0;
      for (int i = 0; i < n; i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
          start = i - (len - 1) / 2;
          end = i + len / 2;
        }
      }

      return s.substring(start, end+1);
    }
  }

  /*
      Longest Palindromic Substring - O(N) Manacher’s algorithm
      leetcode #5
      https://leetcode.com/problems/longest-palindromic-substring/
      Difficulty: Hard
  */
  public class Solution_3 {
    public String longestPalindrome(String s) {
      if (s == null) return null;
      int n = s.length();
      if (n == 0) return null;
      if (n == 1) return s;

      int idx = 0, maxLen = 0;
      int mx = 0, id = 0;
      int[] p = new int[2 * n + 1];
      Arrays.fill(p, 0);

      for (int i = 0; i < 2 * n + 1; i++) {
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
