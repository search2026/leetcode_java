package nim_game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NimGame {
    /*
        Nim Game
        Leetcode #292
        https://leetcode.com/problems/nim-game/
        Difficulty: Easy
     */
    public class Solution {
        public boolean canWinNim(int n) {
            return (n % 4) > 0;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new NimGame().new Solution();
            assertTrue(sol.canWinNim(7));
            assertFalse(sol.canWinNim(8));
        }
    }
}
