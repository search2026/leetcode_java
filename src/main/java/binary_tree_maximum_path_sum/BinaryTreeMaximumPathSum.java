package binary_tree_maximum_path_sum;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class BinaryTreeMaximumPathSum {
    /*
        Binary Tree Maximum Path Sum
        https://leetcode.com/problems/binary-tree-maximum-path-sum/
        Difficulty: Hard
     */
    public class Solution {
        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;
            ArrayList<Integer> rslt = new ArrayList<Integer>();
            rslt.add(Integer.MIN_VALUE);
            FindMaxSum(root, rslt);
            return rslt.get(0);
        }

        public int FindMaxSum(TreeNode root, ArrayList<Integer> res) {
            if (root == null) return 0;

            int leftsum = FindMaxSum(root.left, res);
            int rightsum = FindMaxSum(root.right, res);
            int maxsum = root.val + (leftsum>0? leftsum : 0) + (rightsum>0? rightsum : 0);
            if (maxsum > res.get(0)) res.set(0, maxsum);

            return root.val + Math.max(leftsum, Math.max(rightsum, 0));
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreeMaximumPathSum().new Solution();
            assertTrue(true);
        }
    }
}
