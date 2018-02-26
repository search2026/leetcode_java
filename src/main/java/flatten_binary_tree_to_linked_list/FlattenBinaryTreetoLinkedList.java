package flatten_binary_tree_to_linked_list;

import common.TreeNode;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlattenBinaryTreetoLinkedList {
    /*
        Flatten Binary Tree to Linked List - Recursive
        Leetcode #114
        https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
        Difficulty: Medium
     */
    public class Solution {
        private TreeNode flatten(TreeNode root, TreeNode pre) {
            if (root == null) return pre;
            pre = flatten(root.right, pre);
            pre = flatten(root.left, pre);
            root.right = pre;
            root.left = null;
            pre = root;
            return pre;
        }

        public void flatten(TreeNode root) {
            flatten(root, null);
        }
    }

    /*
        Flatten Binary Tree to Linked List - Iterative
        Leetcode #114
        https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
        Difficulty: Medium
     */
    public class Solution_2 {
        public void flatten(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left != null) {
                    TreeNode leftClosetToMiddle = cur.left;
                    while (leftClosetToMiddle.right != null) leftClosetToMiddle = leftClosetToMiddle.right;
                    leftClosetToMiddle.right = cur.right;
                    cur.right = cur.left;
                    cur.left = null;
                }
                cur = cur.right;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(4);
            root.right.right = new TreeNode(6);

            Solution sol = new FlattenBinaryTreetoLinkedList().new Solution();
            sol.flatten(root);
            assertEquals(1, root.val);
            assertNull(root.left);
            assertEquals(2, root.right.val);
            assertNull(root.right.left);
            assertEquals(3, root.right.right.val);
            assertNull(root.right.right.left);
            assertEquals(4, root.right.right.right.val);
            assertNull(root.right.right.right.left);
            assertEquals(5, root.right.right.right.right.val);
            assertNull(root.right.right.right.right.left);
            assertEquals(6, root.right.right.right.right.right.val);
            assertNull(root.right.right.right.right.right.left);
            assertNull(root.right.right.right.right.right.right);
        }

        @Test
        public void test2() {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(4);
            root.right.right = new TreeNode(6);

            Solution_2 sol = new FlattenBinaryTreetoLinkedList().new Solution_2();
            sol.flatten(root);
            assertEquals(1, root.val);
            assertNull(root.left);
            assertEquals(2, root.right.val);
            assertNull(root.right.left);
            assertEquals(3, root.right.right.val);
            assertNull(root.right.right.left);
            assertEquals(4, root.right.right.right.val);
            assertNull(root.right.right.right.left);
            assertEquals(5, root.right.right.right.right.val);
            assertNull(root.right.right.right.right.left);
            assertEquals(6, root.right.right.right.right.right.val);
            assertNull(root.right.right.right.right.right.left);
            assertNull(root.right.right.right.right.right.right);
        }
    }
}
