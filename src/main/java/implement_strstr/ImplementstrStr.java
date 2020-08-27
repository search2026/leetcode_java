package implement_strstr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImplementstrStr {
    /*
        Implement strstr - Brute Force
        Leetcode #28
        https://leetcode.com/problems/implement-strstr/
        Difficulty: Medium
     */
    public class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null && needle == null) return 0;
            if (haystack == null || needle == null) return -1;

            int m = haystack.length();
            int n = needle.length();
            if (m == 0 && n == 0) return 0;
            if (n == 0) return 0;
            if (m == 0) return -1;
            if (n > m) return -1;

            for (int i = 0; i < m - n + 1; i++) {
                int j;
                for (j = 0; j < n; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                }
                if (j == n) return i;
            }
            return -1;
        }
    }

    /*
        Implement strstr - KMP
        Leetcode #28
        https://leetcode.com/problems/implement-strstr/
        Difficulty: Medium
     */
    public class Solution_2 {
        private void getNext(String T, int[] next) {
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
            if (haystack == null && needle == null) return 0;
            if (haystack == null || needle == null) return -1;

            int m = haystack.length();
            int n = needle.length();
            if (m == 0 && n == 0) return 0;
            if (n == 0) return 0;
            if (m == 0) return -1;
            if (n > m) return -1;

            int[] next = new int[n + 1];
            getNext(needle, next);
            int i = 0, j = 0;
            while (i < m) {
                while (j > -1 && needle.charAt(j) != haystack.charAt(i)) j = next[j];
                ++i;
                ++j;
                if (j == n) return i - j;
            }
            return -1;
        }
    }

    /*
        Implement strstr - Rolling Hash
        Leetcode #28
        https://leetcode.com/problems/implement-strstr/
        Difficulty: Medium
     */
    public class Solution_3 {
        private final int A = 3;

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
            if (haystack == null && needle == null) return 0;
            if (haystack == null || needle == null) return -1;

            int m = haystack.length();
            int n = needle.length();
            if (m == 0 && n == 0) return 0;
            if (n == 0) return 0;
            if (m == 0) return -1;
            if (n > m) return -1;

            char[] input = haystack.toCharArray();
            int needleHash = getHash(needle.toCharArray(), 0, n - 1);
            int haystackHash = getHash(input, 0, n - 1);

            for (int i = 0; i < m - n; i++) {
                if (haystackHash == needleHash) {
                    if (haystack.substring(i, i + n).equals(needle))
                        return i;
                }
                //rolling hash
                haystackHash -= (int) (input[i] * Math.pow(A, n - 1));
                haystackHash *= A;
                haystackHash += input[i + n];
            }

            if (haystackHash == needleHash) {
                if (haystack.substring(m - n, m).equals(needle))
                    return m - n;
            }

            return -1;
        }
    }

    /*
        Implement strstr - Boyer-Moore
        Leetcode #28
        https://leetcode.com/problems/implement-strstr/
        Difficulty: Medium
     */
    public class Solution_4 {
        public int strStr(String haystack, String needle) {
            if (haystack == null && needle == null) return 0;
            if (haystack == null || needle == null) return -1;

            int m = haystack.length();
            int n = needle.length();
            if (m == 0 && n == 0) return 0;
            if (n == 0) return 0;
            if (m == 0) return -1;
            if (n > m) return -1;

            int[] jump = new int[256];  // hashmap char-> index, assume ASCII
            for (int i = 0; i < jump.length; i++) {
                jump[i] = -1;
            }
            for (int i = 0; i < n; i++) {
                jump[needle.charAt(i)] = i; // index of last occurrence
            }
            int skip = 0;
            for (int i = 0; i < m - n + 1; i += skip) { // !!! not i<m
                skip = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        skip = Math.max(1, j - jump[haystack.charAt(i + j)]);    // max is j+1, min is 1 (do not allow <0);
                        break;
                    }
                }
                if (skip == 0) return i;
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

        @Test
        public void test4() {
            Solution_4 sol = new ImplementstrStr().new Solution_4();
            assertEquals(1, sol.strStr("acd1f3ghjk", "cd1f"));
            assertEquals(-1, sol.strStr("acd1f3ghjk", "cd2f"));
        }
    }
}
