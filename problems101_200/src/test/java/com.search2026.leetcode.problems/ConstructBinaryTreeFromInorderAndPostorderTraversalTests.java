package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalTests {

    @Test
    public void testSolution() {
        ConstructBinaryTreeFromInorderAndPostorderTraversal.Solution sol =
                new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = sol.buildTree(inorder, postorder);
        assertEquals(3, root.val);
    }

}
