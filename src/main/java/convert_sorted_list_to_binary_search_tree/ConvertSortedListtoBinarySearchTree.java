package convert_sorted_list_to_binary_search_tree;

import common.ListNode;
import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConvertSortedListtoBinarySearchTree {
  /*
      Convert Sorted List to Binary Search Tree
      Leetcode #109
      https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
      Difficulty: Medium
   */
  public class Solution {
    private TreeNode sortedListToBST(ListNode head, ListNode[] tail, int left, int right) {
      if (left > right) {
        tail[0] = head;
        return null;
      }
      TreeNode node = new TreeNode(0);
      int mid = left + (right - left) / 2;
      node.left = sortedListToBST(head, tail, left, mid - 1);
      node.val = tail[0].val;
      node.right = sortedListToBST(tail[0].next, tail, mid + 1, right);
      return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
      if (head == null) return null;
      ListNode p = head;
      int len = 0;
      while (p != null) {
        len++;
        p = p.next;
      }
      return sortedListToBST(head, new ListNode[1], 0, len - 1);
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new ConvertSortedListtoBinarySearchTree().new Solution();

      ListNode testRoot = new ListNode(1);
      testRoot.next = new ListNode(3);
      testRoot.next.next = new ListNode(5);
      testRoot.next.next.next = new ListNode(6);
      testRoot.next.next.next.next = new ListNode(7);
      testRoot.next.next.next.next.next = new ListNode(8);
      testRoot.next.next.next.next.next.next = new ListNode(9);

      TreeNode root = sol.sortedListToBST(testRoot);

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
