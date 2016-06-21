package minimum_depth_of_binary_tree;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumDepthofBinaryTree {
  /*
      Minimum Depth of Binary Tree
      Leetcode #111
      https://leetcode.com/problems/minimum-depth-of-binary-tree/
      Difficulty: Easy
   */
  public class Solution {
    public int minDepth(TreeNode root) {
      if (root == null) return 0;
      int left = minDepth(root.left);
      int right = minDepth(root.right);
      return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new MinimumDepthofBinaryTree().new Solution();
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(3);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(-2);
      assertEquals(2, sol.minDepth(root));
    }
  }
}
