package text_justification;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextJustification {
    /*
        Text Justification
        Leetcode #68
        https://leetcode.com/problems/text-justification/
        Difficulty: Hard
     */
    public class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<>();

            int index = 0;
            while (index < words.length) {
                int count = words[index].length();
                int last = index + 1;
                while (last < words.length) {
                    if (words[last].length() + count + 1 > maxWidth) break;
                    count += words[last].length() + 1;
                    last++;
                }

                StringBuilder sb = new StringBuilder();
                int diff = last - index - 1;
                // if last line or number of words in the line is 1, left-justified
                if (last == words.length || diff == 0) {
                    for (int i = index; i < last; i++) {
                        sb.append(words[i]).append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    for (int i = sb.length(); i < maxWidth; i++) {
                        sb.append(" ");
                    }
                } else {
                    // middle justified
                    int spaces = (maxWidth - count) / diff;
                    int r = (maxWidth - count) % diff;
                    for (int i = index; i < last; i++) {
                        sb.append(words[i]);
                        if (i < last - 1) {
                            for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                                sb.append(" ");
                            }
                        }
                    }
                }
                res.add(sb.toString());
                index = last;
            }

            return res;
        }
    }

    /*
        Text Justification
        Leetcode #68
        https://leetcode.com/problems/text-justification/
        Difficulty: Hard
     */
    public class Solution_2 {
        //   0   1  2    3
        // "This is an example..."
        //  i=0, j=3, width=8, space=(16-8)/(3-0-1)=4, extra=0
        // ------------------------------------------------------
        //   3      4   5        6
        // "example of text justification."
        //  i=3, j=6, width=13, space=(16-13)/(3-0-1)=1, extra=1
        // ------------------------------------------------------
        // "justification."
        //  i=6, j=7, space=1, extra=0
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<>();
            for (int i = 0, j; i < words.length; ) {
                int width = 0;                                  // width of words without space
                for (j = i; j < words.length && width + words[j].length() + (j - i) <= maxWidth; j++)
                    width += words[j].length();                 /* j is the next word */

                int space = 1, extra = 0;                       // for last line, space=1
                if (j - i != 1 && j != words.length) {          // not 1 word (div-by-zero) and not last line
                    space = (maxWidth - width) / (j - i - 1);   // minus 1 to exclude skip last word
                    extra = (maxWidth - width) % (j - i - 1);
                }

                StringBuilder sb = new StringBuilder(words[i]);
                for (i = i + 1; i < j; i++) {                   // move i to j finally
                    for (int s = space; s > 0; s--) sb.append(" ");
                    if (extra-- > 0) sb.append(" ");
                    sb.append(words[i]);
                }
                for (int s = maxWidth - sb.length(); s > 0; s--) sb.append(" ");
                res.add(sb.toString());
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new TextJustification().new Solution();
            String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
            List<String> res = sol.fullJustify(words, 16);
            assertEquals(3, res.size());
            assertEquals(res.get(0), "This    is    an");
            assertEquals(res.get(1), "example  of text");
            assertEquals(res.get(2), "justification.  ");
        }

        @Test
        public void test2() {
            Solution_2 sol = new TextJustification().new Solution_2();
            String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
            List<String> res = sol.fullJustify(words, 16);
            assertEquals(3, res.size());
            assertEquals(res.get(0), "This    is    an");
            assertEquals(res.get(1), "example  of text");
            assertEquals(res.get(2), "justification.  ");
        }
    }
}
