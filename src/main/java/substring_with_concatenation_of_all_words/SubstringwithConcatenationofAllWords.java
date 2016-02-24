package substring_with_concatenation_of_all_words;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SubstringwithConcatenationofAllWords {
    /*
        Substring with Concatenation of All Words - Hashmap
        https://leetcode.com/problems/substring-with-concatenation-of-all-words/
        Difficulty: Hard
     */
    public class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            ArrayList<Integer> rslt = new ArrayList<Integer>();
            HashMap<String, Integer> target = new HashMap<String, Integer>();
            for (String str : words) {
                if (target.containsKey(str)) {
                    int val = target.get(str);
                    target.put(str, val + 1);
                } else {
                    target.put(str, 1);
                }
            }

            int wSize = words[0].length();
            int lSize = words.length;
            for (int i = 0; i <= s.length() - lSize * wSize; i++) {
                HashMap<String, Integer> cur = new HashMap<String, Integer>();
                for (int j = i; j <= i + lSize * wSize - 1; j = j + wSize) {
                    String temp = s.substring(j, j + wSize);
                    if (!target.containsKey(temp)) break;
                    if (cur.containsKey(temp)) {
                        int value = cur.get(temp);
                        cur.put(temp, value + 1);
                    } else {
                        cur.put(temp, 1);
                    }
                }
                if (cur.equals(target)) {
                    rslt.add(i);
                }
            }
            return rslt;
        }
    }

    /*
    Substring with Concatenation of All Words - Sliding Window
    https://leetcode.com/problems/substring-with-concatenation-of-all-words/
    Difficulty: Hard
 */
    public class Solution_2 {
        public List<Integer> findSubstring(String s, String[] words) {
            HashMap<String, Integer> dict = new HashMap<String, Integer>();
            for (String l : words) {
                Integer count = dict.get(l);
                if (count == null) {
                    dict.put(l, 1);
                } else {
                    dict.put(l, count + 1);
                }
            }
            int wordSize = words[0].length();
            int windowSize = wordSize * words.length;

            ArrayList<Integer> rslt = new ArrayList<Integer>();
            for (int i = 0; i <= s.length() - windowSize; i++) {
                HashMap<String, Integer> cur = new HashMap<String, Integer>();
                boolean skip = false;
                for (int j = 0; j < windowSize; j += wordSize) {
                    String word = s.substring(i + j, i + j + wordSize);
                    Integer count = dict.get(word);
                    if (count == null) {
                        skip = true;
                        break;
                    }
                    Integer tempCount = cur.get(word);
                    if (tempCount == null) {
                        cur.put(word, 1);
                    } else if (count == tempCount) {
                        skip = true;
                        break;
                    } else {
                        cur.put(word, tempCount + 1);
                    }
                }
                if (!skip && dict.equals(cur)) {
                    rslt.add(i);
                }
            }
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SubstringwithConcatenationofAllWords().new Solution();
            String[] words = new String[]{"foo", "bar"};
            List<Integer> rslt = sol.findSubstring("barfoothefoobarman", words);
            assertEquals(0, (int) rslt.get(0));
            assertEquals(9, (int) rslt.get(1));
        }

        @Test
        public void test2() {
            Solution_2 sol = new SubstringwithConcatenationofAllWords().new Solution_2();
            String[] words = new String[]{"foo", "bar"};
            List<Integer> rslt = sol.findSubstring("barfoothefoobarman", words);
            assertEquals(0, (int) rslt.get(0));
            assertEquals(9, (int) rslt.get(1));
        }
    }
}
