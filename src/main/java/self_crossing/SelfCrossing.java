package self_crossing;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelfCrossing {
    /*
        Self Crossing
        Leetcode #335
        https://leetcode.com/problems/self-crossing/
        Difficulty: Medium
     */
    public class Solution {
        public boolean isSelfCrossing(int[] x) {
            if (x == null || x.length < 4) return false;
            int n = x.length;
            int[] table = new int[4];
            boolean longer = false;

            table[0] = 0;
            for (int i = 0; i < 3; i++)
                table[i + 1] = x[i];

            if (table[1] < table[3]) longer = true;
            else longer = false;

            for (int i = 3; i < n; i++) {
                if (!longer && x[i] >= table[2]) return true;

                if (longer && x[i] <= table[2]) {
                    if (x[i] + table[0] < table[2] || (i + 1 < n && x[i + 1] + table[1] < table[3]))
                        longer = false;
                    else if (i + 1 < n) {
                        return true;
                    }
                }

                for (int j = 0; j < 3; j++)
                    table[j] = table[j + 1];
                table[3] = x[i];
            }

            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SelfCrossing().new Solution();
            assertTrue(sol.isSelfCrossing(new int[]{2, 1, 1, 2}));
            assertTrue(sol.isSelfCrossing(new int[]{1, 1, 1, 1}));
            assertFalse(sol.isSelfCrossing(new int[]{1, 2, 3, 4}));
            assertTrue(sol.isSelfCrossing(new int[]{1, 1, 2, 1, 1}));
            assertTrue(sol.isSelfCrossing(new int[]{1, 1, 2, 2, 1, 1}));
            assertFalse(sol.isSelfCrossing(new int[]{3, 3, 3, 2, 1, 1}));
        }
    }
}

