package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeVerticalOrderTraversalTests {

    @Test
    public void testSolution() {
        BinaryTreeVerticalOrderTraversal.Solution sol = new BinaryTreeVerticalOrderTraversal().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = sol.verticalOrder(root);
        assertEquals(4, res.size());
        assertEquals(1, res.get(0).size());
        assertTrue(res.get(0).contains(9));
        assertEquals(2, res.get(1).size());
        assertTrue(res.get(1).contains(3));
        assertTrue(res.get(1).contains(15));
        assertEquals(1, res.get(2).size());
        assertTrue(res.get(2).contains(20));
        assertEquals(1, res.get(3).size());
        assertTrue(res.get(3).contains(7));
    }

}
