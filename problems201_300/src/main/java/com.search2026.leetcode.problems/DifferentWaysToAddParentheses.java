package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    /*
        Different Ways to Add Parentheses
        Leetcode #241
        https://leetcode.com/problems/different-ways-to-add-parentheses/
        Difficulty: Medium
     */
    public class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> res = new ArrayList<>();
            if (input == null || input.length() == 0) {
                return res;
            }

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (!isOperator(c)) {
                    continue;
                }

                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for (int num1 : left) {
                    for (int num2 : right) {
                        int val = calculate(num1, num2, c);
                        res.add(val);
                    }
                }
            }

            // only contains one number
            if (res.isEmpty()) {
                res.add(Integer.parseInt(input));
            }

            return res;
        }

        private int calculate(int num1, int num2, char operator) {
            int result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;
            }

            return result;
        }

        private boolean isOperator(char operator) {
            return (operator == '+') || (operator == '-') || (operator == '*');
        }
    }

}
