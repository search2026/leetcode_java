package find_all_anagrams_in_a_string;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindAllAnagramsinaString {
    /*
        Find All Anagrams in a String - Substring template
        Leetcode #438
        https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
        Difficulty: Easy
     */
    public class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;
            int[] map = new int[256];
            for (int i = 0; i < p.length(); i++) map[p.charAt(i)]++;

            int diff = p.length();
            for (int left = 0, right = 0; right < s.length(); right++) {
                if (map[s.charAt(right)]-- > 0) diff--;
                while (diff == 0) {
                    if (right - left + 1 == p.length()) {
                        res.add(left);
                    }
                    if (++map[s.charAt(left++)] > 0) diff++;
                }
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FindAllAnagramsinaString().new Solution();
            List<Integer> res = sol.findAnagrams("cbaebabacd", "abc");
            assertEquals(2, res.size());
            assertEquals(0, (int) res.get(0));
            assertEquals(6, (int) res.get(1));

            res = sol.findAnagrams("abab", "ab");
            assertEquals(3, res.size());
            assertEquals(0, (int) res.get(0));
            assertEquals(1, (int) res.get(1));
            assertEquals(2, (int) res.get(2));
        }
    }
}

