package com.search2026.leetcode.problems;

public class ExcelSheetColumnNumber {

    /*
        Excel Sheet Column Number
        Leetcode #171
        https://leetcode.com/problems/excel-sheet-column-number/
        Difficulty: Easy
     */
    public class Solution {
        public int titleToNumber(String s) {
            int n = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                n = n * 26 + c - 'A' + 1;
            }
            return n;
        }
    }

}
