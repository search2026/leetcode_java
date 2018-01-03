package convert_sorted_array_to_binary_search_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class ConvertSortedArraytoBinarySearchTree {
    /*
        Convert Sorted Array to Binary Search Tree - Recursion
        Leetcode #108
        https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution {
        private TreeNode sortedArrayToBST(int[] num, int left, int right) {
            if (left > right) return null;

            int mid = left + (right - left) / 2;
            TreeNode node = new TreeNode(num[mid]);
            node.left = sortedArrayToBST(num, left, mid - 1);
            node.right = sortedArrayToBST(num, mid + 1, right);
            return node;
        }

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }
    }

    /*
        Convert Sorted Array to Binary Search Tree - Iterative
        Leetcode #108
        https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution_2 {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            int len = nums.length;

            TreeNode root = new TreeNode(0);

            Deque<TreeNode> nodeStack = new LinkedList<TreeNode>() {{
                push(root);
            }};
            Deque<Integer> leftIndexStack = new LinkedList<Integer>() {{
                push(0);
            }};
            Deque<Integer> rightIndexStack = new LinkedList<Integer>() {{
                push(len - 1);
            }};

            while (!nodeStack.isEmpty()) {
                TreeNode currNode = nodeStack.pop();
                int left = leftIndexStack.pop();
                int right = rightIndexStack.pop();
                int mid = left + (right - left) / 2; // avoid overflow
                currNode.val = nums[mid];
                if (left <= mid - 1) {
                    currNode.left = new TreeNode(0);
                    nodeStack.push(currNode.left);
                    leftIndexStack.push(left);
                    rightIndexStack.push(mid - 1);
                }
                if (mid + 1 <= right) {
                    currNode.right = new TreeNode(0);
                    nodeStack.push(currNode.right);
                    leftIndexStack.push(mid + 1);
                    rightIndexStack.push(right);
                }
            }
            return root;
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

        @Test
        public void test2() {
            Solution_2 sol = new ConvertSortedArraytoBinarySearchTree().new Solution_2();
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
