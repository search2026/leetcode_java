package letter_combinations_of_a_phone_number;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LetterCombinationsofaPhoneNumber {
    /*
        Letter Combinations of a Phone Number
        https://leetcode.com/problems/letter-combinations-of-a-phone-number/
        Difficulty: Medium
     */
    public class Solution {
        String[] Panel = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            ArrayList<String> rslt = new ArrayList<String>();
            if (digits.length() <= 0) return rslt;
            search(rslt, digits, "");
            return rslt;
        }

        public void search(ArrayList<String> rslt, String digits, String cur) {
            if (cur.length() == digits.length()) {
                rslt.add(cur);
                return;
            }
            String letters = Panel[digits.charAt(cur.length()) - '0'];
            for (int i = 0; i < letters.length(); ++i) {
                search(rslt, digits, cur + letters.charAt(i));
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LetterCombinationsofaPhoneNumber().new Solution();
            assertTrue(true);
        }
    }
}
