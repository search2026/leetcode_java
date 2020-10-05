package com.search2026.leetcode.problems;

import java.util.*;

public class GroupShiftedStrings {

    /*
        Group Shifted Strings
        Leetcode #249
        https://leetcode.com/discuss/questions/oj/group-shifted-strings
        http://buttercola.blogspot.com/2015/08/leetcode-group-shifted-strings.html
        Difficulty: Easy
     */
    public class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            List<List<String>> res = new ArrayList<>();
            if (strings == null || strings.length == 0) {
                return res;
            }

            Arrays.sort(strings, new LexComparator());

            Map<String, List<String>> map = new HashMap<String, List<String>>();

            for (String s : strings) {
                StringBuffer sb = new StringBuffer();
                int distance = Character.getNumericValue(s.charAt(0)) - 'a';
                for (int i = 0; i < s.length(); i++) {
                    int val = Character.getNumericValue(s.charAt(i)) - distance;
                    val = val < 'a' ? val + 26 : val;
                    char ori = (char) val;
                    sb.append(ori);
                }
                String original = sb.toString();
                if (map.containsKey(original)) {
                    List<String> list = map.get(original);
                    list.add(s);
                    map.put(original, list);
                } else {
                    List<String> list = new ArrayList<String>();
                    list.add(s);
                    map.put(original, list);
                }
            }

            // Iterate the map
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                res.add((List<String>) pair.getValue());
            }

            return res;
        }

        private class LexComparator implements Comparator<String> {
            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                }

                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        return a.charAt(i) - b.charAt(i);
                    }
                }
                return 0;
            }
        }
    }

}
