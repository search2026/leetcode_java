package one_edit_distance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OneEditDistance {
    /*
        One Edit Distance
        http://www.cnblogs.com/EdwardLiu/p/4245378.html
        leetcode 161
        Difficulty: Medium
     */
    public class Solution {
        public boolean isOneEditDistance(String s, String t) {
            int m = s.length(), n = t.length();
            if (m > n) return isOneEditDistance(t, s);
            if (n - m > 1) return false;
            int i = 0, shift = n - m;
            while (i < m && s.charAt(i) == t.charAt(i)) ++i;
            // if two string are the same (shift==0), return false
            if (i == m) return shift > 0;
            // if n==m skip current char in s (modify operation in s)
            if (shift == 0) i++;
            // use shift to skip one char in t
            while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
            return i == m;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new OneEditDistance().new Solution();
            assertEquals(1, 1);
        }
    }
}
