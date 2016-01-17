package generalized_abbreviation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    /*
        Generalized Abbreviation
        https://segmentfault.com/a/1190000004187690
        Difficulty: Medium
     */
    public class Solution {
        public void search(List<String> rslt, String cur, int start, String word) {
            if (start > word.length())
                return;

            rslt.add(cur + word.substring(start));

            int i = 0;
            if (start > 0) {
                i = start + 1;
            }

            for (; i < word.length(); i++) {
                for (int j = 1; j <= word.length(); j++) {
                    search(rslt, cur + word.substring(start, i) + j, i + j, word);
                }
            }
        }

        public List<String> generateAbbreviations(String word) {
            List<String> rslt = new ArrayList<String>();
            search(rslt, "", 0, word);
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new GeneralizedAbbreviation().new Solution();
        }
    }
}

