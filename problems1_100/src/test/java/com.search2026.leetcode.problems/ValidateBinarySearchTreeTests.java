package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateBinarySearchTreeTests {

    @Test
    public void testSolution() {
        ValidateBinarySearchTree.Solution sol = new ValidateBinarySearchTree().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        assertTrue(sol.isValidBST(root));

        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(8);
        assertFalse(sol.isValidBST(root));
    }

    @Test
    public void testSolution2() {
        ValidateBinarySearchTree.Solution_2 sol = new ValidateBinarySearchTree().new Solution_2();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        assertTrue(sol.isValidBST(root));

        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(8);
        assertFalse(sol.isValidBST(root));
    }

}
