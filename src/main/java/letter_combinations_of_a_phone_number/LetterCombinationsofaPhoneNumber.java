package letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    public class Solution {
        public List<String> letterCombinations(String digits) {
            ArrayList<String> res = new ArrayList<String>();
            if (digits.length() <=0) return res;
            String[] keyboard = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            letterCombinationsRe(keyboard, res, digits, "");
            return res;
        }

        public void letterCombinationsRe(String[] keyboard, ArrayList<String> res, String digits, String s) {
            if (s.length() == digits.length()) {
                res.add(s);
                return;
            }
            String letters = keyboard[digits.charAt(s.length()) - '0'];
            for (int i = 0; i < letters.length(); ++i) {
                letterCombinationsRe(keyboard, res, digits, s + letters.charAt(i));
            }
        }
    }

    public static class UnitTest {

    }
}
