package edit_distance;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class EditDistance {
    /*
        Edit Distance
        Leetcode #72
        https://leetcode.com/problems/edit-distance/
        Difficulty: Hard
     */
    public class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i <= word2.length(); i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= word1.length(); i++) {
                dp[i][0] = i;
                for (int j = 1; j <= word2.length(); j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }

    /*
        Edit Distance - In memory array
        Leetcode #72
        https://leetcode.com/problems/edit-distance/
        Difficulty: Hard
     */
    public class Solution_2 {
        public int minDistance(String word1, String word2) {
            int[] dp1 = new int[word2.length() + 1];
            int[] dp2 = new int[word2.length() + 1];
            for (int i = 0; i <= word2.length(); i++) {
                dp1[i] = i;
            }
            for (int i = 1; i <= word1.length(); i++) {
                dp2[0] = i;
                for (int j = 1; j <= word2.length(); j++) {
                    dp2[j] = Math.min(dp2[j-1], dp1[j]) + 1;
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp2[j] = Math.min(dp2[j], dp1[j-1]);
                    } else {
                        dp2[j] = Math.min(dp2[j], dp1[j-1] + 1);
                    }
                }
                for (int j=0; j<=word2.length(); j++)
                    dp1[j] = dp2[j];
            }
            return dp1[word2.length()];
        }
    }
    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new EditDistance().new Solution();
            assertEquals(sol.minDistance("a",""), 1);
            assertEquals(sol.minDistance("a","bcd"), 3);
            Solution_2 sol2 = new EditDistance().new Solution_2();
            assertEquals(sol2.minDistance("a",""), 1);
            assertEquals(sol2.minDistance("a","bcd"), 3);
        }
    }
}
