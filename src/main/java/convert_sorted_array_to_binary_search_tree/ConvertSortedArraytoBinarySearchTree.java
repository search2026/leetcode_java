package convert_sorted_array_to_binary_search_tree;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConvertSortedArraytoBinarySearchTree {
    /*
        Convert Sorted Array to Binary Search Tree
        https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution {
        private TreeNode sortedArrayToBST(int[] num, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            TreeNode node = new TreeNode(num[mid]);
            node.left = sortedArrayToBST(num, left, mid - 1);
            node.right = sortedArrayToBST(num, mid + 1, right);
            return node;
        }

        public TreeNode sortedArrayToBST(int[] num) {
            return sortedArrayToBST(num, 0, num.length - 1);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ConvertSortedArraytoBinarySearchTree().new Solution();
            assertTrue(true);
        }
    }
}
