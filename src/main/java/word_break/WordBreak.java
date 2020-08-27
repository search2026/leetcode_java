package word_break;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordBreak {
    /*
        Word Break
        Leetcode #139
        https://leetcode.com/problems/word-break/
        Difficulty: Medium
     */
    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0) return true;
            if (wordDict == null || wordDict.size() == 0) return false;

            int sLen = s.length();
            boolean[] dp = new boolean[sLen + 1];
            dp[0] = true;

            for (int i = 1; i <= sLen; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[sLen];
        }
    }

    /*
        Word Break II - Backtracking + Hashmap
        Leetcode #140
        https://leetcode.com/problems/word-break-ii/
        Difficulty: Hard
     */
    public class Solution_2 {
        private List<String> search(String s, List<String> dict, HashMap<Integer, List<String>> map, int start) {
            if (map.containsKey(start)) return map.get(start);

            List<String> res = new ArrayList<>();
            if (start == s.length()) {
                res.add("");
                return res;
            }

            String curr = s.substring(start);
            for (String word : dict) {
                if (curr.startsWith(word)) {
                    List<String> sublist = search(s, dict, map, start + word.length());
                    for (String sub : sublist) {
                        res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                    }
                }
            }

            map.put(start, res);
            return res;
        }

        public List<String> wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
                return new ArrayList<>();
            return search(s, wordDict, new HashMap<>(), 0);
        }
    }

    /*
        Word Break II - Backtracking (Timeout)
        https://leetcode.com/problems/word-break-ii/
        Difficulty: Hard
     */
    public class Solution_3 {
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> res = new ArrayList<>();
            if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
                return res;
            int sLen = s.length();
            for (int i = sLen - 1; i >= 0; i--) {
                String last = s.substring(i, sLen);
                if (wordDict.contains(last)) {
                    if (i == 0) {
                        res.add(last);
                    } else {
                        String remain = s.substring(0, i);
                        List<String> remainSet = wordBreak(remain, wordDict);
                        if (remainSet != null) {
                            for (String item : remainSet) {
                                res.add(item + " " + last);
                            }
                        }
                    }
                }
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WordBreak().new Solution();
            List<String> list = new ArrayList<>();
            list.add("life");
            list.add("code");
            assertTrue(sol.wordBreak("codelife", list));
            assertTrue(sol.wordBreak("lifecode", list));
            assertFalse(sol.wordBreak("code-life", list));
        }

        @Test
        public void test2() {
            Solution_2 sol = new WordBreak().new Solution_2();
            List<String> list = new ArrayList<>();
            list.add("cat");
            list.add("cats");
            list.add("sand");
            list.add("and");
            list.add("dog");
            List<String> rslt = sol.wordBreak("catsanddog", list);
            assertEquals(2, rslt.size());
            assertTrue(rslt.get(0).equals("cat sand dog"));
            assertTrue(rslt.get(1).equals("cats and dog"));
        }

        @Test
        public void test3() {
            Solution_3 sol = new WordBreak().new Solution_3();
            List<String> list = new ArrayList<>();
            list.add("cat");
            list.add("cats");
            list.add("sand");
            list.add("and");
            list.add("dog");
            List<String> rslt = sol.wordBreak("catsanddog", list);
            assertEquals(2, rslt.size());
            assertTrue(rslt.get(0).equals("cats and dog"));
            assertTrue(rslt.get(1).equals("cat sand dog"));
        }
    }
}
