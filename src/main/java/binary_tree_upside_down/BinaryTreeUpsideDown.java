package binary_tree_upside_down;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeUpsideDown {
    /*
        Binary Tree Upside Down
        http://www.cnblogs.com/EdwardLiu/p/4232896.html
        Difficulty: Medium
     */
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
        @Test
        public void test1() {
            Solution sol = new BinaryTreeUpsideDown().new Solution();
            assertTrue(true);
        }
    }
};
