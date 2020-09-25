package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeUpsideDownTests {

    @Test
    public void test1() {
        BinaryTreeUpsideDown.Solution sol = new BinaryTreeUpsideDown().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        TreeNode upSideDown = sol.UpsideDownBinaryTree(root);

        assertEquals(2, upSideDown.val);
        assertEquals(3, upSideDown.left.val);
        assertEquals(1, upSideDown.right.val);
        assertEquals(4, upSideDown.left.left.val);
        assertEquals(5, upSideDown.left.right.val);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        upSideDown = sol.UpsideDownBinaryTree(root);

        assertEquals(4, upSideDown.val);
        assertEquals(5, upSideDown.left.val);
        assertEquals(2, upSideDown.right.val);
        assertEquals(3, upSideDown.right.left.val);
        assertEquals(1, upSideDown.right.right.val);
    }

    @Test
    public void test2() {
        BinaryTreeUpsideDown.Solution_2 sol = new BinaryTreeUpsideDown().new Solution_2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        TreeNode upSideDown = sol.UpsideDownBinaryTree(root);

        assertEquals(2, upSideDown.val);
        assertEquals(3, upSideDown.left.val);
        assertEquals(1, upSideDown.right.val);
        assertEquals(4, upSideDown.left.left.val);
        assertEquals(5, upSideDown.left.right.val);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        upSideDown = sol.UpsideDownBinaryTree(root);

        assertEquals(4, upSideDown.val);
        assertEquals(5, upSideDown.left.val);
        assertEquals(2, upSideDown.right.val);
        assertEquals(3, upSideDown.right.left.val);
        assertEquals(1, upSideDown.right.right.val);
    }

}
