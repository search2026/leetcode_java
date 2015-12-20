package shortest_palindrome;

public class ShortestPalindrome {
    // Shortest Palindrome
    // https://leetcode.com/problems/shortest-palindrome/
    // Difficulty: Hard
    public class Solution {
        public String shortestPalindrome(String s) {
            int j = 0;

            //找到第一个使他不回文的位置
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    j += 1;
                }
            }
            //本身是回文
            if (j == s.length()) {
                return s;
            }

            // 后缀不能够匹配的字符串
            String suffix = s.substring(j);
            // 前面补充prefix让他和suffix回文匹配
            String prefix = new StringBuilder(suffix).reverse().toString();
            //递归调用找 [0,j]要最少可以补充多少个字符让他回文
            String mid = shortestPalindrome(s.substring(0, j));
            String ans = prefix + mid + suffix;
            return ans;
        }
    }

    public static class UnitTest {

    }
}

