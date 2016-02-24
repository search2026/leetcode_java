package group_shifted_strings;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class GroupShiftedStrings {
    /*
        Group Shifted Strings
        http://buttercola.blogspot.com/2015/08/leetcode-group-shifted-strings.html
        Difficulty: Easy
     */
    public class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            List<List<String>> result = new ArrayList<List<String>>();
            if (strings == null || strings.length == 0) {
                return result;
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
                result.add((List<String>) pair.getValue());
            }

            return result;
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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new GroupShiftedStrings().new Solution();
            assertEquals(3, 3);
        }
    }
}
