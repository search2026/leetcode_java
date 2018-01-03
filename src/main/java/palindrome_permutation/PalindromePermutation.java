package palindrome_permutation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromePermutation {
    /*
        Palindrome Permutation
        Leetcode #266
        https://leetcode.com/discuss/oj/palindrome-permutation
        http://www.cnblogs.com/EdwardLiu/p/5069359.html
        Difficulty: Easy
    */
    public class Solution {
        public boolean canPermutePalindrome(String s) {
            if (s == null || s.length() == 0) return true;
            int n = s.length();
            Map<Character, Integer> map = new HashMap<Character, Integer>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    int count = map.get(c) + 1;
                    map.put(c, count);
                } else {
                    map.put(c, 1);
                }
            }

            int countOdd = 0;
            for (Character c : map.keySet()) {
                if (map.get(c) % 2 != 0) {
                    countOdd++;
                    if (countOdd >= 2) {
                        return false;
                    }
                }
            }

            boolean isLenEven = ((n % 2) == 0);
            if (isLenEven) {
                return (countOdd == 0);
            }

            return (countOdd == 1);
        }
    }

    /*
        Palindrome Permutation II
        Leetcode #267
        https://leetcode.com/discuss/questions/oj/palindrome-permutation-ii
        http://www.cnblogs.com/EdwardLiu/p/5069573.html
        Difficulty: Medium
    */
    public class Solution_2 {
        public List<String> generatePalindromes(String s) {
            List<String> rslt = new ArrayList<String>();
            if (s.length() == 0)
                return rslt;

            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i)))
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                else
                    map.put(s.charAt(i), 1);
            }

            String candidate = "";
            String single = "";
            boolean moreThan2Odds = false;

            for (Character c : map.keySet()) {
                int num = map.get(c) / 2;
                for (int i = 0; i < num; i++)
                    candidate += c;
                if (map.get(c) % 2 != 0) {
                    if (moreThan2Odds)
                        return rslt;
                    else {
                        moreThan2Odds = true;
                        single += c;
                    }
                }
            }

            if (candidate.length() == 0 && single.length() != 0) {
                rslt.add(single);
                return rslt;
            }

            permute("", candidate, single, candidate.length(), rslt);
            return rslt;
        }

        private void permute(String left, String candidate, String single, int l, List<String> rslt) {
            if (left.length() == l) {
                String right = new StringBuffer(left).reverse().toString();
                rslt.add(left + single + right);
            }
            for (int i = 0; i < candidate.length(); i++) {
                if (i > 0 && candidate.charAt(i) == candidate.charAt(i - 1))
                    continue;
                permute(left + candidate.charAt(i), candidate.substring(0, i) + candidate.substring(i + 1), single, l, rslt);
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PalindromePermutation().new Solution();
            assertTrue(sol.canPermutePalindrome("aab"));
            assertFalse(sol.canPermutePalindrome("abc"));
        }
    }
}
