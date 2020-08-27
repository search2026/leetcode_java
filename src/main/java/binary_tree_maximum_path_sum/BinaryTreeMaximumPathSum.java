package binary_tree_maximum_path_sum;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeMaximumPathSum {
    /*
        Binary Tree Maximum Path Sum
        Leetcode #124
        https://leetcode.com/problems/binary-tree-maximum-path-sum/
        Difficulty: Hard
     */
    public class Solution {
        private int maxPathSum(TreeNode node, int[] maxSum) {
            if (node == null) return 0;
            int lMaxSum = maxPathSum(node.left, maxSum);
            int rMaxSum = maxPathSum(node.right, maxSum);
            maxSum[0] = Math.max(maxSum[0], node.val + lMaxSum + rMaxSum);
            int currSum = node.val + Math.max(lMaxSum, rMaxSum);
            return currSum > 0 ? currSum : 0;
        }

        public int maxPathSum(TreeNode root) {
            int[] maxSum = new int[1];
            maxSum[0] = Integer.MIN_VALUE;
            maxPathSum(root, maxSum);
            return maxSum[0];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreeMaximumPathSum().new Solution();
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(4);
            root.right = new TreeNode(2);
            root.right.left = new TreeNode(-2);
            assertEquals(7, sol.maxPathSum(root));

            root = new TreeNode(-5);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(-1);
            root.left.right = new TreeNode(4);
            assertEquals(6, sol.maxPathSum(root));
        }
    }
}
