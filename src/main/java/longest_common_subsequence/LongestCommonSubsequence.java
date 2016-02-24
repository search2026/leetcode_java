package longest_common_subsequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequence {
    /*
        Longest Common Subsequence - Brute Force
        http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
        Difficulty: Medium
     */
    public class Solution {
        int search(String s, String t, int m, int n) {
            if (m == 0 || n == 0)
                return 0;
            if (s.charAt(m - 1) == t.charAt(n - 1))
                return 1 + search(s, t, m - 1, n - 1);
            else
                return Math.max(search(s, t, m, n - 1), search(s, t, m - 1, n));
        }

        int lcs(String s, String t) {
            if (s == null || t == null) return 0;
            return search(s, t, s.length(), t.length());
        }

    }

    /*
        Longest Common Subsequence - Dynamic Programming
        http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
        Difficulty: Medium
    */
    public class Solution_2 {
        int lcs(String s, String t) {
            if (s == null || t == null) return 0;
            int m = s.length(), n = t.length();
            if (m == 0 || n == 0) return 0;

            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            return dp[m][n];
        }
    }

    /*
        Longest Common Subsequence - Dynamic Programming
        http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
        Difficulty: Medium
    */
    public class Solution_3 {
        int lcs(String s, String t) {
            if (s == null || t == null) return 0;
            int m = s.length(), n = t.length();
            if (m == 0 || n == 0) return 0;

            int[] dp1 = new int[n+1];
            int[] dp2 = new int[n+1];
            //int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        dp2[j] = dp1[j - 1] + 1;
                    else
                        dp2[j] = Math.max(dp1[j], dp2[j - 1]);
                }
                for (int j =1; j<=n; j++)
                    dp1[j] = dp2[j];
            }

            return dp1[n];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LongestCommonSubsequence().new Solution();
            assertEquals(3, sol.lcs("ABCDGH", "AEDFHR"));
            Solution_2 sol2 = new LongestCommonSubsequence().new Solution_2();
            assertEquals(3, sol2.lcs("ABCDGH", "AEDFHR"));
            assertEquals(4, sol2.lcs("AGGTAB", "GXTXAYB"));
            Solution_3 sol3 = new LongestCommonSubsequence().new Solution_3();
            assertEquals(3, sol3.lcs("ABCDGH", "AEDFHR"));
            assertEquals(4, sol3.lcs("AGGTAB", "GXTXAYB"));        }
    }
}

