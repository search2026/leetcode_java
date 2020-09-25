package com.search2026.leetcode.problems;

public class ExcelSheetColumnTitle {

    /*
        Excel Sheet Column Title
        Leetcode #168
        https://leetcode.com/problems/excel-sheet-column-title/
        Difficulty: Easy
     */
    public class Solution {
        public String convertToTitle(int n) {
            StringBuilder builder = new StringBuilder();
            while (n != 0) {
                n--;
                char c = (char) (n % 26 + 'A');
                builder.append(c);
                n /= 26;
            }
            return builder.reverse().toString();
        }
    }

}
