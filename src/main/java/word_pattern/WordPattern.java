package word_pattern;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    // Word Pattern
    // http://buttercola.blogspot.com/2015/10/leetcode-word-pattern.html
    // Difficulty: Easy
    public class Solution {
        public boolean wordPattern(String pattern, String str) {
            if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
                return false;
            }

            String[] tokens = str.split(" ");

            if (pattern.length() != tokens.length) {
                return false;
            }

            Map<String, Character> inverseMap = new HashMap<>();
            Map<Character, String> map = new HashMap<Character, String>();

            int i = 0;
            for (i = 0; i < pattern.length(); i++) {
                char digit = pattern.charAt(i);

                String token = tokens[i];

                // Check the one-one mapping
                if (!map.containsKey(digit) && !inverseMap.containsKey(token)) {
                    map.put(digit, token);
                    inverseMap.put(token, digit);
                } else if (map.containsKey(digit) && inverseMap.containsKey(token)) {
                    String token1 = map.get(digit);
                    char digit1 = inverseMap.get(token);

                    if (!token1.equals(token) || digit != digit1) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            return true;
        }
    }

    // Word Pattern II
    // http://buttercola.blogspot.com/2015/10/leetcode-word-pattern-ii.html
    // Difficulty: Medium
    public class SolutionII {
        public boolean wordPatternMatch(String pattern, String str) {
            if (str == null || str.length() == 0) {
                return pattern == null || pattern.length() == 0;
            }

            if (pattern == null || pattern.length() == 0) {
                return str == null || str.length() == 0;
            }

            int len = pattern.length();

            Map<String, Character> map = new HashMap<>();
            Map<Character, String> invertedMap = new HashMap<>();

            return wordPatternMatchHelper(0, 0, pattern, str, map, invertedMap);
        }

        private boolean wordPatternMatchHelper(int start, int seg, String pattern,
                                               String str,
                                               Map<String, Character> map,
                                               Map<Character, String> invertedMap) {
            if (start == str.length() && seg == pattern.length()) {
                return true;
            }

            if (start >= str.length() || seg >= pattern.length()) {
                return false;
            }

            char c = pattern.charAt(seg);
            for (int i = start; i < str.length(); i++) {
                String substr = str.substring(start, i + 1);

                if (map.containsKey(substr) &&
                        invertedMap.containsKey(c) &&
                        map.get(substr) == c &&
                        invertedMap.get(c).equals(substr)) {
                    if (wordPatternMatchHelper(i + 1, seg + 1, pattern,
                            str, map, invertedMap)) {
                        return true;
                    }
                }

                if (!map.containsKey(substr) && !invertedMap.containsKey(c)) {
                    map.put(substr, c);
                    invertedMap.put(c, substr);

                    if (wordPatternMatchHelper(i + 1, seg + 1, pattern,
                            str, map, invertedMap)) {
                        return true;
                    }

                    map.remove(substr);
                    invertedMap.remove(c);
                }
            }

            return false;
        }
    }

    public static class UnitTest {

    }
}
