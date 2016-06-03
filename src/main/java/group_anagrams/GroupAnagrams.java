package group_anagrams;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class GroupAnagrams {
    /*
        Group Anagrams
        Leetcode #49
        https://leetcode.com/problems/anagrams/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<List<String>>();
            if (strs == null || strs.length == 0)
                return res;
            HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
            for (int i = 0; i < strs.length; i++) {
                char[] charArr = strs[i].toCharArray();
                Arrays.sort(charArr);
                String str = new String(charArr);
                if (map.containsKey(str)) {
                    map.get(str).add(strs[i]);
                } else {
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(strs[i]);
                    map.put(str, list);
                }
            }//for i
            Iterator iter = map.values().iterator();
            while (iter.hasNext()) {
                ArrayList<String> item = (ArrayList<String>) iter.next();
                Collections.sort(item);
                res.add(item);
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new GroupAnagrams().new Solution();
            assertEquals(3, 3);
        }
    }
} 
