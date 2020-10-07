package com.search2026.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation {

    /*
        Unique Word Abbreviation
        Leetcode #288
        https://leetcode.com/discuss/questions/oj/unique-word-abbreviation
        http://buttercola.blogspot.com/2015/10/leetcode-unique-word-abbreviation.html
        Difficulty: Medium
     */
    public class ValidWordAbbr {
        private Set<String> uniqueDict;
        private Map<String, String> abbrDict;

        public ValidWordAbbr(String[] dictionary) {
            uniqueDict = new HashSet<String>();
            abbrDict = new HashMap<String, String>();

            for (String word : dictionary) {
                if (!uniqueDict.contains(word)) {
                    String abbr = getAbbr(word);
                    if (!abbrDict.containsKey(abbr)) {
                        abbrDict.put(abbr, word);
                    } else {
                        abbrDict.put(abbr, "");
                    }

                    uniqueDict.add(word);
                }
            }
        }

        public boolean isUnique(String word) {
            if (word == null || word.length() == 0) {
                return true;
            }

            String abbr = getAbbr(word);
            return !abbrDict.containsKey(abbr) || abbrDict.get(abbr).equals(word);
        }

        private String getAbbr(String word) {
            if (word == null || word.length() < 3) {
                return word;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(0));
            sb.append(word.length() - 2);
            sb.append(word.charAt(word.length() - 1));

            return sb.toString();
        }
    }

}
