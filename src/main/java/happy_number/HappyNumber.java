package happy_number;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HappyNumber {
    /*
        Happy Number
        leetcode #202
        https://leetcode.com/problems/happy-number/
        Difficulty: Easy
     */
    public class Solution {
        private int cal(int n) {
            int x = n;
            int s = 0;
            while (x > 0) {
                s = s + (x % 10) * (x % 10);
                x = x / 10;
            }
            return s;
        }

        public boolean isHappy(int n) {
            int x = n;
            int y = n;
            while (x > 1) {
                x = cal(x);
                if (x == 1) return true;
                y = cal(cal(y));
                if (y == 1) return true;
                if (x == y) return false;
            }
            return true;
        }
    }

    /*
        Happy Number
        leetcode #202
        https://leetcode.com/problems/happy-number/
        Difficulty: Easy
     */
    public class Solution_2 {
        public boolean isHappy(int n) {
            Set<Integer> inLoop = new HashSet<>();
            int squareSum, remain;
            while (inLoop.add(n)) {
                squareSum = 0;
                while (n > 0) {
                    remain = n % 10;
                    squareSum += remain * remain;
                    n /= 10;
                }
                if (squareSum == 1)
                    return true;
                else
                    n = squareSum;
            }
            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new HappyNumber().new Solution();
            assertTrue(sol.isHappy(19));
            assertFalse(sol.isHappy(18));
        }

        @Test
        public void test2() {
            Solution_2 sol = new HappyNumber().new Solution_2();
            assertTrue(sol.isHappy(19));
            assertFalse(sol.isHappy(18));
        }
    }
}
