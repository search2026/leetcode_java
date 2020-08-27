package first_unique_character_in_a_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUniqueCharacterinaString {
  /*
      First Unique Character in a String
      Leetcode #387
      https://leetcode.com/problems/first-unique-character-in-a-string/
      Difficulty: Easy
   */
  public class Solution {
    public int firstUniqChar(String s) {
      int freq[] = new int[26];
      for (int i = 0; i < s.length(); i++)
        freq[s.charAt(i) - 'a']++;
      for (int i = 0; i < s.length(); i++)
        if (freq[s.charAt(i) - 'a'] == 1)
          return i;
      return -1;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new FirstUniqueCharacterinaString().new Solution();
      assertEquals(4, sol.firstUniqChar("google"));
      assertEquals(0, sol.firstUniqChar("facebook"));
    }
  }
}

