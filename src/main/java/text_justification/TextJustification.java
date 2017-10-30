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
        public List<String> fullJustify(String[] words, int L) {
            List<String> res = new ArrayList<>();

            int index = 0;
            while (index < words.length) {
                int count = words[index].length();
                int last = index + 1;
                while (last < words.length) {
                    if (words[last].length() + count + 1 > L) break;
                    count += words[last].length() + 1;
                    last++;
                }

                StringBuilder builder = new StringBuilder();
                int diff = last - index - 1;
                // if last line or number of words in the line is 1, left-justified
                if (last == words.length || diff == 0) {
                    for (int i = index; i < last; i++) {
                        builder.append(words[i] + " ");
                    }
                    builder.deleteCharAt(builder.length() - 1);
                    for (int i = builder.length(); i < L; i++) {
                        builder.append(" ");
                    }
                } else {
                    // middle justified
                    int spaces = (L - count) / diff;
                    int r = (L - count) % diff;
                    for (int i = index; i < last; i++) {
                        builder.append(words[i]);
                        if (i < last - 1) {
                            for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                                builder.append(" ");
                            }
                        }
                    }
                }
                res.add(builder.toString());
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
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<>();
            char[] spaces = new char[maxWidth];
            for (int i = 0; i < maxWidth; i++) {
                spaces[i] = ' ';
            }
            for (int start = 0; start < words.length; ) {
                int len = words[start].length();
                int end = start + 1;
                for (; end < words.length && len + 1 + words[end].length() <= maxWidth; end++) {
                    len += 1 + words[end].length();
                }
                StringBuilder newStr = new StringBuilder(maxWidth);
                newStr.append(words[start]);
                int slotNum = end - start - 1;
                start++;
                if (end != words.length && slotNum != 0) {
                    int evenNum = (maxWidth - (len - slotNum)) / slotNum;
                    int leftNum = (maxWidth - (len - slotNum)) % slotNum;
                    while (start < end) {
                        newStr.append(spaces, 0, evenNum);
                        if (leftNum > 0) {
                            newStr.append(' ');
                            leftNum--;
                        }
                        newStr.append(words[start]);
                        start++;
                    }
                } else {
                    while (start < end) {
                        newStr.append(' ');
                        newStr.append(words[start]);
                        start++;
                    }
                    newStr.append(spaces, 0, maxWidth - newStr.length());
                }

                res.add(newStr.toString());
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
