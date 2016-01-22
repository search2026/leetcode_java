package expression_add_operators;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ExpressionAddOperators {
    /*
        Expression Add Operators
        https://leetcode.com/problems/expression-add-operators/
        Difficulty: Medium
     */
    public class Solution {
        public void search(List<String> rslt, String cur, String num, int pos, long sum, long preVal, long target) {
            if (pos == num.length()) {
                if (sum == target) {
                    rslt.add(cur);
                }
                return;
            }
            for (int i = pos + 1; i <= num.length(); i++) {
                if (num.charAt(pos) == '0' && i > pos + 1) break; // case like: 105  1+05 wrong, 1+0+5 right
                String curStr = num.substring(pos, i);
                long curNum = Long.parseLong(curStr);
                if (pos == 0) {
                    search(rslt, curStr, num, i, curNum, curNum, target);
                } else {
                    search(rslt, cur + "+" + curStr, num, i, sum + curNum, curNum, target);
                    search(rslt, cur + "-" + curStr, num, i, sum - curNum, -curNum, target);
                    search(rslt, cur + "*" + curStr, num, i, sum - preVal + preVal * curNum, preVal * curNum, target);
                }
            }
        }

        public List<String> addOperators(String num, int target) {
            List<String> rslt = new ArrayList<String>();
            if (num == null || num.length() == 0) return rslt;
            search(rslt, "", num, 0, 0, 0, (long) target);
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ExpressionAddOperators().new Solution();
            List<String> rslt = sol.addOperators("123", 6);
            assertTrue(rslt.get(0).equals("1+2+3") || rslt.get(0).equals("1*2*3"));
            assertTrue(true);
        }
    }
}

