package com.search2026.leetcode.problems;

public class ClimbingStairs {

    /*
        Climbing Stairs
        Leetcode #70
        https://leetcode.com/problems/climbing-stairs/
        Difficulty: Easy
     */
    public class Solution {
        public int climbStairs(int n) {
            if (n == 1) return 1;
            int f1 = 1;
            int f2 = 2;
            for (int i = 3; i <= n; i++) {
                int temp = f1 + f2;
                f1 = f2;
                f2 = temp;
            }
            return f2;
        }
    }

    /*
        Climbing Stairs
        Leetcode #70
        https://leetcode.com/problems/climbing-stairs/
        Difficulty: Easy
     */
    public class Solution_2 {
        public int climbStairs(int n) {
            double root5 = Math.sqrt(5);
            return (int) ((Math.pow((1 + root5) / 2, n + 1) - Math.pow((1 - root5) / 2, n + 1)) / root5 + 0.5);
        }
    }

    /*
        Climbing Stairs
        Leetcode #70
        https://leetcode.com/problems/climbing-stairs/
        Difficulty: Easy
     */
    public class Solution_3 {
        public int climbStairs(int n) {
            double root5 = Math.sqrt(5);
            double phi = (1 + root5) / 2;
            return (int) (Math.pow(phi, n + 1) / root5 + 0.5);
        }
    }

}
