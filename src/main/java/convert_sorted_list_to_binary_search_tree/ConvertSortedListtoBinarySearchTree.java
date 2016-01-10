package convert_sorted_list_to_binary_search_tree;

import common.ListNode;
import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConvertSortedListtoBinarySearchTree {
    /*
        Convert Sorted List to Binary Search Tree
        https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution {
        private TreeNode sortedListToBST(ListNode head, ListNode[] tail, int left, int right) {
            if (left > right) {
                tail[0] = head;
                return null;
            }
            TreeNode p = new TreeNode(0);
            int mid = left + (right - left) / 2;
            p.left = sortedListToBST(head, tail, left, mid - 1);
            p.val = tail[0].val;
            p.right = sortedListToBST(tail[0].next, tail, mid + 1, right);
            return p;
        }

        public TreeNode sortedListToBST(ListNode head) {
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
            assertTrue(true);
        }
    }
}
