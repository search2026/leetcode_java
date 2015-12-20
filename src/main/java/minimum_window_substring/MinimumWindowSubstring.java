package minimum_window_substring;

public class MinimumWindowSubstring {

    public class Solution {
        public String minWindow(String s, String t) {
            int[] tCount = new int[256];
            for (int i = 0; i < t.length(); i++) {
                tCount[t.charAt(i)]++;
            }
            int[] sCount = new int[256];
            int i = 0;
            for (; i < s.length(); i++) {
                sCount[s.charAt(i)]++;
                boolean find = true;
                for (int j = 0; j < 256; j++) {
                    if (sCount[j] < tCount[j]) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    break;
                }
            }
            if (i == s.length()) {
                return "";
            }
            int windowStart = 0;
            int windowEnd = i;
            int minWindowStart = windowStart;
            int minWindowEnd = windowEnd;
            while (windowStart < s.length()) {
                char c = s.charAt(windowStart);
                sCount[c]--;
                windowStart++;
                if (sCount[c] < tCount[c]) {
                    windowEnd++;
                    while (windowEnd < s.length()) {
                        char endC = s.charAt(windowEnd);
                        sCount[endC]++;
                        if (c == endC) {
                            break;
                        }
                        windowEnd++;
                    }
                    if (windowEnd == s.length()) {
                        break;
                    }
                }
                if (windowEnd - windowStart < minWindowEnd - minWindowStart) {
                    minWindowStart = windowStart;
                    minWindowEnd = windowEnd;
                }
            }
            return s.substring(minWindowStart, minWindowEnd + 1);
        }
    }

    public static class UnitTest {

    }
}
