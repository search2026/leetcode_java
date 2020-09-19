package com.search2026.leetcode.problems;

public class Candy {

    /*
        Candy
        Leetcode #135
        https://leetcode.com/problems/candy/
        Difficulty: Hard
    */
    public class Solution {
        public int candy(int[] ratings) {
            int res = 0;
            if (ratings == null || ratings.length == 0) return res;
            int[] candies = new int[ratings.length];
            for (int i = 0; i < candies.length; i++) {
                candies[i] = 1;
            }
            for (int i = 1; i < candies.length; i++) {
                if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
                else if (ratings[i] < ratings[i - 1]) candies[i] = 1;
            }
            for (int i = candies.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) candies[i] = candies[i + 1] + 1;
            }
            for (int candy : candies) {
                res += candy;
            }
            return res;
        }
    }

}
