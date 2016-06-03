package isomorphic_strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IsomorphicStrings {
    /*
        Isomorphic Strings
        Leetcode #205
        https://leetcode.com/problems/isomorphic-strings/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> mapping = new HashMap<Character, Character>();
            Set<Character> mapped = new HashSet<Character>();
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                if (mapping.containsKey(c1)) {
                    if (mapping.get(c1) != c2) {
                        return false;
                    }
                } else {
                    if (mapped.contains(c2)) {
                        return false;
                    }
                    mapped.add(c2);
                    mapping.put(c1, c2);
                }
            }
            return true;
        }
    }


    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new IsomorphicStrings().new Solution();
            assertEquals(3, 3);
        }
    }
}

