package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PathSumTests {

    @Test
    public void testSolution() {
        PathSum.Solution sol = new PathSum().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        assertTrue(sol.hasPathSum(root, 26));
        assertFalse(sol.hasPathSum(root, 25));
    }

    @Test
    public void testSolution2() {
        PathSum.Solution_2 sol = new PathSum().new Solution_2();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        List<List<Integer>> res = sol.pathSum(root, 26);
        assertEquals(1, res.size());
    }

}
