package longest_substring_with_at_most_k_distinct_characters;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LongestSubstringwithAtMostKDistinctCharacters {
    /*
        Longest Substring with At Most K Distinct Characters
        https://codesolutiony.wordpress.com/2015/05/22/lintcode-longest-substring-with-at-most-k-distinct-characters/
        Difficulty: Hard
     */
    public class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (s == null || s.length() == 0 || k <= 0) return 0;

            int start = 0;
            int rslt = 1;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            map.put(s.charAt(0), 1);
            for (int end = 1; end < s.length(); end++) {
                char ch = s.charAt(end);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    if (map.size() == k) {
                        rslt = Math.max(rslt, end - start);
                        //full map, need to remove the first character in ths substring
                        for (int index = start; index < end; index++) {
                            map.put(s.charAt(index), map.get(s.charAt(index)) - 1);
                            start++;
                            if (map.get(s.charAt(index)) == 0) {
                                //have removed all occurrence of a char
                                map.remove(s.charAt(index));
                                break;
                            }
                        }
                    }
                    map.put(ch, 1);
                }
            }
            rslt = Math.max(rslt, s.length() - start);
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LongestSubstringwithAtMostKDistinctCharacters().new Solution();
            assertEquals(3, sol.lengthOfLongestSubstringKDistinct("eceba", 2));
            assertEquals(4, sol.lengthOfLongestSubstringKDistinct("eceba", 3));
        }
    }
}

