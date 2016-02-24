package minimum_window_substring;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MinimumWindowSubstring {
    /*
        Minimum Window Substring - Array
        https://leetcode.com/problems/minimum-window-substring/
        Difficulty: Hard
     */
    public class Solution {
        public String minWindow(String s, String t) {
            int[] runner = new int[256];
            int[] target = new int[256];
            for (int i = 0; i < t.length(); i++) {
                target[(int) t.charAt(i)]++;
            }
            int count = 0;
            int p1 = 0;

            String rslt = "";
            int minWinSize = Integer.MAX_VALUE;
            for (int p2 = 0; p2 < s.length(); p2++) {
                if (target[(int) (s.charAt(p2))] == 0) continue;
                char c = s.charAt(p2);
                runner[(int) c]++;
                if (runner[(int) c] <= target[(int) c]) {
                    count++;
                }
                if (count == t.length()) {
                    while (target[s.charAt(p1)] == 0 || runner[s.charAt(p1)] > target[s.charAt(p1)]) {
                        if (runner[s.charAt(p1)] > target[s.charAt(p1)]) {
                            runner[s.charAt(p1)]--;
                        }
                        p1++;
                    }
                    if (p2 - p1 + 1 < minWinSize) {
                        minWinSize = p2 - p1 + 1;
                        rslt = s.substring(p1, p2 + 1);
                    }
                }
            }
            return rslt;
        }
    }

    /*
        Minimum Window Substring - general template
        https://leetcode.com/problems/minimum-window-substring/
        https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems
        Difficulty: Hard
     */
    public class Solution_2 {
        public String minWindow(String s, String t) {
            int[] map = new int[256];
            for (Character c : t.toCharArray()) map[c]++;
            int counter = t.length(), p1 = 0, p2 = 0, dist = Integer.MAX_VALUE;
            String rslt = "";
            while (p2 < s.length()) {
                if (map[s.charAt(p2++)]-- > 0) counter--;
                while (counter == 0) {
                    if (p2 - p1 < dist) {
                        dist = p2 - p1;
                        rslt = s.substring(p1, p2);
                    }
                    if (map[s.charAt(p1++)]++ == 0) counter++;
                }
            }

            return rslt;
        }
    }

    /*
        Minimum Window Substring - Map
        https://leetcode.com/problems/minimum-window-substring/
        Difficulty: Hard
     */
    public class Solution_3 {
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() < t.length()) return "";
            HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
            HashMap<Character, Integer> rMap = new HashMap<Character, Integer>();
            for (int m = 0; m < t.length(); m++) {
                char c = t.charAt(m);
                if (tMap.containsKey(c)) {
                    tMap.put(c, tMap.get(c) + 1);
                } else tMap.put(c, 1);
            }
            int count = 0;
            int p1 = 0;
            int dist = Integer.MAX_VALUE;
            String minWin = "";
            for (int p2 = 0; p2 < s.length(); p2++) {
                char a = s.charAt(p2);
                if (!tMap.containsKey(a)) continue;

                if (rMap.containsKey(a)) {
                    rMap.put(a, rMap.get(a) + 1);
                } else rMap.put(a, 1);
                if (rMap.get(a) <= tMap.get(a)) count++;

                if (count == t.length()) {
                    while (p1 <= p2) {
                        char c = s.charAt(p1);
                        if (!tMap.containsKey(c)) {
                            p1++;
                            continue;
                        }
                        if (rMap.get(c) <= tMap.get(c)) break;
                        else {
                            rMap.put(c, rMap.get(c) - 1);
                            p1++;
                        }
                    }
                    if (dist > p2 - p1 + 1) {
                        minWin = s.substring(p1, p2 + 1);
                        dist = p2 - p1 + 1;
                    }
                }
            }
            return minWin;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MinimumWindowSubstring().new Solution();
            String s = "ADOBECODEBANC";
            String t = "ABC";
            assertEquals("BANC", sol.minWindow(s, t));
        }

        @Test
        public void test2() {
            Solution_2 sol = new MinimumWindowSubstring().new Solution_2();
            String s = "ADOBECODEBANC";
            String t = "ABC";
            assertEquals("BANC", sol.minWindow(s, t));
        }

        @Test
        public void test3() {
            Solution_3 sol = new MinimumWindowSubstring().new Solution_3();
            String s = "ADOBECODEBANC";
            String t = "ABC";
            assertEquals("BANC", sol.minWindow(s, t));
        }
    }
}
