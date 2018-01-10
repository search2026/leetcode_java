package binary_tree_upside_down;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeUpsideDown {
  /*
      Binary Tree Upside Down - Top Down Approach
      Leetcode #156
      https://leetcode.com/discuss/oj/binary-tree-upside-down
      http://www.cnblogs.com/grandyang/p/5172838.html
      Difficulty: Medium
   */
  public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
      TreeNode node = root, parent = null, right = null;
      while (node != null) {
        TreeNode left = node.left;
        node.left = right;
        right = node.right;
        node.right = parent;
        parent = node;
        node = left;
      }
      return parent;
    }
  }

  /*
      Binary Tree Upside Down - Bottom Up Approach
      Leetcode #156
      https://leetcode.com/discuss/oj/binary-tree-upside-down
      http://www.cnblogs.com/grandyang/p/5172838.html
      Difficulty: Medium
   */
  public class Solution_2 {
    private TreeNode traversal(TreeNode node, TreeNode parent) {
      if (node == null) return parent;
      TreeNode root = traversal(node.left, node);
      node.left = (parent == null) ? parent : parent.right;
      node.right = parent;
      return root;
    }

    public TreeNode UpsideDownBinaryTree(TreeNode root) {
      if (root == null) return root;
      return traversal(root, null);
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new BinaryTreeUpsideDown().new Solution();
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(5);

      TreeNode upSideDown = sol.UpsideDownBinaryTree(root);

      assertEquals(2, upSideDown.val);
      assertEquals(3, upSideDown.left.val);
      assertEquals(1, upSideDown.right.val);
      assertEquals(4, upSideDown.left.left.val);
      assertEquals(5, upSideDown.left.right.val);

      root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      upSideDown = sol.UpsideDownBinaryTree(root);

      assertEquals(4, upSideDown.val);
      assertEquals(5, upSideDown.left.val);
      assertEquals(2, upSideDown.right.val);
      assertEquals(3, upSideDown.right.left.val);
      assertEquals(1, upSideDown.right.right.val);
    }

    @Test
    public void test2() {
      Solution_2 sol = new BinaryTreeUpsideDown().new Solution_2();
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(5);

      TreeNode upSideDown = sol.UpsideDownBinaryTree(root);

      assertEquals(2, upSideDown.val);
      assertEquals(3, upSideDown.left.val);
      assertEquals(1, upSideDown.right.val);
      assertEquals(4, upSideDown.left.left.val);
      assertEquals(5, upSideDown.left.right.val);

      root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      upSideDown = sol.UpsideDownBinaryTree(root);

      assertEquals(4, upSideDown.val);
      assertEquals(5, upSideDown.left.val);
      assertEquals(2, upSideDown.right.val);
      assertEquals(3, upSideDown.right.left.val);
      assertEquals(1, upSideDown.right.right.val);
    }
  }
};
