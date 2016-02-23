package validate_binary_search_tree;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ValidateBinarySearchTree {
    /*
        Validate Binary Search Tree
        https://leetcode.com/problems/validate-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution {
        private boolean isValidBST(TreeNode root, int[] minMax) {
            int min = root.val;
            int max = root.val;
            if (root.left != null) {
                if (!isValidBST(root.left, minMax) || root.val <= minMax[1]) {
                    return false;
                }
                min = minMax[0];
            }
            if (root.right != null) {
                if (!isValidBST(root.right, minMax) || root.val >= minMax[0]) {
                    return false;
                }
                max = minMax[1];
            }
            minMax[0] = min;
            minMax[1] = max;
            return true;
        }

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isValidBST(root, new int[2]);
        }
    }

    /*
        Validate Binary Search Tree
        https://leetcode.com/problems/validate-binary-search-tree/
        Difficulty: Medium
     */
    public class Solution_2 {
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean check(TreeNode root, long min, long max) {
            if (root == null) return true;
            if (root.val <= min || root.val >= max) return false;
            return check(root.left, min, root.val) && check(root.right, root.val, max);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ValidateBinarySearchTree().new Solution();
            assertTrue(true);
        }
    }
}
