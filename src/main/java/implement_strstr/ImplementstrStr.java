package implement_strstr;

public class ImplementstrStr {
    /*
        Implement stratr
        https://leetcode.com/problems/implement-strstr/
        Difficulty: Easy
     */
    public class Solution {
        public int strStr_1(String haystack, String needle) {
            int sLen = haystack.length(), tLen = needle.length();
            if (tLen == 0) return 0;
            if (haystack == null || needle == null || sLen == 0) return -1;
            int i = 0, j = 0;
            while (i < sLen) {
                for (j = 0; j < tLen && (i + j) < sLen && haystack.charAt(i + j) == needle.charAt(j); ++j) ;
                if (j == tLen) return i;
                ++i;
            }
            return (int) -1;
        }

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

        public int strStr_2(String haystack, String needle) {
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

        public int strStr_3(String haystack, String needle) {
            int sLen = haystack.length(), tLen = needle.length();
            if (tLen == 0) return 0;
            if (haystack == null || needle == null || sLen == 0 || sLen < tLen) return -1;
            long fh = 0, fn = 0;
            int head = 0, tail = tLen - 1;
            for (int i = 0; i < tLen; ++i) {
                fh += haystack.charAt(i);
                fn += needle.charAt(i);
            }
            while (tail < sLen) {
                if (fn == fh) {
                    int i = 0;
                    while (i < tLen && needle.charAt(i) == haystack.charAt(i + head)) {
                        ++i;
                    }
                    if (i == tLen) return head;
                }
                if (tail == sLen - 1) return -1;
                fh -= haystack.charAt(head++);
                fh += haystack.charAt(++tail);
            }
            return -1;
        }

        public int strStr_4(String haystack, String needle) {
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                int j = 0;
                int start = i;
                for (j = 0; j < needle.length(); j++) {
                    if (start < haystack.length() && haystack.charAt(start) == needle.charAt(j)) {
                        start++;
                    } else {
                        break;
                    }
                }
                if (j == needle.length()) {
                    return i;
                }
            }

            return -1;
        }
    }

    public static class UnitTest {

    }
}
