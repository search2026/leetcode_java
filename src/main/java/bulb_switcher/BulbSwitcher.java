package bulb_switcher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BulbSwitcher {
    /*
        Bulb Switcher
        Leetcode #319
        https://leetcode.com/problems/bulb-switcher/
        Difficulty: Medium
    */
    public class Solution {
        public int bulbSwitch(int n) {
            return (int) Math.sqrt(n);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BulbSwitcher().new Solution();

            assertEquals(4, sol.bulbSwitch(18));
        }
    }
}

