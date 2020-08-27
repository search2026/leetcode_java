package flip_game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlipGame {
    /*
        Flip Game
        Leetcode #293
        https://leetcode.com/discuss/questions/oj/flip-game?sort=votes
        http://www.cnblogs.com/anne-vista/p/4886775.html
        Difficulty: Easy
    */
    public class Solution {
        public List<String> generatePossibleNextMoves(String s) {
            List<String> result = new ArrayList<String>();
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                    result.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
                }
            }
            return result;
        }
    }

    /*
        Flip Game II
        Leetcode #294
        https://leetcode.com/discuss/questions/oj/flip-game-ii?sort=votes
        http://www.cnblogs.com/anne-vista/p/4886786.html
        Difficulty: Medium
    */
    public class SolutionII {
        public boolean canWin(String s) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == '+' && s.charAt(i + 1) == '+' && !canWin(s.substring(0, i) + "--" + s.substring(i + 2))) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FlipGame().new Solution();
            assertTrue(true);
        }
    }
}
