package word_break;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordBreak {
  /*
      Word Break
      Leetcode #139
      https://leetcode.com/problems/word-break/
      Difficulty: Medium
   */
  public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
      if (s == null || s.length() == 0) return true;
      if (dict == null || dict.size() == 0) return false;

      int sLen = s.length();
      boolean[] dp = new boolean[sLen + 1];
      dp[0] = true;

      for (int i = 1; i <= sLen; i++) {
        for (int j = 0; j < i; j++) {
          if (dp[j] && dict.contains(s.substring(j, i))) {
            dp[i] = true;
            break;
          }
        }
      }

      return dp[s.length()];
    }
  }

  /*
      Word Break II - Backtracking + Hashmap
      Leetcode #140
      https://leetcode.com/problems/word-break-ii/
      Difficulty: Hard
   */
  public class Solution_2 {
    private List<String> search(String s, Set<String> dict, HashMap<Integer, List<String>> map, int start) {
      if (map.containsKey(start)) return map.get(start);

      List<String> list = new ArrayList<>();
      if (start == s.length()) {
        list.add("");
        return list;
      }

      String curr = s.substring(start);
      for (String word : dict) {
        if (curr.startsWith(word)) {
          List<String> sublist = search(s, dict, map, start + word.length());
          for (String sub : sublist) {
            list.add(word + (sub.isEmpty() ? "" : " ") + sub);
          }
        }
      }

      map.put(start, list);
      return list;
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
      return search(s, wordDict, new HashMap<Integer, List<String>>(), 0);
    }
  }

  /*
      Word Break II - Backtracking + Hashmap
      Leetcode #140
      https://leetcode.com/problems/word-break-ii/
      Difficulty: Hard
   */
  public class Solution_3 {
    private Map<String, List<String>> map = new HashMap<String, List<String>>();

    public List<String> wordBreak(String s, Set<String> wordDict) {
      if (map.containsKey(s)) return map.get(s);

      int n = s.length();
      List<String> list = new ArrayList<String>();
      if (wordDict.contains(s)) list.add(s);

      for (int i = 1; i < n; i++) {
        String curr = s.substring(i);
        if (wordDict.contains(curr)) {
          List<String> strs = wordBreak(s.substring(0, i), wordDict);
          if (strs.size() != 0) {
            for (Iterator<String> it = strs.iterator(); it.hasNext(); ) {
              list.add(it.next() + " " + curr);
            }
          }
        }
      }

      map.put(s, list);
      return list;
    }
  }

  /*
      Word Break II - Backtracking
      https://leetcode.com/problems/word-break-ii/
      Difficulty: Hard
   */
  public class Solution_4 {
    public List<String> wordBreak(String s, Set<String> dict) {
      List<String> words = new ArrayList<>();
      int sLen = s.length();
      for (int i = sLen - 1; i >= 0; i--) {
        String last = s.substring(i, sLen);
        if (dict.contains(last)) {
          if (i == 0) {
            words.add(last);
          } else {
            String remain = s.substring(0, i);
            List<String> remainSet = wordBreak(remain, dict);
            if (remainSet != null) {
              for (String item : remainSet) {
                words.add(item + " " + last);
              }
            }
          }
        }
      }
      return words;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new WordBreak().new Solution();
      Set<String> dict = new HashSet<>();
      dict.add("life");
      dict.add("code");
      assertTrue(sol.wordBreak("codelife", dict));
      assertTrue(sol.wordBreak("lifecode", dict));
      assertFalse(sol.wordBreak("code-life", dict));
    }

    @Test
    public void test2() {
      Solution_2 sol = new WordBreak().new Solution_2();
      Set<String> dict = new HashSet<>();
      dict.add("cat");
      dict.add("cats");
      dict.add("sand");
      dict.add("and");
      dict.add("dog");
      List<String> rslt = sol.wordBreak("catsanddog", dict);
      assertEquals(2, rslt.size());
      assertTrue(rslt.get(0).equals("cats and dog"));
      assertTrue(rslt.get(1).equals("cat sand dog"));
    }

    @Test
    public void test3() {
      Solution_3 sol = new WordBreak().new Solution_3();
      Set<String> dict = new HashSet<>();
      dict.add("cat");
      dict.add("cats");
      dict.add("sand");
      dict.add("and");
      dict.add("dog");
      List<String> rslt = sol.wordBreak("catsanddog", dict);
      assertEquals(2, rslt.size());
      assertTrue(rslt.get(0).equals("cat sand dog"));
      assertTrue(rslt.get(1).equals("cats and dog"));
    }


    @Test
    public void test4() {
      Solution_4 sol = new WordBreak().new Solution_4();
      Set<String> dict = new HashSet<>();
      dict.add("cat");
      dict.add("cats");
      dict.add("sand");
      dict.add("and");
      dict.add("dog");
      List<String> rslt = sol.wordBreak("catsanddog", dict);
      assertEquals(2, rslt.size());
      assertTrue(rslt.get(0).equals("cats and dog"));
      assertTrue(rslt.get(1).equals("cat sand dog"));
    }
  }
}
