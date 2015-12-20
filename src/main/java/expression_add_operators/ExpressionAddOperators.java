package expression_add_operators;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExpressionAddOperators {
    /*
        Expression Add Operators
        https://leetcode.com/problems/expression-add-operators/
        Difficulty: Medium
     */
    public class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> result = new ArrayList<>();

            if (num == null || num.length() == 0) {
                return result;
            }

            addOperatorHelper(num, 0, target, 0, 0, "", result);

            return result;
        }

        private void addOperatorHelper(String num, int start, int target, long curSum,
                                       long preNum, String curResult, List<String> result) {
            if (start == num.length() && curSum == target) {
                result.add(curResult);
                return;
            }

            if (start == num.length()) {
                return;
            }

            for (int i = start; i < num.length(); i++) {
                String curStr = num.substring(start, i + 1);
                if (curStr.length() > 1 && curStr.charAt(0) == '0') {
                    break;
                }

                long curNum = Long.parseLong(curStr);

                if (curResult.isEmpty()) {
                    addOperatorHelper(num, i + 1, target, curNum, curNum, curStr, result);
                } else {
                    // Multiply
                    addOperatorHelper(num, i + 1, target, curSum - preNum + preNum * curNum,
                            preNum * curNum, curResult + "*" + curNum, result);

                    // Add
                    addOperatorHelper(num, i + 1, target, curSum + curNum, curNum,
                            curResult + "+" + curNum, result);

                    // Subtract
                    addOperatorHelper(num, i + 1, target, curSum - curNum, -curNum,
                            curResult + "-" + curNum, result);
                }
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ExpressionAddOperators().new Solution();
        }
    }
}

