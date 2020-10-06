package com.search2026.leetcode.problems;

public class BullsAndCows {
    /*
        Bulls and Cows
        Leetcode #299
        https://leetcode.com/problems/bulls-and-cows/
        Difficulty: Easy
     */
    public class Solution {
        public String getHint(String secret, String guess) {
            if (secret == null || guess == null || secret.length() != guess.length()) {
                return "";
            }

            int countA = 0;
            int countB = 0;
            int[] count = new int[10];

            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    countA++;
                } else {
                    count[secret.charAt(i) - '0']++;
                    if (count[secret.charAt(i) - '0'] <= 0) {
                        countB++;
                    }
                    count[guess.charAt(i) - '0']--;
                    if (count[guess.charAt(i) - '0'] >= 0) {
                        countB++;
                    }
                }
            }

            return String.valueOf(countA) + "A" + String.valueOf(countB) + "B";
        }
    }

}
