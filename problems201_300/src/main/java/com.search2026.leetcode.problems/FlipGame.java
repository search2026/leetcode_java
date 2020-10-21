package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

    /*
        Flip Game
        Leetcode #293
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/FlipGame.md
        Difficulty: Easy
    */
    public class Solution {
        public List<String> generatePossibleNextMoves(String s) {
            List<String> res = new ArrayList<>();
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                    res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
                }
            }
            return res;
        }
    }

    /*
        Flip Game II
        Leetcode #294
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/FlipGameII.md
        Difficulty: Medium
    */
    public class Solution_2 {
        public boolean canWin(String s) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == '+' && s.charAt(i + 1) == '+' && !canWin(s.substring(0, i) + "--" + s.substring(i + 2))) {
                    return true;
                }
            }
            return false;
        }
    }

}
