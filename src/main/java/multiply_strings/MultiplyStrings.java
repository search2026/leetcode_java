package multiply_strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyStrings {
    /*
        Multiply Strings
        leetcode #43
        https://leetcode.com/problems/multiply-strings/
        Difficulty: Medium
     */
    public class Solution {
        private List<Integer> multiply(List<Integer> l1, List<Integer> l2) {
            List<Integer> result = new ArrayList<Integer>();
            for (int offset = 0; offset < l2.size(); offset++) {
                if (l2.get(offset) != 0) {
                    List<Integer> temp = multiplyDigit(l1, l2.get(offset));
                    result = add(temp, result, offset);
                }
            }
            return result;
        }

        private List<Integer> add(List<Integer> l1, List<Integer> l2, int offset) {
            List<Integer> result = new ArrayList<Integer>();
            int index = 0;
            while (index < offset) {
                if (index < l2.size()) {
                    result.add(l2.get(index));
                } else {
                    result.add(0);
                }
                index++;
            }
            int carry = 0;
            for (int i : l1) {
                int value = i + carry + (index < l2.size() ? l2.get(index) : 0);
                result.add(value % 10);
                carry = value / 10;
                index++;
            }
            if (carry != 0) {
                result.add(carry);
            }
            return result;
        }

        private List<Integer> toList(String s) {
            List<Integer> result = new ArrayList<Integer>();
            for (int i = s.length() - 1; i >= 0; i--) {
                result.add(s.charAt(i) - '0');
            }
            return result;
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
            List<Integer> result = new ArrayList<Integer>();
            int carry = 0;
            for (int i : l) {
                result.add((i * digit + carry) % 10);
                carry = (i * digit + carry) / 10;
            }
            if (carry != 0) {
                result.add(carry);
            }
            return result;
        }

        public String multiply(String num1, String num2) {
            return toString(multiply(toList(num1), toList(num2)));
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MultiplyStrings().new Solution();
            assertEquals(3, 3);
        }
    }
}
