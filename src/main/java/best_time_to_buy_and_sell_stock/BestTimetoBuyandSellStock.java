package best_time_to_buy_and_sell_stock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimetoBuyandSellStock {
    /*
        Best Time to Buy and Sell Stock
        Leetcode #121
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        Difficulty: Medium
     */
    public class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int maxProfit = 0;
            int minSoFar = Integer.MAX_VALUE;
            for (int p : prices) {
                minSoFar = Math.min(minSoFar, p);
                maxProfit = Math.max(maxProfit, p - minSoFar);
            }
            return maxProfit;
        }
    }

    /*
        Best Time to Buy and Sell Stock II
        Leetcode #122
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int profits = 0;
            for (int i = 1; i < prices.length; i++) {
                profits += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profits;
        }
    }

    /*
        Best Time to Buy and Sell Stock III
        Leetcode #123
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
        Difficulty: Hard
     */
    public class Solution_3 {
        public int maxProfit(int[] prices) {
            int maxProfit1 = 0;
            int maxProfit2 = 0;
            int lowestBuyPrice1 = Integer.MAX_VALUE;
            int lowestBuyPrice2 = Integer.MAX_VALUE;

            for (int p : prices) {
                maxProfit2 = Math.max(maxProfit2, p - lowestBuyPrice2);
                lowestBuyPrice2 = Math.min(lowestBuyPrice2, p - maxProfit1);
                maxProfit1 = Math.max(maxProfit1, p - lowestBuyPrice1);
                lowestBuyPrice1 = Math.min(lowestBuyPrice1, p);
            }
            return maxProfit2;
        }
    }

    /*
        Best Time to Buy and Sell Stock III - Expandable to K trans
        Leetcode #123
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
        Difficulty: Hard
     */
    public class Solution_4 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int[] local = new int[3];
            int[] global = new int[3];
            for (int i = 0; i < prices.length - 1; i++) {
                int diff = prices[i + 1] - prices[i];
                for (int j = 2; j >= 1; j--) {
                    local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0), local[j] + diff);
                    global[j] = Math.max(local[j], global[j]);
                }
            }
            return global[2];
        }
    }

    /*
        Best Time to Buy and Sell Stock IV
        Leetcode #188
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
        Difficulty: Hard
     */
    public class Solution_5 {
        private int maxProfitUnlimited(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }

        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            if (n <= 1) return 0;
            if (k >= n) return maxProfitUnlimited(prices);

            int[] global = new int[k + 1];
            int[] local = new int[k + 1];
            for (int i = 1; i < n; i++) {
                int diff = prices[i] - prices[i - 1];
                for (int j = k; j >= 1; j--) {
                    local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                    global[j] = Math.max(global[j], local[j]);
                }
            }
            return global[k];
        }
    }

    /*
         Best Time to Buy and Sell Stock with Cooldown
         Leetcode #309
         https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
         Difficulty: Medium
    */
    public class Solution_6 {
        public int maxProfit(int[] prices) {
            int profit1 = 0, profit2 = 0;
            for (int i = 1; i < prices.length; i++) {
                int copy = profit1;
                profit1 = Math.max(profit1 + prices[i] - prices[i - 1], profit2);
                profit2 = Math.max(copy, profit2);
            }
            return Math.max(profit1, profit2);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BestTimetoBuyandSellStock().new Solution();
            int[] test = {7, 1, 5, 3, 6, 4};
            assertEquals(5, sol.maxProfit(test));
            test = new int[]{7, 6, 4, 3, 1};
            assertEquals(0, sol.maxProfit(test));
        }

        @Test
        public void test2() {
            Solution_2 sol = new BestTimetoBuyandSellStock().new Solution_2();
            int[] test = {7, 1, 5, 3, 6, 4};
            assertEquals(7, sol.maxProfit(test));
            test = new int[]{7, 8, 4, 6, 1, 3};
            assertEquals(5, sol.maxProfit(test));
        }

        @Test
        public void test3() {
            Solution_3 sol = new BestTimetoBuyandSellStock().new Solution_3();
            int[] test = {7, 1, 5, 3, 6, 4};
            assertEquals(7, sol.maxProfit(test));
            test = new int[]{7, 8, 4, 6, 1, 3};
            assertEquals(4, sol.maxProfit(test));
        }

        @Test
        public void test4() {
            Solution_4 sol = new BestTimetoBuyandSellStock().new Solution_4();
            int[] test = {7, 1, 5, 3, 6, 4};
            assertEquals(7, sol.maxProfit(test));
            test = new int[]{7, 8, 4, 6, 1, 3};
            assertEquals(4, sol.maxProfit(test));
        }

        @Test
        public void test5() {
            Solution_5 sol = new BestTimetoBuyandSellStock().new Solution_5();
            int[] test = {7, 1, 5, 3, 6, 4};
            assertEquals(7, sol.maxProfit(2, test));
            test = new int[]{7, 8, 4, 6, 1, 3};
            assertEquals(4, sol.maxProfit(2, test));
            assertEquals(5, sol.maxProfit(3, test));
        }

        @Test
        public void test6() {
            Solution_6 sol = new BestTimetoBuyandSellStock().new Solution_6();
            assertEquals(3, sol.maxProfit(new int[]{1, 2, 3, 0, 2}));
        }
    }
}
