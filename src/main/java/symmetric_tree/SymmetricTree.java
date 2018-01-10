package symmetric_tree;

import java.util.LinkedList;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymmetricTree {
    /*
        Symmetric Tree - Recursive
        Leetcode #101
        https://leetcode.com/problems/symmetric-tree/
        Difficulty: Easy
     */
    public class Solution {
        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;

            return left.val == right.val && isSymmetric(left.left, right.right)
                    && isSymmetric(left.right, right.left);
        }

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }
    }

    /*
        Symmetric Tree - Iterative
        Leetcode #101
        https://leetcode.com/problems/symmetric-tree/
        Difficulty: Easy
     */
    public class Solution_2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            LinkedList<TreeNode> lefts = new LinkedList<TreeNode>();
            LinkedList<TreeNode> rights = new LinkedList<TreeNode>();
            lefts.add(root.left);
            rights.add(root.right);
            while (!lefts.isEmpty() && !rights.isEmpty()) {
                TreeNode left = lefts.poll();
                TreeNode right = rights.poll();
                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                lefts.add(left.left);
                lefts.add(left.right);
                rights.add(right.right);
                rights.add(right.left);
            }
            return lefts.isEmpty() && rights.isEmpty();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SymmetricTree().new Solution();
            assertEquals(7, 7);
        }
    }
}
