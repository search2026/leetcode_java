package russian_doll_envelopes;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class RussianDollEnvelopes {
    /*
        Russian Doll Envelopes
        Leetcode #354
        https://leetcode.com/problems/russian-doll-envelopes/
        Difficulty: Hard
     */
    public class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null ||
                    envelopes.length == 0 ||
                    envelopes[0] == null ||
                    envelopes[0].length == 0) return 0;

            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] e1, int[] e2) {
                    return e1[0] - e2[0];
                }
            });

            int n = envelopes.length;
            int[] dp = new int[n];
            int rslt = 0;

            for (int i = 0; i < n; i++) {
                dp[i] = 1;

                for (int j = 0; j < n; j++) {
                    if (envelopes[i][0] > envelopes[j][0] &&
                            envelopes[i][1] > envelopes[j][1])
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }

                rslt = Math.max(rslt, dp[i]);
            }

            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RussianDollEnvelopes().new Solution();
            int[][] test1 = {
                    {5, 4},
                    {6, 4},
                    {6, 7},
                    {2, 3}
            };
            assertEquals(3, sol.maxEnvelopes(test1));
        }
    }
}

