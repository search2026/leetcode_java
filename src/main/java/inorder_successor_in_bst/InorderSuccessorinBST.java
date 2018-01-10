package inorder_successor_in_bst;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InorderSuccessorinBST {
    /*
        Inorder Successor in BST
        Leetcode #285
        https://leetcode.com/discuss/questions/oj/inorder-successor-in-bst?sort=votes
        Difficulty: Medium
     */
    public class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null || p == null) {
                return null;
            }

            if (p.right != null) {
                return findMin(p.right);
            }

            // Case 2: p.right == null
            TreeNode succ = null;
            TreeNode q = root;

            while (q != null) {
                if (q.val > p.val) {
                    succ = q;
                    q = q.left;
                } else if (q.val < p.val) {
                    q = q.right;
                } else {
                    break;
                }
            }

            return succ;
        }

        private TreeNode findMin(TreeNode root) {
            TreeNode p = root;

            while (p.left != null) {
                p = p.left;
            }

            return p;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new InorderSuccessorinBST().new Solution();
            assertTrue(true);
        }
    }
}
