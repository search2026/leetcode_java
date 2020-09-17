package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeLevelOrderTraversalTests {

    @Test
    public void testSolution() {
        BinaryTreeLevelOrderTraversal.Solution sol = new BinaryTreeLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = sol.levelOrder(root);
        assertEquals(3, res.size());
        assertEquals(1, res.get(0).size());
        assertEquals(3, (int) res.get(0).get(0));
        assertEquals(2, res.get(1).size());
        assertEquals(9, (int) res.get(1).get(0));
        assertEquals(20, (int) res.get(1).get(1));
        assertEquals(2, res.get(2).size());
        assertEquals(15, (int) res.get(2).get(0));
        assertEquals(7, (int) res.get(2).get(1));
    }

    @Test
    public void testSolution2() {
        BinaryTreeLevelOrderTraversal.Solution_2 sol = new BinaryTreeLevelOrderTraversal().new Solution_2();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = sol.levelOrder(root);
        assertEquals(3, res.size());
        assertEquals(1, res.get(0).size());
        assertEquals(3, (int) res.get(0).get(0));
        assertEquals(2, res.get(1).size());
        assertEquals(9, (int) res.get(1).get(0));
        assertEquals(20, (int) res.get(1).get(1));
        assertEquals(2, res.get(2).size());
        assertEquals(15, (int) res.get(2).get(0));
        assertEquals(7, (int) res.get(2).get(1));
    }

    @Test
    public void testSolution3() {
        BinaryTreeLevelOrderTraversal.Solution_3 sol = new BinaryTreeLevelOrderTraversal().new Solution_3();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = sol.levelOrderBottom(root);
        assertEquals(3, res.size());
        assertEquals(2, res.get(0).size());
        assertEquals(15, (int) res.get(0).get(0));
        assertEquals(7, (int) res.get(0).get(1));
        assertEquals(2, res.get(1).size());
        assertEquals(9, (int) res.get(1).get(0));
        assertEquals(20, (int) res.get(1).get(1));
        assertEquals(1, res.get(2).size());
        assertEquals(3, (int) res.get(2).get(0));
    }

}
