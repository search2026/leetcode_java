package sqrt_x;

public class SqrtX {
    /*
        Sqrt(x) Binary Search
        https://leetcode.com/problems/sqrtx/
        Difficulty: Medium
     */
    public class Solution {
        public int sqrt(int x) {
            int left = 1, right = x/2;
            if(x<2) return x;
            while (left <= right) {
                int mid = (left + right)/2;
                if (x/mid == mid) return mid;
                if (x/mid > mid) left = mid + 1;
                else right = mid - 1;
            }
            return right;
        }
    }

    /*
        Sqrt(x) Newton
        https://leetcode.com/problems/sqrtx/
        Difficulty: Medium
     */
    public class SolutionII {
        public int sqrt(int x) {
            double a = 1.0;
            while (Math.abs(a * a - x) > 10E-6) {
                a = (a + x / a) / 2;
            }
            return (int) a;
        }
    }

    public static class UnitTest {

    }
}
