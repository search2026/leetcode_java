package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    /*
        Encode and Decode Strings
        Leetcode #271
        https://leetcode.com/discuss/questions/oj/encode-and-decode-strings?sort=votes
        http://buttercola.blogspot.com/2015/09/leetcode-encode-and-decode-strings.html
        Difficulty: Medium
     */
    public class Solution {
        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            if (strs == null || strs.size() == 0) {
                return "";
            }

            StringBuilder sb = new StringBuilder();

            for (String str : strs) {
                int len = str == null ? 0 : str.length();
                sb.append(len);
                sb.append('#');
                sb.append(str);
            }

            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> res = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return res;
            }

            int i = 0;
            while (i < s.length()) {
                int len = 0;
                // Get length
                while (i < s.length() && s.charAt(i) != '#') {
                    len = len * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }

                String str = s.substring(i + 1, i + len + 1);
                res.add(str);
                i = i + len + 1;
            }

            return res;
        }
    }

}
