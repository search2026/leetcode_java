package letter_combinations_of_a_phone_number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LetterCombinationsofaPhoneNumber {
  /*
      Letter Combinations of a Phone Number
      https://leetcode.com/problems/letter-combinations-of-a-phone-number/
      Difficulty: Medium
   */
  public class Solution {
    String[] Panel = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void search(ArrayList<String> comb, String digits, String cur) {
      if (cur.length() == digits.length()) {
        comb.add(cur);
        return;
      }
      String letters = Panel[digits.charAt(cur.length()) - '0'];
      for (int i = 0; i < letters.length(); i++) {
        search(comb, digits, cur + letters.charAt(i));
      }
    }

    public List<String> letterCombinations(String digits) {
      ArrayList<String> comb = new ArrayList<>();
      if (digits.length() <= 0) return comb;
      search(comb, digits, "");
      return comb;
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
