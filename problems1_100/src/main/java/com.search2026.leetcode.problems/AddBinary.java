package com.search2026.leetcode.problems;

public class AddBinary {

    /*
        Add Binary
        Leetcode #67
        https://leetcode.com/problems/add-binary/
        Difficulty: Easy
     */
    public class Solution {
        public String addBinary(String a, String b) {
            if (a == null || a.length() == 0) return b;
            if (b == null || b.length() == 0) return a;
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            while (i >= 0 || j >= 0 || carry > 0) {
                int valueA = i < 0 ? 0 : a.charAt(i) - '0';
                int valueB = j < 0 ? 0 : b.charAt(j) - '0';
                int sum = valueA + valueB + carry;
                sb.append(sum % 2);
                carry = sum / 2;
                i--;
                j--;
            }
            return sb.reverse().toString();
        }
    }

}
