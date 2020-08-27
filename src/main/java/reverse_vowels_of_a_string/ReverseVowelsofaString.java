package reverse_vowels_of_a_string;

import java.util.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseVowelsofaString {
    /*
        Reverse Vowels of a String
        leetcode #345
        https://leetcode.com/problems/reverse-vowels-of-a-string/
        Difficulty: Easy
     */
    public class Solution {
        private final Set<Character> VOWELS = new HashSet<Character>() {{
            add('a');
            add('o');
            add('i');
            add('u');
            add('e');
            add('A');
            add('O');
            add('I');
            add('U');
            add('E');
        }};

        public String reverseVowels(String s) {
            if (s == null || s.length() == 0) return "";
            int n = s.length();
            if (n == 1) return s;
            char[] sChars = s.toCharArray();
            int p1 = 0, p2 = n-1;
            while (p1 < p2) {
                while (p1 < p2 && !VOWELS.contains(sChars[p1])) {
                    p1++;
                }
                while (p1 < p2 && !VOWELS.contains(sChars[p2]))  {
                    p2--;
                }
                if (p1 >= p2) break;
                char t = sChars[p1];
                sChars[p1] = sChars[p2];
                sChars[p2] = t;
                p1++;
                p2--;
            }

            return new String(sChars);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ReverseVowelsofaString().new Solution();
            assertTrue(sol.reverseVowels("").equals(""));
            assertTrue(sol.reverseVowels(null).equals(""));
            assertTrue(sol.reverseVowels("s").equals("s"));
            assertTrue(sol.reverseVowels("e").equals("e"));
            assertEquals("holle", sol.reverseVowels("hello"));
            assertTrue(sol.reverseVowels("leotcede").equals("leetcode"));
            assertTrue(sol.reverseVowels("abcccd").equals("abcccd"));
        }        
    }
}

