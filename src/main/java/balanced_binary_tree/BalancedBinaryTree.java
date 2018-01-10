package balanced_binary_tree;

import common.TreeNode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class BalancedBinaryTree {
  /*
      Balanced Binary Tree - Bottom Up Travsersal
      Leetcode #110
      https://leetcode.com/problems/balanced-binary-tree/
      Difficulty: Easy
   */
  class Solution {
    private int getTreeDepth(TreeNode root) {
      if (root == null) return 0;

      int lDepth = getTreeDepth(root.left);
      if (lDepth == -1) return -1;
      int rDepth = getTreeDepth(root.right);
      if(rDepth == -1) return -1;

      return (Math.abs(lDepth - rDepth) <= 1) ? Math.max(lDepth, rDepth) + 1 : -1;
    }

    public boolean isBalanced(TreeNode root) {
      return getTreeDepth(root) != -1;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new BalancedBinaryTree().new Solution();
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(8);
      root.right.left = new TreeNode(7);
      assertTrue(sol.isBalanced(root));

      root.right.left.right = new TreeNode(6);
      assertFalse(sol.isBalanced(root));
    }
  }
}
