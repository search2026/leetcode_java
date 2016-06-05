package word_break;

import org.junit.Test;

import java.util.*;

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
            assert !s.isEmpty();
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                dp[i] = false;
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
        Word Break II - Backtracking
        Leetcode #140
        https://leetcode.com/problems/word-break-ii/
        Difficulty: Hard
     */
    public class Solution_2 {
        private List<String> search(String s, int start, Set<String> dict, HashMap<Integer, List<String>> map) {
            if (map.containsKey(start)) return map.get(start);

            List<String> rslt = new ArrayList<String>();
            if (start == s.length()) {
                rslt.add("");
                return rslt;
            }

            String cur = s.substring(start);
            for (String word : dict) {
                if (cur.startsWith(word)) {
                    List<String> sublist = search(s, start + word.length(), dict, map);
                    for (String sub : sublist) {
                        rslt.add(word + (sub.isEmpty() ? "" : " ") + sub);
                    }
                }
            }

            map.put(start, rslt);
            return rslt;
        }

        public List<String> wordBreak(String s, Set<String> wordDict) {
            return search(s, 0, wordDict, new HashMap<Integer, List<String>>());
        }
    }

    /*
        Word Break II - Dynamic Programming
        https://leetcode.com/problems/word-break-ii/
        Difficulty: Hard
     */
    public class Solution_3 {
        public void search(List<String> rslt, List<Integer>[] pointer, String s, int i, String pattern) {
            if (i < 0) {
                rslt.add(pattern);
                return;
            }
            for (Integer item : pointer[i]) {
                String next = pattern.length() == 0 ? s.substring(item, i + 1) : s.substring(item, i + 1) + " " + pattern;
                search(rslt, pointer, s, item - 1, next);
            }
        }

        public List<String> wordBreak(String s, Set<String> wordDict) {
            List<String> rslt = new ArrayList<String>();
            int n = s.length();
            List<Integer>[] pointer = new ArrayList[n];
            //List<List<Integer>> dp = new ArrayList<List<Integer>>();
            for (int i = 0; i < n; i++) pointer[i] = new ArrayList<Integer>();
            //DP to record break point
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (wordDict.contains(s.substring(j, i + 1)) && (j == 0 || pointer[j - 1].size() > 0))
                        pointer[i].add(j);
                }
            }
            search(rslt, pointer, s, n - 1, "");
            return rslt;
        }
    }

    /*
        Word Break II - Dynamic Programming + Trie
        https://leetcode.com/problems/word-break-ii/
        Difficulty: Hard
     */
    public class Solution_4 {
        public List<String> wordBreak(String s, Set<String> wordDict) {
            Trie trie = new Trie();
            for (String word : wordDict) trie.put(word);
            List<String> res = new ArrayList<String>();
            List[] dp = new List[s.length()]; // store all the possible legal results of the substring of s starts from index i
            char[] c = s.toCharArray();
            getDP(c, 0, trie, dp);
            for (StringBuilder sb : (List<StringBuilder>) dp[0]) res.add(sb.toString());
            return res;
        }

        // get dp[start]
        private List<StringBuilder> getDP(char[] c, int start, Trie trie, List[] dp) {
            List<Integer> ends = trie.getLegalEnds(c, start);// get all legal end indices starts from index "start"
            dp[start] = new ArrayList<StringBuilder>();
            for (int end : ends) {
                if (end == c.length - 1) dp[start].add(new StringBuilder().append(c, start, end - start + 1));
                else {
                    if (dp[end + 1] == null)
                        dp[end + 1] = getDP(c, end + 1, trie, dp);// if don't have dp[i], get it first
                    for (StringBuilder sb : (List<StringBuilder>) dp[end + 1]) // combine
                        dp[start].add(new StringBuilder().append(c, start, end - start + 1).append(" ").append(sb));
                }
            }
            return dp[start];
        }

        //trie implementation with a little adjustment
        private class Trie {
            private class Node {
                boolean exist = false;
                Node[] next = new Node[26];
            }

            Node root = new Node();

            private void put(String word) {
                put(word, root, 0);
            }

            private Node put(String word, Node root, int p) {
                if (root == null) root = new Node();
                if (p == word.length()) {
                    root.exist = true;
                    return root;
                }
                root.next[word.charAt(p) - 'a'] = put(word, root.next[word.charAt(p) - 'a'], p + 1);
                return root;
            }

            private List<Integer> getLegalEnds(char[] c, int start) {
                List<Integer> res = new ArrayList<Integer>();
                get(c, root, start, res);
                return res;
            }

            private void get(char[] c, Node root, int p, List<Integer> res) {
                if (root == null) return;
                if (root.exist) res.add(p - 1);
                if (p == c.length) return;
                get(c, root.next[c[p] - 'a'], p + 1, res);
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WordBreak().new Solution();
            Set<String> dict = new HashSet<String>();
            dict.add("life");
            dict.add("code");
            assertTrue(sol.wordBreak("codelife", dict));
            assertTrue(sol.wordBreak("lifecode", dict));
            assertFalse(sol.wordBreak("code-life", dict));
        }

        @Test
        public void test2() {
            Solution_2 sol = new WordBreak().new Solution_2();
            Set<String> dict = new HashSet<String>();
            dict.add("cat");
            dict.add("cats");
            dict.add("sand");
            dict.add("and");
            dict.add("dog");
            List<String> rslt = sol.wordBreak("catsanddog", dict);
            assertTrue(rslt.get(0).equals("cats and dog"));
            assertTrue(rslt.get(1).equals("cat sand dog"));
        }

        @Test
        public void test3() {
            Solution_3 sol = new WordBreak().new Solution_3();
            Set<String> dict = new HashSet<String>();
            dict.add("cat");
            dict.add("cats");
            dict.add("sand");
            dict.add("and");
            dict.add("dog");
            List<String> rslt = sol.wordBreak("catsanddog", dict);
            assertTrue(rslt.get(1).equals("cats and dog"));
            assertTrue(rslt.get(0).equals("cat sand dog"));
        }


        @Test
        public void test4() {
            Solution_4 sol = new WordBreak().new Solution_4();
            Set<String> dict = new HashSet<String>();
            dict.add("cat");
            dict.add("cats");
            dict.add("sand");
            dict.add("and");
            dict.add("dog");
            List<String> rslt = sol.wordBreak("catsanddog", dict);
            assertTrue(rslt.get(1).equals("cats and dog"));
            assertTrue(rslt.get(0).equals("cat sand dog"));
        }
    }
}
