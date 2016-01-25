package knapsack_problem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackProblem {
    /*
        Knapsack Problem
        http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
        https://en.wikipedia.org/wiki/Knapsack_problem
        Difficulty: Medium
     */
    public class Solution {
        int knapSack(int[] wt, int[] val, int weight) {
            if (wt == null || wt.length == 0 || val == null || val.length == 0) return 0;
            if (weight == 0) return 0;
            if (wt.length != val.length) return 0;
            int n = wt.length;

            int dp[][] = new int[n + 1][weight + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= weight; j++) {
                    if (j >= wt[i - 1]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[n][weight];
        }
    }

    /*
        Knapsack Problem
        http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
        https://en.wikipedia.org/wiki/Knapsack_problem
        Difficulty: Medium
     */
    public class Solution_2 {
        int knapSack(int[] wt, int[] val, int weight) {
            if (wt == null || wt.length == 0 || val == null || val.length == 0) return 0;
            if (weight == 0) return 0;
            if (wt.length != val.length) return 0;
            int n = wt.length;

            int dp1[] = new int[weight + 1];
            int dp2[] = new int[weight + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= weight; j++) {
                    if (j >= wt[i - 1] ) {
                        dp2[j] = Math.max(dp1[j], dp1[j - wt[i - 1]] + val[i - 1]);
                    }
                }
                for (int j = 0; j <= weight; j++) {
                    dp1[j] = dp2[j];
                }
            }
            return dp1[weight];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new KnapsackProblem().new Solution();
            int val[] = new int[]{6, 3, 5, 4};
            int wt[] = new int[]{5, 2, 4, 3};
            assertEquals(7, sol.knapSack(wt, val, 5));
            val = new int[]{10, 40, 30, 50};
            wt = new int[]{5, 4, 6, 3};
            assertEquals(90, sol.knapSack(wt, val, 10));
            val = new int[]{22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
            wt = new int[]{4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
            assertEquals(182, sol.knapSack(wt, val, 30));
            val = new int[]{60, 100, 120};
            wt = new int[]{10, 20, 30};
            assertEquals(220, sol.knapSack(wt, val, 50));
            val = new int[]{50, 30, 20, 10, 50};
            wt = new int[]{1, 56, 42, 78, 12};
            assertEquals(150, sol.knapSack(wt, val, 150));
        }

        @Test
        public void test2() {
            Solution_2 sol = new KnapsackProblem().new Solution_2();
            int val[] = new int[]{6, 3, 5, 4};
            int wt[] = new int[]{5, 2, 4, 3};
            assertEquals(7, sol.knapSack(wt, val, 5));
            val = new int[]{10, 40, 30, 50};
            wt = new int[]{5, 4, 6, 3};
            assertEquals(90, sol.knapSack(wt, val, 10));
            val = new int[]{22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
            wt = new int[]{4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
            assertEquals(182, sol.knapSack(wt, val, 30));
            val = new int[]{60, 100, 120};
            wt = new int[]{10, 20, 30};
            assertEquals(220, sol.knapSack(wt, val, 50));
            val = new int[]{50, 30, 20, 10, 50};
            wt = new int[]{1, 56, 42, 78, 12};
            assertEquals(150, sol.knapSack(wt, val, 150));
        }
    }
}

