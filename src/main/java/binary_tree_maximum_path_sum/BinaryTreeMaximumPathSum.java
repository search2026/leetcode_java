package binary_tree_maximum_path_sum;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinaryTreeMaximumPathSum {
  /*
      Binary Tree Maximum Path Sum
      Leetcode #124
      https://leetcode.com/problems/binary-tree-maximum-path-sum/
      Difficulty: Hard
   */
  public class Solution {
    private int maxPathSum(TreeNode node, int[] max) {
      if (node == null) return 0;
      int leftMax = Math.max(0, maxPathSum(node.left, max));
      int rightMax = Math.max(0, maxPathSum(node.right, max));
      max[0] = Math.max(max[0], node.val + leftMax + rightMax);
      return node.val + Math.max(leftMax, rightMax);
    }

    public int maxPathSum(TreeNode root) {
      int[] max = new int[1];
      max[0] = Integer.MIN_VALUE;
      maxPathSum(root, max);
      return max[0];
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new BinaryTreeMaximumPathSum().new Solution();
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(3);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(-2);
      assertEquals(6, sol.maxPathSum(root));
    }
  }
}
