package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeZigzagLevelOrderTraversalTests {

    @Test
    public void testSolution() {
        BinaryTreeZigzagLevelOrderTraversal.Solution sol = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = sol.zigzagLevelOrder(root);
        assertEquals(3, res.size());
        assertEquals(1, res.get(0).size());
        assertEquals(3, (int) res.get(0).get(0));
        assertEquals(2, res.get(1).size());
        assertEquals(20, (int) res.get(1).get(0));
        assertEquals(9, (int) res.get(1).get(1));
        assertEquals(2, res.get(2).size());
        assertEquals(15, (int) res.get(2).get(0));
        assertEquals(7, (int) res.get(2).get(1));
    }

    @Test
    public void testSolution2() {
        BinaryTreeZigzagLevelOrderTraversal.Solution_2 sol = new BinaryTreeZigzagLevelOrderTraversal().new Solution_2();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = sol.zigzagLevelOrder(root);
        assertEquals(3, res.size());
        assertEquals(1, res.get(0).size());
        assertEquals(3, (int) res.get(0).get(0));
        assertEquals(2, res.get(1).size());
        assertEquals(20, (int) res.get(1).get(0));
        assertEquals(9, (int) res.get(1).get(1));
        assertEquals(2, res.get(2).size());
        assertEquals(15, (int) res.get(2).get(0));
        assertEquals(7, (int) res.get(2).get(1));
    }

}
