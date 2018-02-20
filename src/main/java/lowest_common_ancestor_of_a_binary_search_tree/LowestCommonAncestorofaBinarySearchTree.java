package lowest_common_ancestor_of_a_binary_search_tree;

import common.TreeNode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LowestCommonAncestorofaBinarySearchTree {
    /*
        Lowest Common Ancestor of a Binary Search Tree - Recursive
        LeetCode #235
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
        Difficulty: Easy
     */
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || (root.val >= Math.min(p.val, q.val) && root.val <= Math.max(p.val, q.val))) {
                return root;
            }
            if (root.val > Math.max(p.val, q.val)) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return lowestCommonAncestor(root.right, p, q);
            }
        }
    }

    /*
        Lowest Common Ancestor of a Binary Search Tree - Iterative
        LeetCode #235
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
        Difficulty: Easy
     */
    public class Solution_2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while ((root.val - p.val) * (root.val - q.val) > 0)
                root = p.val < root.val ? root.left : root.right;
            return root;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            TreeNode node_0 = new TreeNode(0);
            TreeNode node_2 = new TreeNode(2);
            TreeNode node_3 = new TreeNode(3);
            TreeNode node_4 = new TreeNode(4);
            TreeNode node_5 = new TreeNode(5);
            TreeNode node_6 = new TreeNode(6);
            TreeNode node_7 = new TreeNode(7);
            TreeNode node_8 = new TreeNode(8);
            TreeNode node_9 = new TreeNode(9);
            TreeNode root = node_6;
            root.left = node_2;
            root.right = node_8;
            root.left.left = node_0;
            root.left.right = node_4;
            root.left.right.left = node_3;
            root.left.right.left = node_5;
            root.right.left = node_7;
            root.right.right = node_9;

            Solution sol = new LowestCommonAncestorofaBinarySearchTree().new Solution();
            TreeNode common = sol.lowestCommonAncestor(root, node_2, node_8);
            assertEquals(6, common.val);
            common = sol.lowestCommonAncestor(root, node_2, node_5);
            assertEquals(2, common.val);
        }

        @Test
        public void test2() {
            TreeNode node_0 = new TreeNode(0);
            TreeNode node_2 = new TreeNode(2);
            TreeNode node_3 = new TreeNode(3);
            TreeNode node_4 = new TreeNode(4);
            TreeNode node_5 = new TreeNode(5);
            TreeNode node_6 = new TreeNode(6);
            TreeNode node_7 = new TreeNode(7);
            TreeNode node_8 = new TreeNode(8);
            TreeNode node_9 = new TreeNode(9);
            TreeNode root = node_6;
            root.left = node_2;
            root.right = node_8;
            root.left.left = node_0;
            root.left.right = node_4;
            root.left.right.left = node_3;
            root.left.right.left = node_5;
            root.right.left = node_7;
            root.right.right = node_9;

            Solution_2 sol = new LowestCommonAncestorofaBinarySearchTree().new Solution_2();
            TreeNode common = sol.lowestCommonAncestor(root, node_2, node_8);
            assertEquals(6, common.val);
            common = sol.lowestCommonAncestor(root, node_2, node_5);
            assertEquals(2, common.val);
        }
    }
}

