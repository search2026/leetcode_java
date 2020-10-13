package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {

    /*
        Generalized Abbreviation
        Leetcode #320
        https://github.com/search2026/leetcode_java/blob/master/resources/GeneralizedAbbreviation.md
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

}
