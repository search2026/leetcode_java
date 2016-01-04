package best_time_to_buy_and_sell_stock;

public class BestTimetoBuyandSellStock {
    /*
        Best Time to Buy and Sell Stock
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        Difficulty: Medium
     */
    public class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
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
        public int maxProfitII(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }
    }

    /*
        Best Time to Buy and Sell Stock III
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
        Difficulty: Hard
     */
    public class Solution_3 {
        public int maxProfitIII(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int[] profit = new int[prices.length];
            profit[0] = 0;
            int minPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                profit[i] = Math.max(profit[i - 1], prices[i] - minPrice);
                minPrice = Math.min(minPrice, prices[i]);
            }
            int maxPrice = prices[prices.length - 1];
            int maxProfit = profit[prices.length - 1];
            for (int i = prices.length - 2; i > 0; i--) {
                maxProfit = Math.max(maxProfit, profit[i - 1] + maxPrice
                        - prices[i]);
                maxPrice = Math.max(maxPrice, prices[i]);
            }
            return maxProfit;
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

        // Best Time to Buy and Sell Stock IV
        public int maxProfitIV(int k, int[] prices) {
            int n = prices.length;
            if (n <= 1) {
                return 0;
            }
            if (k >= n) {
                return maxProfitUnlimited(prices);
            }
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
        public int maxProfitCoolDown(int[] prices) {
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

    }
}
