package binary_tree_upside_down;

import common.TreeNode;

public class BinaryTreeUpsideDown {
    public class Solution {
        public TreeNode UpsideDownBinaryTree(TreeNode root) {
            TreeNode node = root, parent = null, right = null;
            while (node != null) {
                TreeNode left = node.left;
                node.left = right;
                right = node.right;
                node.right = parent;
                parent = node;
                node = left;
            }
            return parent;
        }
    }

    public static class UnitTest {

    }
};
