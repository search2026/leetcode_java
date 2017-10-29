package range_addition;

import org.junit.*;

import static org.junit.Assert.*;

public class RangeAddition {
    /*
        Range Addition - Brute Force
        Leetcode #370
        https://leetcode.com/discuss/questions/oj/range-addition?sort=votes
        http://www.cnblogs.com/grandyang/p/5628786.html
        Difficulty: Medium
     */
    public class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            if (length < 0 || updates == null || updates.length == 0) return null;
            if (updates[0] == null || updates[0].length != 3) return null;

            int[] nums = new int[length];
            for (int i = 0; i < updates.length; i++) {
                for (int j = updates[i][0]; j <= updates[i][1]; j++) {
                    nums[j] += updates[i][2];
                }
            }

            return nums;
        }
    }

    /*
        Range Addition - O(N+K) time complexity
        Leetcode #370
        https://leetcode.com/discuss/questions/oj/range-addition?sort=votes
        http://www.cnblogs.com/grandyang/p/5628786.html
        Difficulty: Medium
     */
    public class Solution_2 {
        public int[] getModifiedArray(int length, int[][] updates) {
            if (length < 0 || updates == null || updates.length == 0) return null;
            if (updates[0] == null || updates[0].length != 3) return null;

            int[] res = new int[length];
            for (int[] u : updates) {
                res[u[0]] += u[2];
                if (u[1] < length - 1)
                    res[u[1] + 1] -= u[2];
            }

            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += res[i];
                res[i] = sum;
            }

            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RangeAddition().new Solution();
            int length = 5;
            int[][] updates = {
                    {1, 3, 2},
                    {2, 4, 3},
                    {0, 2, -2}
            };
            int[] increased = sol.getModifiedArray(length, updates);
            int[] expected = {-2, 0, 3, 5, 3};
            assertArrayEquals(expected, increased);
        }

        @Test
        public void test2() {
            Solution_2 sol = new RangeAddition().new Solution_2();
            int length = 5;
            int[][] updates = {
                    {1, 3, 2},
                    {2, 4, 3},
                    {0, 2, -2}
            };
            int[] increased = sol.getModifiedArray(length, updates);
            int[] expected = {-2, 0, 3, 5, 3};
            assertArrayEquals(expected, increased);
        }
    }
}

