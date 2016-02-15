package implement_strstr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImplementstrStr {
    /*
        Implement strstr - Brute Force
        https://leetcode.com/problems/implement-strstr/
        Difficulty: Medium
     */
    public class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) return -1;

            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                int j;
                for (j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                }
                if (j == needle.length()) return i;
            }
            return -1;
        }
    }

    /*
        Implement strstr - KMP
        https://leetcode.com/problems/implement-strstr/
        Difficulty: Medium
     */
    public class Solution_2 {
        void getNext(String T, int[] next) {
            int i = 0, j = -1;
            next[0] = -1;
            int n = next.length;
            while (i < n - 1) {
                while (j > -1 && T.charAt(j) != T.charAt(i)) j = next[j];
                ++i;
                ++j;
                if (i < n - 1 && j < n - 1 && T.charAt(j) == T.charAt(i)) next[i] = next[j];
                else next[i] = j;
            }
        }

        public int strStr(String haystack, String needle) {
            int sLen = haystack.length(), tLen = needle.length();
            if (tLen == 0) return 0;
            if (haystack == null || needle == null || sLen == 0) return -1;
            int[] next = new int[tLen + 1];
            getNext(needle, next);
            int i = 0, j = 0;
            while (i < sLen) {
                while (j > -1 && needle.charAt(j) != haystack.charAt(i)) j = next[j];
                ++i;
                ++j;
                if (j == tLen) return i - j;
            }
            return -1;
        }
    }

    /*
        Implement strstr - Rolling Hash
        https://leetcode.com/problems/implement-strstr/
        Difficulty: Medium
     */
    public class Solution_3 {
        final int A = 3;

        private int getHash(char[] array, int start, int end) {
            int k = end - start;
            int sum = 0;
            for (int i = start; i <= end; i++) {
                int item = (int) (array[i] * Math.pow(A, k--));
                sum += item;
            }
            return sum;
        }

        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();
            if (m == 0) return 0;
            if (n < m) return -1;

            char[] input = haystack.toCharArray();
            int needleHash = getHash(needle.toCharArray(), 0, m - 1);
            int haystackHash = getHash(input, 0, m - 1);

            for (int i = 0; i < n - m; i++) {
                if (haystackHash == needleHash) {
                    if (haystack.substring(i, i + m).equals(needle))
                        return i;
                }
                //rolling hash
                haystackHash -= (int) (input[i] * Math.pow(A, m - 1));
                haystackHash *= A;
                haystackHash += input[i + m];
            }

            if (haystackHash == needleHash) {
                if (haystack.substring(n - m, n).equals(needle))
                    return n - m;
            }

            return -1;
        }
    }


    public class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ImplementstrStr().new Solution();
            assertEquals(1, sol.strStr("acd1f3ghjk", "cd1f"));
            assertEquals(-1, sol.strStr("acd1f3ghjk", "cd2f"));
        }

        @Test
        public void test2() {
            Solution_2 sol = new ImplementstrStr().new Solution_2();
            assertEquals(1, sol.strStr("acd1f3ghjk", "cd1f"));
            assertEquals(-1, sol.strStr("acd1f3ghjk", "cd2f"));
        }

        @Test
        public void test3() {
            Solution_3 sol = new ImplementstrStr().new Solution_3();
            assertEquals(1, sol.strStr("acd1f3ghjk", "cd1f"));
            assertEquals(-1, sol.strStr("acd1f3ghjk", "cd2f"));
        }
    }
}
