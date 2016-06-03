package flatten_binary_tree_to_linked_list;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FlattenBinaryTreetoLinkedList {
    /*
        Flatten Binary Tree to Linked List
        Leetcode #114
        https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
        Difficulty: Medium
     */
    public class Solution {
        private TreeNode flattenTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode tail = root;
            TreeNode right = root.right;
            if (root.left != null) {
                tail = flattenTree(root.left);
                root.right = root.left;
                tail.right = right;
                root.left = null;
            }
            if (right != null) {
                tail = flattenTree(right);
            }
            return tail;
        }

        public void flatten(TreeNode root) {
            flattenTree(root);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FlattenBinaryTreetoLinkedList().new Solution();
            assertTrue(true);
        }
    }
}
