package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvertBinaryTreeTests {

    @Test
    public void test1() {
        InvertBinaryTree.Solution sol = new InvertBinaryTree().new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        TreeNode res = sol.invertTree(root);
        assertEquals(4, root.val);
        assertEquals(7, root.left.val);
        assertEquals(2, root.right.val);
    }

}
