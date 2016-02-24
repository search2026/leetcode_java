package best_time_to_buy_and_sell_stock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestTimetoBuyandSellStock {
    /*
        Best Time to Buy and Sell Stock
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        Difficulty: Medium
     */
    public class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int maxProfit = 0;
            int minPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
                minPrice = Math.min(minPrice, prices[i]);
            }
            return maxProfit;
        }
    }

    /*
        Best Time to Buy and Sell Stock II
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int profit_sum = 0;
            for (int i = 1; i < prices.length; i++) {
                profit_sum += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit_sum;
        }
    }

    /*
        Best Time to Buy and Sell Stock III
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
        Difficulty: Hard
     */
    public class Solution_3 {
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
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
        Difficulty: Hard
     */
    public class Solution_4 {
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
         https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
         Difficulty: Medium
    */
    public class Solution_5 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) return 0;
            int n= prices.length;
            int[] buy = new int[n];
            int[] sell = new int[n];
            buy[0] = -prices[0];
            sell[0] = 0;
            for (int i = 1; i < n; i++) {
                buy[i] = Math.max(buy[i - 1], -prices[i] + ((i >= 2) ? sell[i - 2] : 0));
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            }
            return sell[n - 1];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BestTimetoBuyandSellStock().new Solution();
            assertEquals("a", "a");
        }

        @Test
        public void test5() {
            Solution_5 sol = new BestTimetoBuyandSellStock().new Solution_5();
            assertEquals(3, sol.maxProfit(new int[]{1, 2, 3, 0, 2}));
        }
    }
}
