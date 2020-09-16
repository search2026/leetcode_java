package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecoverBinarySearchTreeTests {

    @Test
    public void testSolution() {
        RecoverBinarySearchTree.Solution sol = new RecoverBinarySearchTree().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        sol.recoverTree(root);
        assertEquals(3, root.val);
    }

    @Test
    public void testSolution2() {
        RecoverBinarySearchTree.Solution_2 sol = new RecoverBinarySearchTree().new Solution_2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        sol.recoverTree(root);
        assertEquals(3, root.val);
    }

}
