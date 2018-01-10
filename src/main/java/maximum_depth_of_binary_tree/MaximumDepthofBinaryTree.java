package maximum_depth_of_binary_tree;

import common.TreeNode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDepthofBinaryTree {
  /*
      Maximum Depth of Binary Tree
      Leetcode #104
      https://leetcode.com/problems/maximum-depth-of-binary-tree/
      Difficulty: Easy
   */
  public class Solution {
    public int maxDepth(TreeNode root) {
      if (root == null) return 0;
      return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new MaximumDepthofBinaryTree().new Solution();
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(8);
      assertEquals(2, sol.maxDepth(root));

      root.right.left = new TreeNode(7);
      assertEquals(3, sol.maxDepth(root));

      root.right.left.right = new TreeNode(6);
      assertEquals(4, sol.maxDepth(root));
    }
  }
}
