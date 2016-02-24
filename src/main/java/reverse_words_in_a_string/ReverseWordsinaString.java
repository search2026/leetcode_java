package reverse_words_in_a_string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWordsinaString {
    /*
        Reverse Words in a String
        https://leetcode.com/problems/reverse-nodes-in-k-group/
        leetcode 25
        Difficulty: Hard
     */
    public class Solution {
        public String reverseWords(String s) {
            String[] tokens = s.split(" +");
            StringBuilder r = new StringBuilder();
            boolean isFirst = true;
            for (int i = tokens.length - 1; i >= 0; i--) {
                String token = tokens[i];
                if (token.isEmpty()) {
                    continue;
                }
                if (isFirst) {
                    isFirst = false;
                } else {
                    r.append(' ');
                }
                r.append(token);
            }
            return r.toString();
        }

        public void reverseWordsInplace(char[] s) {
            reverse(s, 0, s.length);
            for (int i=0, j=0; j<=s.length; j++) {
                if (j==s.length || s[j]==' ') {
                    reverse(s, i, j);
                    i =  j + 1;
                }
            }
        }

        private void reverse(char [] s, int begin, int end) {
            for (int i=0; i<(end-begin)/2; i++) {
                char temp = s[begin+i];
                s[begin+i] = s[end-i-1];
                s[end-i-1] = temp;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ReverseWordsinaString().new Solution();
            assertEquals(7, 7);
        }
    }
}
