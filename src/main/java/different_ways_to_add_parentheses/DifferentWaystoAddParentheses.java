package different_ways_to_add_parentheses;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    /*
        Different Ways to Add Parentheses
        https://leetcode.com/problems/different-ways-to-add-parentheses/
        Difficulty: Medium
     */
    public class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> result = new ArrayList<>();
            if (input == null || input.length() == 0) {
                return result;
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
                        result.add(val);
                    }
                }
            }

            // only contains one number
            if (result.isEmpty()) {
                result.add(Integer.parseInt(input));
            }

            return result;
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

    public static class UnitTest {

    }
}
