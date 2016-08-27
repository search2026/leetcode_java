package ransom_note;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RansomNote {
  /*
      Ransom Note
      Leetcode #383
      https://leetcode.com/problems/ransom-note/
      Difficulty: Easy
   */
  public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
      int[] arr = new int[26];
      for (int i = 0; i < magazine.length(); i++) {
        arr[magazine.charAt(i) - 'a']++;
      }
      for (int i = 0; i < ransomNote.length(); i++) {
        if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
          return false;
        }
      }
      return true;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new RansomNote().new Solution();
      assertFalse(sol.canConstruct("a", "b"));
      assertFalse(sol.canConstruct("aa", "ab"));
      assertTrue(sol.canConstruct("aa", "aab"));
    }
  }
}

