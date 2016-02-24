package largest_number;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class LargestNumber {
    /*
        Largest Number
        https://leetcode.com/problems/largest-number/
        leetcode 179
        Difficulty: Medium
     */
    public class Solution {
        private int skipLendingZeros(String s) {
            int i = 0;
            for (; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    return i;
                }
            }
            return i;
        }

        public String largestNumber(int[] nums) {
            String[] number = new String[nums.length];
            for (int i = 0; i < number.length; i++) {
                number[i] = Integer.toString(nums[i]);
            }
            Arrays.sort(number, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return -(s1 + s2).compareTo(s2 + s1);
                }
            });
            StringBuilder builder = new StringBuilder();
            boolean skip = true;
            for (String n : number) {
                if (skip) {
                    int start = skipLendingZeros(n);
                    if (start != n.length()) {
                        skip = false;
                        builder.append(n, start, n.length());
                    }
                } else {
                    builder.append(n);
                }
            }
            String r = builder.toString();
            return r.isEmpty() ? "0" : r;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LargestNumber().new Solution();
            assertEquals(3, 3);
        }
    }
}

