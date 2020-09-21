package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreePreorderTraversalTests {

    @Test
    public void testSolution() {
        BinaryTreePreorderTraversal.Solution sol = new BinaryTreePreorderTraversal().new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = sol.preorderTraversal(root);
        assertEquals(3, res.size());
        assertEquals(1, res.get(0));
        assertEquals(2, res.get(1));
        assertEquals(3, res.get(2));
    }

}
