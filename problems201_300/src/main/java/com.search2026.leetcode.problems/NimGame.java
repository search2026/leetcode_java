package com.search2026.leetcode.problems;

public class NimGame {

    /*
        Nim Game
        Leetcode #292
        https://leetcode.com/problems/nim-game/
        Difficulty: Easy
     */
    public class Solution {
        public boolean canWinNim(int n) {
            return (n % 4) > 0;
        }
    }

}
