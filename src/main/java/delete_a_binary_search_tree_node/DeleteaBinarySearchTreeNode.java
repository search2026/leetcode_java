package delete_a_binary_search_tree_node;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteaBinarySearchTreeNode {
    /*
        Delete a Binary Search Tree Node
        http://www.algolist.net/Data_structures/Binary_search_tree/Removal
        Diffculty: Medium
     */
    public class Solution {
        public TreeNode deleteBSTNode(int key, TreeNode node) {
            if (node == null) return null;

            if (node.val < key) node.left = deleteBSTNode(key, node.left);
            else if (node.val > key) node.right = deleteBSTNode(key, node.right);
            else {
                if (node.right == null) return node.left;
                if (node.left == null) return node.right;
                TreeNode t = node;
                node = min(t.right);
                node.right = deleteMin(t.right);
                node.left = t.left;
            }
            return node;
        }

        private TreeNode min(TreeNode node) {
            if (node.left == null) return node;
            else return min(node.left);
        }

        private TreeNode deleteMin(TreeNode node) {
            if (node.left == null) return node.right;
            node.left = deleteMin(node.left);
            return node;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new DeleteaBinarySearchTreeNode().new Solution();
            assertEquals(1, 1);
        }
    }
}

