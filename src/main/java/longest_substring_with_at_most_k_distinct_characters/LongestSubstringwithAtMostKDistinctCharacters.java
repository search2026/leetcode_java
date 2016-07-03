package longest_substring_with_at_most_k_distinct_characters;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LongestSubstringwithAtMostKDistinctCharacters {
  /*
      Longest Substring with At Most K Distinct Characters - Sliding Window
      leetcode #340
      https://leetcode.com/discuss/questions/oj/longest-substring-with-at-most-k-distinct-characters?sort=votes
      http://www.cnblogs.com/grandyang/p/5351347.html
      Difficulty: Hard
   */
  public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      if (s == null || s.length() == 0) return 0;
      int maxDist = 0, lastSeen = 0;
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < s.length(); ++i) {
        map.put(s.charAt(i), i);
        while (map.size() > k) {
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
    Longest Substring with At Most K Distinct Characters - tempplate
    leetcode #340
    https://leetcode.com/discuss/questions/oj/longest-substring-with-at-most-k-distinct-characters?sort=votes
    http://www.cnblogs.com/grandyang/p/5351347.html
    https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems
    Difficulty: Hard
 */
  public class Solution_2 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      if (s == null || s.length() == 0) return 0;
      int[] map = new int[Character.MAX_VALUE];
      int counter = 0, p1 = 0, p2 = 0, maxDist = 0;
      while (p2 < s.length()) {
        if (map[s.charAt(p2++)]++ == 0) counter++;
        while (counter > k) if (map[s.charAt(p1++)]-- == 1) counter--;
        maxDist = Math.max(maxDist, p2 - p1);
      }
      return maxDist;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new LongestSubstringwithAtMostKDistinctCharacters().new Solution();
      assertEquals(3, sol.lengthOfLongestSubstringKDistinct("eceba", 2));
      assertEquals(4, sol.lengthOfLongestSubstringKDistinct("eceba", 3));
    }

    @Test
    public void test2() {
      Solution_2 sol = new LongestSubstringwithAtMostKDistinctCharacters().new Solution_2();
      assertEquals(3, sol.lengthOfLongestSubstringKDistinct("eceba", 2));
      assertEquals(4, sol.lengthOfLongestSubstringKDistinct("eceba", 3));
    }
  }
}

