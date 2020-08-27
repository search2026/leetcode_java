package validate_binary_search_tree;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateBinarySearchTree {
    /*
        Validate Binary Search Tree - Top Down Recursion
        Leetcode #98
        https://leetcode.com/problems/validate-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution {
        private boolean valid(TreeNode root, long min, long max) {
            if (root == null) return true;
            return root.val > min && root.val < max &&
                    valid(root.left, min, root.val) && valid(root.right, root.val, max);
        }

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }

    /*
        Validate Binary Search Tree - In-Order Traversal
        Leetcode #98
        https://leetcode.com/problems/validate-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution_2 {
        private TreeNode inOrderPrev = null;

        private boolean isMonotonicIncreasing(TreeNode node) {
            if (node == null) return true;
            if (!isMonotonicIncreasing(node.left)) return false;
            if (inOrderPrev != null && node.val <= inOrderPrev.val) return false;
            inOrderPrev = node;
            return isMonotonicIncreasing(node.right);
        }

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            return isMonotonicIncreasing(root);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ValidateBinarySearchTree().new Solution();
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(3);
            root.right = new TreeNode(8);
            root.right.left = new TreeNode(6);
            assertTrue(sol.isValidBST(root));

            root = new TreeNode(5);
            root.left = new TreeNode(3);
            root.right = new TreeNode(8);
            root.right.left = new TreeNode(8);
            assertFalse(sol.isValidBST(root));
        }

        @Test
        public void test2() {
            Solution_2 sol = new ValidateBinarySearchTree().new Solution_2();
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(3);
            root.right = new TreeNode(8);
            root.right.left = new TreeNode(6);
            assertTrue(sol.isValidBST(root));

            root = new TreeNode(5);
            root.left = new TreeNode(3);
            root.right = new TreeNode(8);
            root.right.left = new TreeNode(8);
            assertFalse(sol.isValidBST(root));
        }
    }
}
