package generalized_abbreviation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneralizedAbbreviation {
    /*
        Generalized Abbreviation
        Leetcode #320
        https://leetcode.com/discuss/questions/oj/generalized-abbreviation?sort=votes
        https://segmentfault.com/a/1190000004187690
        Difficulty: Medium
     */
    public class Solution {
        public void search(List<String> res, String curr, int start, String word) {
            if (start > word.length())
                return;

            res.add(curr + word.substring(start));

            int i = 0;
            if (start > 0) {
                i = start + 1;
            }

            for (; i < word.length(); i++) {
                for (int j = 1; j <= word.length(); j++) {
                    search(res, curr + word.substring(start, i) + j, i + j, word);
                }
            }
        }

        public List<String> generateAbbreviations(String word) {
            List<String> res = new ArrayList<>();
            search(res, "", 0, word);
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new GeneralizedAbbreviation().new Solution();
            assertEquals(3, 3);
        }
    }
}

