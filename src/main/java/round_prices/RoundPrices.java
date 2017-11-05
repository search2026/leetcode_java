package round_prices;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class RoundPrices {
    /*
        Round Prices
        http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=146539
        Difficulty: Medium
     */
    public class Solution {
        // 思路就是先把所有floor加起来，然后看差多少，然后把多少个floor转成ceil
        // 转的时候按照num本身与ceil的距离排序
        public int[] getNearlyArrayWithSameSum(double[] arr) {
            NumWithDiff[] arrWithDiff = new NumWithDiff[arr.length];
            double sum = 0.0;
            int floorSum = 0;
            for (int i = 0; i < arr.length; i++) {
                int floor = (int) arr[i];
                int ceil = floor;
                if (floor < arr[i]) ceil++; // 查是不是4.0这种floor/ceil都是本身的
                floorSum += floor;
                sum += arr[i];
                arrWithDiff[i] = new NumWithDiff(ceil, ceil - arr[i]); // 把ceil都放在数组里面进行比较
            }
            int num = (int) Math.round(sum);
            int diff = num - floorSum;
            Arrays.sort(arrWithDiff, new Comparator<NumWithDiff>() {
                public int compare(NumWithDiff n1, NumWithDiff n2) {
                    if (n1.diffWithCeil <= n2.diffWithCeil) return -1;
                    else return 1;
                }
            });
            int[] res = new int[arr.length];
            int i = 0;
            for (; i < diff; i++) {
                res[i] = arrWithDiff[i].num; // 这些放ceil
            }
            for (; i < arr.length; i++) {
                res[i] = arrWithDiff[i].num - 1; // 剩下的只放floor
            }
            return res;
        }

        class NumWithDiff {
            int num;
            double diffWithCeil;

            public NumWithDiff(int n, double c) {
                this.num = n;
                this.diffWithCeil = c;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RoundPrices().new Solution();
            double[] arr = {1.2, 3.7, 2.3, 4.8};
            int[] res = sol.getNearlyArrayWithSameSum(arr);
            assertEquals(5, res[0]);
            assertEquals(4, res[1]);
            assertEquals(2, res[2]);
            assertEquals(1, res[3]);

            arr = new double[]{1.2, 2.5, 3.6, 4.0};
            res = sol.getNearlyArrayWithSameSum(arr);
            assertEquals(4, res[0]);
            assertEquals(3, res[1]);
            assertEquals(2, res[2]);
            assertEquals(1, res[3]);
        }
    }
}

