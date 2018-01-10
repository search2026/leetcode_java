package length_of_last_word;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthofLastWord {
    /*
        Length of Last Word
        https://leetcode.com/problems/length-of-last-word/
        leetcode 58
        Difficulty: Easy
     */
    public class Solution {
        public int lengthOfLastWord(String s) {
            int i = s.length() - 1;
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) {
                return 0;
            }
            int len = 0;
            while (i >= 0 && s.charAt(i) != ' ') {
                len++;
                i--;
            }
            return len;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LengthofLastWord().new Solution();
            assertEquals(3, 3);
        }
    }
}
