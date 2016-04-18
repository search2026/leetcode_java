package house_robber;

import common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HouseRobber {
    /*
        House Robber
        https://leetcode.com/problems/house-robber/
        Difficulty: Easy
    */
    public class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length < 2) {
                return nums[0];
            }
            int f1 = nums[0];
            int f2 = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                // f(i) = max { f(i - 2) + nums[i], f(i - 1) }
                int f = Math.max(f1 + nums[i], f2);
                f1 = f2;
                f2 = f;
            }
            return f2;
        }
    }

    /*
        House Robber II
        https://leetcode.com/problems/house-robber-ii/
        Difficulty: Medium
    */
    public class Solution_2 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;

            int n = nums.length;

            if (n == 1) {
                return nums[0];
            }
            if (n == 2) {
                return Math.max(nums[1], nums[0]);
            }

            //include 1st element, and not last element
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = nums[0];

            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            }

            //do not include 1st element, and include last element
            int[] dr = new int[n + 1];
            dr[0] = 0;
            dr[1] = nums[1];

            for (int i = 2; i < n; i++) {
                dr[i] = Math.max(dr[i - 1], dr[i - 2] + nums[i]);
            }

            return Math.max(dp[n - 1], dr[n - 1]);
        }
    }

    /*
        House Robber III - DFS
        https://leetcode.com/problems/house-robber-iii/
        Difficulty: Medium
    */
    public class Solution_3 {
        int[] search(TreeNode node) {
            int[] rslt = new int[2];
            if (node == null) return rslt;
            int[] left = search(node.left);
            int[] right = search(node.right);
            rslt[0] = left[1] + right[1];
            rslt[1] = Math.max(rslt[0], left[0] + right[0] + node.val);
            return rslt;
        }

        public int rob(TreeNode root) {
            return search(root)[1];
        }
    }

    /*
        House Robber III - DFS
        https://leetcode.com/problems/house-robber-iii/
        http://bookshadow.com/weblog/2016/03/13/leetcode-house-robber-iii/
        Difficulty: Medium
    */
    public class Solution_4 {
        private int[] search(TreeNode root) {
            if (root == null) return new int[2];
            int[] left = search(root.left);
            int[] right = search(root.right);
            int[] rslt = new int[2];
            rslt[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            rslt[1] = root.val + left[0] + right[0];

            return rslt;
        }

        public int rob(TreeNode root) {
            int[] rslt = search(root);
            return Math.max(rslt[0], rslt[1]);
        }
    }

    /*
        House Robber III - DFS
        https://leetcode.com/problems/house-robber-iii/
        http://bookshadow.com/weblog/2016/03/13/leetcode-house-robber-iii/
        Difficulty: Medium
    */
    public class Solution_5 {
        private Map<TreeNode, Integer> map = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return root.val;
            if (map.containsKey(root)) return map.get(root);

            //case 1
            int sum1 = root.val;
            if (root.left != null) sum1 += rob(root.left.left) + rob(root.left.right);
            if (root.right != null) sum1 += rob(root.right.left) + rob(root.right.right);

            //case 2
            int sum2 = rob(root.left) + rob(root.right);

            int sum = Math.max(sum1, sum2);
            map.put(root, sum);
            return sum;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new HouseRobber().new Solution();
            assertEquals(3, 3);
        }
    }
}

