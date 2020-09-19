package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockTests {

    @Test
    public void testSolution() {
        BestTimeToBuyAndSellStock.Solution sol = new BestTimeToBuyAndSellStock().new Solution();
        int[] test = {7, 1, 5, 3, 6, 4};
        assertEquals(5, sol.maxProfit(test));
        test = new int[]{7, 6, 4, 3, 1};
        assertEquals(0, sol.maxProfit(test));
    }

    @Test
    public void testSolution2() {
        BestTimeToBuyAndSellStock.Solution_2 sol = new BestTimeToBuyAndSellStock().new Solution_2();
        int[] test = {7, 1, 5, 3, 6, 4};
        assertEquals(7, sol.maxProfit(test));
        test = new int[]{7, 8, 4, 6, 1, 3};
        assertEquals(5, sol.maxProfit(test));
    }

    @Test
    public void testSolution3() {
        BestTimeToBuyAndSellStock.Solution_3 sol = new BestTimeToBuyAndSellStock().new Solution_3();
        int[] test = {7, 1, 5, 3, 6, 4};
        assertEquals(7, sol.maxProfit(test));
        test = new int[]{7, 8, 4, 6, 1, 3};
        assertEquals(4, sol.maxProfit(test));
    }

    @Test
    public void testSolution4() {
        BestTimeToBuyAndSellStock.Solution_4 sol = new BestTimeToBuyAndSellStock().new Solution_4();
        int[] test = {7, 1, 5, 3, 6, 4};
        assertEquals(7, sol.maxProfit(test));
        test = new int[]{7, 8, 4, 6, 1, 3};
        assertEquals(4, sol.maxProfit(test));
    }

    @Test
    public void testSolution5() {
        BestTimeToBuyAndSellStock.Solution_5 sol = new BestTimeToBuyAndSellStock().new Solution_5();
        int[] test = {7, 1, 5, 3, 6, 4};
        assertEquals(7, sol.maxProfit(2, test));
        test = new int[]{7, 8, 4, 6, 1, 3};
        assertEquals(4, sol.maxProfit(2, test));
        assertEquals(5, sol.maxProfit(3, test));
    }

    @Test
    public void testSolution6() {
        BestTimeToBuyAndSellStock.Solution_6 sol = new BestTimeToBuyAndSellStock().new Solution_6();
        assertEquals(3, sol.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

}
