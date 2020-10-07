package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

    /*
        Multiply Strings
        leetcode #43
        https://leetcode.com/problems/multiply-strings/
        Difficulty: Medium
     */
    public class Solution {
        private List<Integer> multiply(List<Integer> l1, List<Integer> l2) {
            List<Integer> res = new ArrayList<>();
            for (int offset = 0; offset < l2.size(); offset++) {
                if (l2.get(offset) != 0) {
                    List<Integer> temp = multiplyDigit(l1, l2.get(offset));
                    res = add(temp, res, offset);
                }
            }
            return res;
        }

        private List<Integer> add(List<Integer> l1, List<Integer> l2, int offset) {
            List<Integer> res = new ArrayList<>();
            int idx = 0;
            while (idx < offset) {
                if (idx < l2.size()) {
                    res.add(l2.get(idx));
                } else {
                    res.add(0);
                }
                idx++;
            }
            int carry = 0;
            for (int i : l1) {
                int value = i + carry + (idx < l2.size() ? l2.get(idx) : 0);
                res.add(value % 10);
                carry = value / 10;
                idx++;
            }
            if (carry != 0) {
                res.add(carry);
            }
            return res;
        }

        private List<Integer> toList(String s) {
            List<Integer> res = new ArrayList<>();
            for (int i = s.length() - 1; i >= 0; i--) {
                res.add(s.charAt(i) - '0');
            }
            return res;
        }

        private String toString(List<Integer> l) {
            StringBuilder builder = new StringBuilder();
            int i = l.size() - 1;
            for (; i >= 0; i--) {
                if (l.get(i) != 0) {
                    break;
                }
            }
            for (; i >= 0; i--) {
                builder.append(l.get(i));
            }
            if (builder.length() == 0) {
                return "0";
            }
            return builder.toString();
        }

        private List<Integer> multiplyDigit(List<Integer> l, int digit) {
            List<Integer> res = new ArrayList<>();
            int carry = 0;
            for (int i : l) {
                res.add((i * digit + carry) % 10);
                carry = (i * digit + carry) / 10;
            }
            if (carry != 0) {
                res.add(carry);
            }
            return res;
        }

        public String multiply(String num1, String num2) {
            return toString(multiply(toList(num1), toList(num2)));
        }
    }

}
