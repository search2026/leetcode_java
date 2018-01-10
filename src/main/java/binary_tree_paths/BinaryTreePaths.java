package binary_tree_paths;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreePaths {
    /*
        Binary Tree Paths
        Leetcode #257
        https://leetcode.com/problems/binary-tree-paths/
        Difficulty: Easy
     */
    public class Solution {
        private void search(TreeNode root, List<String> res, String s) {
            if (root.left == null && root.right == null) res.add(s + root.val);
            if (root.left != null) search(root.left, res, s + root.val + "->");
            if (root.right != null) search(root.right, res, s + root.val + "->");
        }

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) return res;
            search(root, res, "");
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreePaths().new Solution();
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.right = new TreeNode(5);
            List<String> res = sol.binaryTreePaths(root);
            assertEquals(2, res.size());
            assertEquals("1->2->5", res.get(0));
            assertEquals("1->3", res.get(1));
        }
    }
}
