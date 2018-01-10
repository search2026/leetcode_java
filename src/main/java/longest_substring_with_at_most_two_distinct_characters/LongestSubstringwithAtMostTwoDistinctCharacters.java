package longest_substring_with_at_most_two_distinct_characters;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
  /*
      Longest Substring with At Most Two Distinct Characters
      leetcode #159
      https://leetcode.com/discuss/questions/oj/longest-substring-with-at-most-two-distinct-characters?sort=votes
      http://www.cnblogs.com/grandyang/p/5185561.html
      Difficulty: Hard
   */
  public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
      if (s == null || s.length() == 0) return 0;
      int maxDist = 0, lastSeen = 0;
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < s.length(); ++i) {
        map.put(s.charAt(i), i);
        while (map.size() > 2) {
          int currLeft = map.get(s.charAt(lastSeen));
          if (currLeft == lastSeen) map.remove(s.charAt(lastSeen));
          ++lastSeen;
        }
        maxDist = Math.max(maxDist, i - lastSeen + 1);
      }
      return maxDist;
    }
  }

  /*
      Longest Substring with At Most Two Distinct Characters - Sliding Windows
      leetcode #159
      https://leetcode.com/discuss/questions/oj/longest-substring-with-at-most-two-distinct-characters?sort=votes
      http://www.cnblogs.com/grandyang/p/5185561.html
      Difficulty: Hard
   */
  public class Solution_2 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
      if (s == null || s.length() == 0) return 0;
      int p1 = 0, p2 = -1, maxDist = 0;
      for (int k = 1; k < s.length(); k++) {
        if (s.charAt(k) == s.charAt(k - 1)) continue;
        if (p2 >= 0 && s.charAt(p2) != s.charAt(k)) {
          maxDist = Math.max(k - p1, maxDist);
          p1 = p2 + 1;
        }
        p2 = k - 1;
      }
      return Math.max(s.length() - p1, maxDist);
    }
  }

  /*
      Longest Substring with At Most Two Distinct Characters - Template
      leetcode #159
      https://leetcode.com/discuss/questions/oj/longest-substring-with-at-most-two-distinct-characters?sort=votes
      http://www.cnblogs.com/grandyang/p/5351347.html
      https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems
      Difficulty: Hard
   */
  public class Solution_3 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
      if (s == null || s.length() == 0) return 0;
      int[] map = new int[Character.MAX_VALUE];
      int counter = 0, p1 = 0, p2 = 0, maxDist = 0;
      while (p2 < s.length()) {
        if (map[s.charAt(p2++)]++ == 0) counter++;
        while (counter > 2) if (map[s.charAt(p1++)]-- == 1) counter--;
        maxDist = Math.max(maxDist, p2 - p1);
      }
      return maxDist;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new LongestSubstringwithAtMostTwoDistinctCharacters().new Solution();
      assertEquals(3, sol.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    @Test
    public void test2() {
      Solution_2 sol = new LongestSubstringwithAtMostTwoDistinctCharacters().new Solution_2();
      assertEquals(3, sol.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    @Test
    public void test3() {
      Solution_3 sol = new LongestSubstringwithAtMostTwoDistinctCharacters().new Solution_3();
      assertEquals(3, sol.lengthOfLongestSubstringTwoDistinct("eceba"));
    }
  }
}
