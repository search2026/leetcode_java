package roman_to_integer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RomantoInteger {
    /*
        Roman to Integer
        Leetcode #13
        https://leetcode.com/problems/roman-to-integer/
        Difficulty: Easy
     */
    public class Solution {
        private Map<Character, Integer> symbols = new HashMap<Character, Integer>();
        {
            symbols.put('M', 1000);
            symbols.put('D', 500);
            symbols.put('C', 100);
            symbols.put('L', 50);
            symbols.put('X', 10);
            symbols.put('V', 5);
            symbols.put('I', 1);
        }

        public int romanToInt(String s) {
            int num = 0;
            num += symbols.get(s.charAt(s.length() - 1));
            for (int i = s.length() - 2; i >= 0; i--) {
                char c = s.charAt(i);
                char nextC = s.charAt(i + 1);
                if (symbols.get(c) < symbols.get(nextC)) {
                    num -= symbols.get(c);
                } else {
                    num += symbols.get(c);
                }
            }
            return num;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RomantoInteger().new Solution();
            assertEquals(7, 7);
        }
    }
}
