package longest_substring_without_repeating_characters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithoutRepeatingCharacters {
  /*
      Longest Substring Without Repeating Characters - Dynamic Programming
      Leetcode #3
      https://leetcode.com/problems/longest-substring-without-repeating-characters/
      Difficulty: Medium
   */
  public class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s == null || s.length() == 0) return 0;
      int[] map = new int[Character.MAX_VALUE + 1];
      Arrays.fill(map, -1);
      int lastSeen = 0;
      int maxDist = 0;
      for (int i = 0; i < s.length(); i++) {
        lastSeen = Math.max(lastSeen, map[s.charAt(i)] + 1);
        maxDist = Math.max(maxDist, i - lastSeen + 1);
        map[s.charAt(i)] = i;
      }
      return maxDist;
    }
  }

  /*
      Longest Substring Without Repeating Characters - Sliding Window
      Leetcode #3
      https://leetcode.com/problems/longest-substring-without-repeating-characters/
      Difficulty: Medium
   */
  public class Solution_2 {
    public int lengthOfLongestSubstring(String s) {
      if (s == null || s.length() == 0) return 0;
      HashSet<Character> set = new HashSet<>();
      int p1 = 0, p2 = 0, maxDist = 0;
      while (p2 < s.length()) {
        if (set.contains(s.charAt(p2))) {
          maxDist = Math.max(maxDist, p2 - p1);
          while (s.charAt(p1) != s.charAt(p2)) {
            set.remove(s.charAt(p1));
            p1++;
          }
          p1++;
        } else {
          set.add(s.charAt(p2));
        }
        p2++;
      }
      maxDist = Math.max(maxDist, p2 - p1);
      return maxDist;
    }
  }

  /*
      Longest Substring Without Repeating Characters - template
      Leetcode #3
      https://leetcode.com/problems/longest-substring-without-repeating-characters/
      https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems
      Difficulty: Medium
   */
  public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
      if (s == null || s.length() == 0) return 0;
      int[] map = new int[Character.MAX_VALUE];
      int counter = 0, p1 = 0, p2 = 0, maxDist = 0;
      while (p2 < s.length()) {
        if (map[s.charAt(p2++)]++ > 0) counter++;
        while (counter > 0) if (map[s.charAt(p1++)]-- > 1) counter--;
        maxDist = Math.max(maxDist, p2 - p1);
      }
      return maxDist;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new LongestSubstringWithoutRepeatingCharacters().new Solution();
      assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"));
      assertEquals(1, sol.lengthOfLongestSubstring("bbbb"));
      assertEquals(3, sol.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void test2() {
      Solution_2 sol = new LongestSubstringWithoutRepeatingCharacters().new Solution_2();
      assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"));
      assertEquals(1, sol.lengthOfLongestSubstring("bbbb"));
      assertEquals(3, sol.lengthOfLongestSubstring("pwwkew"));
    }


    @Test
    public void test3() {
      Solution_3 sol = new LongestSubstringWithoutRepeatingCharacters().new Solution_3();
      assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"));
      assertEquals(1, sol.lengthOfLongestSubstring("bbbb"));
      assertEquals(3, sol.lengthOfLongestSubstring("pwwkew"));
    }
  }
}
