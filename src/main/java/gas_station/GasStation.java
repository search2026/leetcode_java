package gas_station;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GasStation {
    /*
        Gas Station - Brute Force
        Leetcode #134
        https://leetcode.com/problems/gas-station/
        Difficulty: Medium
     */
    public class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int N = gas.length;
            int[] balance = new int[N];
            for (int i = 0; i < N; i++) {
                balance[i] = gas[i] - cost[i];
            }

            for (int k = 0; k < N; k++) {
                if (check(balance, k, N) == 1) return k;
            }
            return -1;
        }

        public int check(int[] balance, int k, int N) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (k + j < N) sum = sum + balance[k + j];
                else sum = sum + balance[k + j - N];
                if (sum < 0) return 0;
            }
            return 1;
        }
    }

    /*
        Gas Station - Dynamic Programming
        Leetcode #134
        https://leetcode.com/problems/gas-station/
        Difficulty: Medium
    */
    public class Solution_2 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int curSum = 0; // 用于记录当前gas剩余量
            int total = 0;  // 记录走完一圈的gas剩余量
            int startIndex = 0; // 记录能走完一圈的开始位置

            for (int i = 0; i < gas.length; i++) {
                int curRemain = gas[i] - cost[i];
                if (curSum >= 0) { // 如果当前还有剩余量，继续
                    curSum += curRemain;
                } else { // 否则，从这里重新开始
                    curSum = curRemain;
                    startIndex = i;
                }
                total += curRemain;
            }

            return total >= 0 ? startIndex : -1;
        }
    }

    /*
        Gas Station - Dynamic Programming
        Leetcode #134
        https://leetcode.com/problems/gas-station/
        Difficulty: Medium
    */
    public class Solution_3 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int start = 0;
            while (start < gas.length) {
                int end = start;
                int rest = 0;
                do {
                    rest += gas[end] - cost[end];
                    end = (end + 1) % gas.length;
                    if (rest < 0) {
                        if (end <= start) {
                            return -1;
                        }
                        break;
                    }
                } while (end != start);
                if (end == start) {
                    return start;
                }
                start = end;
            }
            return -1;
        }

    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new GasStation().new Solution();
            assertTrue(true);
        }
    }
}
