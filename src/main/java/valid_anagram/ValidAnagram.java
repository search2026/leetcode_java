package valid_anagram;

import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidAnagram {
    /*
        Valid Anagram
        Leetcode #242
        https://leetcode.com/problems/valid-anagram/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null || s.length() == 0) {
                return t == null || t.length() == 0;
            }

            if (t == null || t.length() == 0) {
                return s == null || s.length() == 0;
            }

            if (s.length() != t.length()) {
                return false;
            }

            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();

            Arrays.sort(sArr);
            Arrays.sort(tArr);

            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] != tArr[i]) {
                    return false;
                }
            }

            return true;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ValidAnagram().new Solution();
            assertEquals(3, 3);
        }
    }
}
