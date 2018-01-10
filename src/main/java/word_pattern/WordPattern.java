package word_pattern;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class WordPattern {
    /*
        Word Pattern
        Leetcode #290
        https://leetcode.com/problems/word-pattern/
        Difficulty: Easy
    */
    public class Solution {
        public boolean wordPattern(String pattern, String str) {
            if (pattern == null || str == null) return false;
            String[] words = str.split(" ");
            if (pattern.length() != words.length) return false;

            Map<Character, String> map = new HashMap<Character, String>();
            for (int i = 0; i < pattern.length(); i++) {
                if (!map.containsKey(pattern.charAt(i))) {
                    if (map.values().contains(words[i])) return false;
                    map.put(pattern.charAt(i), words[i]);
                } else if (!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    /*
        Word Pattern II
        Leetcode #291
        https://leetcode.com/discuss/questions/oj/word-pattern-ii
        http://www.cnblogs.com/EdwardLiu/p/5081358.html
        Difficulty: Medium
    */
    public class Solution_2 {
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();

        public boolean search(String pattern, String str, int i, int j) {
            if (i == pattern.length() && j == str.length()) return true;
            if (i == pattern.length() || j == str.length()) return false;

            char key = pattern.charAt(i);
            for (int cut = j + 1; cut <= str.length(); cut++) {
                String cur = str.substring(j, cut);
                if (!map.containsKey(key) && !set.contains(cur)) {
                    map.put(key, cur);
                    set.add(cur);
                    if (search(pattern, str, i + 1, cut))
                        return true;
                    map.remove(key);
                    set.remove(cur);
                } else if (map.containsKey(key) && map.get(key).equals(cur)) {
                    if (search(pattern, str, i + 1, cut))
                        return true;
                }
            }
            return false;
        }

        public boolean wordPatternMatch(String pattern, String str) {
            if (pattern == null || str == null) return false;
            return search(pattern, str, 0, 0);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WordPattern().new Solution();
            assertTrue(true);
        }
    }
}
