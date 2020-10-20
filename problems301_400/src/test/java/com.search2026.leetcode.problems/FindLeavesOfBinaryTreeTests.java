package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindLeavesOfBinaryTreeTests {

    @Test
    public void testSolution() {
        FindLeavesOfBinaryTree.Solution sol = new FindLeavesOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> leaves = sol.findLeaves(root);
        assertEquals(3, leaves.size());
        assertEquals(3, leaves.get(0).size());
        assertEquals(4, (int)leaves.get(0).get(0));
        assertEquals(5, (int)leaves.get(0).get(1));
        assertEquals(3, (int)leaves.get(0).get(2));
        assertEquals(1, leaves.get(1).size());
        assertEquals(2, (int)leaves.get(1).get(0));
        assertEquals(1, leaves.get(2).size());
        assertEquals(1, (int)leaves.get(2).get(0));
    }

    @Test
    public void testSolution2() {
        FindLeavesOfBinaryTree.Solution_2 sol = new FindLeavesOfBinaryTree().new Solution_2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> leaves = sol.findLeaves(root);
        assertEquals(3, leaves.size());
        assertEquals(3, leaves.get(0).size());
        assertEquals(4, (int)leaves.get(0).get(0));
        assertEquals(5, (int)leaves.get(0).get(1));
        assertEquals(3, (int)leaves.get(0).get(2));
        assertEquals(1, leaves.get(1).size());
        assertEquals(2, (int)leaves.get(1).get(0));
        assertEquals(1, leaves.get(2).size());
        assertEquals(1, (int)leaves.get(2).get(0));
    }

}
