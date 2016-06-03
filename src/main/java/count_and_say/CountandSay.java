package count_and_say;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CountandSay {
    /*
        Count and Say
        leetcode #38
        https://leetcode.com/problems/count-and-say/
        Difficulty: Easy
     */
    public class Solution {
        public String countAndSay(int n) {
            String ans = "1";
            n--;
            while (n > 0) {
                n--;
                StringBuilder builder = new StringBuilder();
                int count = 1;
                for (int i = 1; i < ans.length(); i++) {
                    if (ans.charAt(i - 1) == ans.charAt(i)) {
                        count++;
                    } else {
                        builder.append(count);
                        builder.append(ans.charAt(i - 1));
                        count = 1;
                    }
                }
                builder.append(count);
                builder.append(ans.charAt(ans.length() - 1));
                ans = builder.toString();
            }
            return ans;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CountandSay().new Solution();
            assertTrue(true);
        }
    }
}
