package text_justification;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextJustification {
    /*
        Text Justification
        https://leetcode.com/problems/text-justification/
        leetcode 68
        Difficulty: Hard
     */
    public class Solution {
        public List<String> fullJustify(String[] words, int L) {
            List<String> rslt = new ArrayList<String>();

            int index = 0;
            while (index < words.length) {
                int count = words[index].length();
                int last = index + 1;
                while (last < words.length) {
                    if (words[last].length() + count + 1 > L) break;
                    count += words[last].length() + 1;
                    last++;
                }

                StringBuilder sb = new StringBuilder();
                int diff = last - index - 1;
                // if last line or number of words in the line is 1, left-justified
                if (last == words.length || diff == 0) {
                    for (int i = index; i < last; i++) {
                        sb.append(words[i] + " ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    for (int i = sb.length(); i < L; i++) {
                        sb.append(" ");
                    }
                } else {
                    // middle justified
                    int spaces = (L - count) / diff;
                    int r = (L - count) % diff;
                    for (int i = index; i < last; i++) {
                        sb.append(words[i]);
                        if (i < last - 1) {
                            for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                                sb.append(" ");
                            }
                        }
                    }
                }
                rslt.add(sb.toString());
                index = last;
            }

            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new TextJustification().new Solution();
            assertEquals(7, 7);
        }
    }
}
