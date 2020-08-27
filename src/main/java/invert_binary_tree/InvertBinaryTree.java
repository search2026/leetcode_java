package invert_binary_tree;

import java.util.*;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvertBinaryTree {
    /*
        Invert Binary Tree
        Leetcode #226
        https://leetcode.com/problems/invert-binary-tree/
        Difficulty: Easy
     */
    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            TreeNode temp = root.left;

            root.left = invertTree(root.right);
            root.right = invertTree(temp);

            return root;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new InvertBinaryTree().new Solution();
            assertTrue(true);
        }
    }
}
