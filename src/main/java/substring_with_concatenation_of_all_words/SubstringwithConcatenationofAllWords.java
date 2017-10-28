package substring_with_concatenation_of_all_words;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SubstringwithConcatenationofAllWords {
    /*
        Substring with Concatenation of All Words - Sliding Window (Timeout)
        Leetcode #30
        https://leetcode.com/problems/substring-with-concatenation-of-all-words/
        Difficulty: Hard
     */
    public class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || words == null || words.length == 0) {
                return res;
            }

            Map<String, Integer> dict = new HashMap<>();
            for (String word : words) {
                dict.put(word, dict.getOrDefault(word, 0) + 1);
            }

            int wordLen = words[0].length();
            int windSize = wordLen * words.length;
            for (int i = 0; i <= s.length() - windSize; i++) {
                HashMap<String, Integer> cur = new HashMap<>();
                boolean skip = false;
                for (int j = 0; j < windSize; j += wordLen) {
                    String word = s.substring(i + j, i + j + wordLen);
                    Integer count = dict.get(word);
                    if (count == null) {
                        skip = true;
                        break;
                    }
                    Integer currCount = cur.get(word);
                    if (currCount == null) {
                        cur.put(word, 1);
                    } else if (count.equals(currCount)) {
                        skip = true;
                        break;
                    } else {
                        cur.put(word, currCount + 1);
                    }
                }
                if (!skip && dict.equals(cur)) {
                    res.add(i);
                }
            }
            return res;
        }
    }

    /*
        Substring with Concatenation of All Words - Sliding Window with extra tables
        Leetcode #30
        https://leetcode.com/problems/substring-with-concatenation-of-all-words/
        Difficulty: Hard
     */
    public class Solution_2 {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<Integer>(s.length());
            if (s == null || s.length() == 0 || words == null || words.length == 0) {
                return res;
            }

            int sLen = s.length();
            int wordLen = words[0].length();
            if (sLen < wordLen * words.length) {
                return res;
            }
            int last = sLen - wordLen + 1;

            Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
            int[][] table = new int[2][words.length];
            int failures = 0, index = 0;
            for (int i = 0; i < words.length; ++i) {
                Integer mapped = mapping.get(words[i]);
                if (mapped == null) {
                    failures++;
                    mapping.put(words[i], index);
                    mapped = index++;
                }
                table[0][mapped]++;
            }

            int[] smapping = new int[last];
            for (int i = 0; i < last; ++i) {
                String section = s.substring(i, i + wordLen);
                Integer mapped = mapping.get(section);
                if (mapped == null) {
                    smapping[i] = -1;
                } else {
                    smapping[i] = mapped;
                }
            }

            for (int i = 0; i < wordLen; ++i) {
                int currentFailures = failures; //number of current mismatches
                int left = i, right = i;
                Arrays.fill(table[1], 0);
                while (right < last) {
                    while (currentFailures > 0 && right < last) {
                        int target = smapping[right];
                        if (target != -1 && ++table[1][target] == table[0][target]) {
                            currentFailures--;
                        }
                        right += wordLen;
                    }
                    while (currentFailures == 0 && left < right) {
                        int target = smapping[left];
                        if (target != -1 && --table[1][target] == table[0][target] - 1) {
                            int length = right - left;
                            if ((length / wordLen) == words.length) {
                                res.add(left);
                            }
                            currentFailures++;
                        }
                        left += wordLen;
                    }
                }
            }
            return res;
        }
    }


    /*
        Substring with Concatenation of All Words - Template
        Leetcode #30
        https://leetcode.com/problems/substring-with-concatenation-of-all-words/
        Difficulty: Hard
     */
    public class Solution_3 {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || words == null || words.length == 0) {
                return res;
            }
            int windSize = words.length, wordLen = words[0].length();
            Map<String, Integer> map = new HashMap<>();
            for (String w : words) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
            for (int i = 0; i <= s.length() - wordLen * windSize; i++) {
                Map<String, Integer> cur = new HashMap<>(map);
                for (int j = 0; j < windSize; j++) {
                    String str = s.substring(i + j * wordLen, i + j * wordLen + wordLen);
                    if (!cur.containsKey(str)) {
                        break;
                    }
                    cur.put(str, cur.get(str) - 1);
                    if (cur.get(str) == 0) {
                        cur.remove(str);
                    }
                    if (cur.isEmpty()) {
                        res.add(i);
                    }
                }
            }
            return res;
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

        @Test
        public void test3() {
            Solution_3 sol = new SubstringwithConcatenationofAllWords().new Solution_3();
            String[] words = new String[]{"foo", "bar"};
            List<Integer> rslt = sol.findSubstring("barfoothefoobarman", words);
            assertEquals(0, (int) rslt.get(0));
            assertEquals(9, (int) rslt.get(1));
        }
    }
}
