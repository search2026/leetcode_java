package lowest_common_ancestor_of_a_binary_search_tree;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LowestCommonAncestorofaBinarySearchTree {
    /*
        Lowest Common Ancestor of a Binary Search Tree
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
        Difficulty: Easy
     */
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return root;
            }

            if (root.val > p.val && root.val < q.val) {
                return root;
            } else if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }

            return root;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LowestCommonAncestorofaBinarySearchTree().new Solution();
            assertTrue(true);
        }
    }
}

