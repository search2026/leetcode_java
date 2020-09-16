package com.search2026.leetcode.problems;

import java.util.*;

public class GroupAnagrams {

    /*
        Group Anagrams
        Leetcode #49
        https://leetcode.com/problems/anagrams/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            if (strs == null || strs.length == 0)
                return res;
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] charArr = s.toCharArray();
                Arrays.sort(charArr);
                String str = new String(charArr);
                if (map.containsKey(str)) {
                    map.get(str).add(s);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(s);
                    map.put(str, list);
                }
            }
            for (ArrayList<String> item : map.values()) {
                Collections.sort(item);
                res.add(item);
            }
            return res;
        }
    }

}
