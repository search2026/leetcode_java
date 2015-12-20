package substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {

    public class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            HashMap<String, Integer> dict = new HashMap<String, Integer>();
            for (String l : words) {
                Integer count = dict.get(l);
                if (count == null) {
                    dict.put(l, 1);
                } else {
                    dict.put(l, count + 1);
                }
            }
            int wordSize = words[0].length();
            int windowSize = wordSize * words.length;

            ArrayList<Integer> ans = new ArrayList<Integer>();
            for (int i = 0; i <= s.length() - windowSize; i++) {
                HashMap<String, Integer> temp = new HashMap<String, Integer>();
                boolean skip = false;
                for (int j = 0; j < windowSize; j += wordSize) {
                    String word = s.substring(i + j, i + j + wordSize);
                    Integer count = dict.get(word);
                    if (count == null) {
                        skip = true;
                        break;
                    }
                    Integer tempCount = temp.get(word);
                    if (tempCount == null) {
                        temp.put(word, 1);
                    } else if (count == tempCount) {
                        skip = true;
                        break;
                    } else {
                        temp.put(word, tempCount + 1);
                    }
                }
                if (!skip && dict.equals(temp)) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

    public static class UnitTest {
    }
}
