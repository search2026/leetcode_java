package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTests {

    @Test
    public void testSolution() {
        ConstructBinaryTreeFromPreorderAndInorderTraversal.Solution sol =
                new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = sol.buildTree(preorder, inorder);
        assertEquals(7, root.val);
    }

}
