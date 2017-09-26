package house_robber;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobber {
    /*
        House Robber - Dynamic Programming
        Leetcode #198
        https://leetcode.com/problems/house-robber/
        Difficulty: Easy
    */
    public class Solution {
        public int rob(int[] nums) {
            if (nums == null) return 0;
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return nums[0];

            int f1 = nums[0]; // exclude max
            int f2 = Math.max(nums[0], nums[1]); // max so far
            for (int i = 2; i < n; i++) {
                int f = Math.max(f1 + nums[i], f2);
                f1 = f2;
                f2 = f;
            }

            return f2;
        }
    }

    /*
        House Robber - Dynamic Programming
        Leetcode #198
        https://leetcode.com/problems/house-robber/
        Difficulty: Easy
    */
    public class Solution_2 {
        public int rob(int[] nums) {
            int rob = 0;
            int notrob = 0;
            for (int i = 0; i < nums.length; i++) {
                int curr = notrob + nums[i]; //if rob current value, previous house must not be robbed
                notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
                rob = curr;
            }
            return Math.max(rob, notrob);
        }
    }

    /*
        House Robber - Dynamic Programming
        Leetcode #198
        https://leetcode.com/problems/house-robber/
        Difficulty: Easy
    */
    public class Solution_3 {
        public int rob(int[] nums) {
            int[][] dp = new int[nums.length + 1][2];
            for (int i = 1; i <= nums.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = nums[i - 1] + dp[i - 1][0];
            }
            return Math.max(dp[nums.length][0], dp[nums.length][1]);
        }
    }

    /*
        House Robber II - Dynamic Programming
        Leetcode #213
        https://leetcode.com/problems/house-robber-ii/
        Difficulty: Medium
    */
    public class Solution_4 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int n = nums.length;
            if (n == 1) return nums[0];
            if (n == 2) return Math.max(nums[1], nums[0]);

            int f1 = 0;
            int f2 = nums[0];
            for (int i = 2; i < n; i++) {
                int f = Math.max(f1 + nums[i - 1], f2);
                f1 = f2;
                f2 = f;
            }
            int prev = f2;

            f1 = 0;
            f2 = nums[1];
            for (int i = 2; i < n; i++) {
                int f = Math.max(f1 + nums[i], f2);
                f1 = f2;
                f2 = f;
            }

            return Math.max(prev, f2);
        }
    }

    /*
        House Robber II - Dynamic Programming
        Leetcode #213
        https://leetcode.com/problems/house-robber-ii/
        Difficulty: Medium
    */
    public class Solution_5 {
        private int rob(int[] nums, int left, int right) {
            int excludeMax = 0, maxSoFar = nums[left];

            for (int i = left + 1; i <= right; i++) {
                int f = Math.max(excludeMax + nums[i], maxSoFar);
                excludeMax = maxSoFar;
                maxSoFar = f;
            }

            return maxSoFar;
        }

        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int n = nums.length;
            if (n == 1) return nums[0];
            if (n == 2) return Math.max(nums[1], nums[0]);
            return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
        }
    }

    /*
        House Robber III - Backtracking
        Leetcode #337
        https://leetcode.com/problems/house-robber-iii/
        Difficulty: Medium
    */
    public class Solution_6 {
        private int[] search(TreeNode node) {
            int[] maxVal = new int[2]; //excludeMax and maxSoFar
            if (node == null) return maxVal;
            int[] left = search(node.left);
            int[] right = search(node.right);
            maxVal[0] = left[1] + right[1];
            maxVal[1] = Math.max(left[0] + right[0] + node.val, maxVal[0]);
            return maxVal;
        }

        public int rob(TreeNode root) {
            int[] maxVal = search(root);
            return Math.max(maxVal[0], maxVal[1]);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new HouseRobber().new Solution();
            int[] test1 = {5, 6, 3, 1};
            assertEquals(8, sol.rob(test1));
            int[] test2 = {6, 5, 0, 1, 0, 9};
            assertEquals(16, sol.rob(test2));
            int[] test3 = {5, 1, 1, 5};
            assertEquals(10, sol.rob(test3));
            int[] test4 = {3, 6, 4};
            assertEquals(7, sol.rob(test4));
            int[] test5 = {4, 10, 3, 1, 5};
            assertEquals(15, sol.rob(test5));
        }

        @Test
        public void test2() {
            Solution_2 sol = new HouseRobber().new Solution_2();
            int[] test1 = {5, 6, 3, 1};
            assertEquals(8, sol.rob(test1));
            int[] test2 = {6, 5, 0, 1, 0, 9};
            assertEquals(16, sol.rob(test2));
            int[] test3 = {5, 1, 1, 5};
            assertEquals(10, sol.rob(test3));
            int[] test4 = {3, 6, 4};
            assertEquals(7, sol.rob(test4));
            int[] test5 = {4, 10, 3, 1, 5};
            assertEquals(15, sol.rob(test5));
        }

        @Test
        public void test3() {
            Solution_3 sol = new HouseRobber().new Solution_3();
            int[] test1 = {5, 6, 3, 1};
            assertEquals(8, sol.rob(test1));
            int[] test2 = {6, 5, 0, 1, 0, 9};
            assertEquals(16, sol.rob(test2));
            int[] test3 = {5, 1, 1, 5};
            assertEquals(10, sol.rob(test3));
            int[] test4 = {3, 6, 4};
            assertEquals(7, sol.rob(test4));
            int[] test5 = {4, 10, 3, 1, 5};
            assertEquals(15, sol.rob(test5));
        }

        @Test
        public void test4() {
            Solution_4 sol = new HouseRobber().new Solution_4();
            int[] test1 = {5, 6, 3, 1};
            assertEquals(8, sol.rob(test1));
            int[] test2 = {6, 5, 0, 1, 0, 9};
            assertEquals(15, sol.rob(test2));
        }

        @Test
        public void test5() {
            Solution_5 sol = new HouseRobber().new Solution_5();
            int[] test1 = {5, 6, 3, 1};
            assertEquals(8, sol.rob(test1));
            int[] test2 = {6, 5, 0, 1, 0, 9};
            assertEquals(15, sol.rob(test2));
        }

        @Test
        public void test6() {
            Solution_6 sol = new HouseRobber().new Solution_6();
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.right = new TreeNode(3);
            root.right.right = new TreeNode(1);
            assertEquals(7, sol.rob(root));

            root = new TreeNode(3);
            root.left = new TreeNode(4);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);
            root.right.right = new TreeNode(1);
            assertEquals(9, sol.rob(root));
        }
    }
}

