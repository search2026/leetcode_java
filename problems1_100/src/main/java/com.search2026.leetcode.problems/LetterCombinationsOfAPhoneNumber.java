package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    /*
        Letter Combinations of a Phone Number
        https://leetcode.com/problems/letter-combinations-of-a-phone-number/
        Difficulty: Medium
     */
    public class Solution {
        String[] Panel = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        private void search(ArrayList<String> comb, String digits, String curr) {
            if (curr.length() == digits.length()) {
                comb.add(curr);
                return;
            }
            String letters = Panel[digits.charAt(curr.length()) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                search(comb, digits, curr + letters.charAt(i));
            }
        }

        public List<String> letterCombinations(String digits) {
            ArrayList<String> comb = new ArrayList<>();
            if (digits.length() <= 0) return comb;
            search(comb, digits, "");
            return comb;
        }
    }

}
