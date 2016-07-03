package convert_sorted_array_to_binary_search_tree;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ConvertSortedArraytoBinarySearchTree {
  /*
      Convert Sorted Array to Binary Search Tree
      Leetcode #108
      https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
      Difficulty: Medium
   */
  public class Solution {
    private TreeNode sortedArrayToBST(int[] num, int right, int left) {
      if (right > left) return null;

      int mid = right + (left - right) / 2;
      TreeNode node = new TreeNode(num[mid]);
      node.left = sortedArrayToBST(num, right, mid - 1);
      node.right = sortedArrayToBST(num, mid + 1, left);
      return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
      if (nums == null || nums.length == 0) return null;
      return sortedArrayToBST(nums, 0, nums.length - 1);
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new ConvertSortedArraytoBinarySearchTree().new Solution();
      int[] test = {1, 3, 5, 6, 7, 8, 9};
      TreeNode root = sol.sortedArrayToBST(test);
      assertEquals(6, root.val);
      assertEquals(3, root.left.val);
      assertEquals(8, root.right.val);
      assertEquals(1, root.left.left.val);
      assertEquals(5, root.left.right.val);
      assertEquals(7, root.right.left.val);
      assertEquals(9, root.right.right.val);
    }
  }
}
