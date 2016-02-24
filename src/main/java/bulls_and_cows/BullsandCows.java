package bulls_and_cows;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BullsandCows {
    /*
        Bulls and Cows
        https://leetcode.com/problems/bulls-and-cows/
        Difficulty: Easy
     */
    public class Solution {
        public String getHint(String secret, String guess) {
            if (secret == null || guess == null || secret.length() != guess.length()) {
                return "";
            }

            int countA = 0;
            int countB = 0;
            int[] count = new int[10];

            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    countA++;
                } else {
                    count[secret.charAt(i) - '0']++;
                    if (count[secret.charAt(i) - '0'] <= 0) {
                        countB++;
                    }
                    count[guess.charAt(i) - '0']--;
                    if (count[guess.charAt(i) - '0'] >= 0) {
                        countB++;
                    }
                }
            }

            return String.valueOf(countA) + "A" + String.valueOf(countB) + "B";
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BullsandCows().new Solution();
            assertTrue(sol.getHint("1807", "7810").equals("1A3B"));
            assertTrue(sol.getHint("1123", "0111").equals("1A1B"));
        }
    }
}
