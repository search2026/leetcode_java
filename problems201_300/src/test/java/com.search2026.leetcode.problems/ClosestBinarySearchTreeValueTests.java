package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClosestBinarySearchTreeValueTests {

    @Test
    public void testSolution() {
        ClosestBinarySearchTreeValue.Solution sol = new ClosestBinarySearchTreeValue().new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        assertEquals(4, sol.closestValue(root, 3.714286));
    }

    @Test
    public void testSolution2() {
        ClosestBinarySearchTreeValue.Solution_2 sol = new ClosestBinarySearchTreeValue().new Solution_2();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        assertEquals(4, sol.closestValue(root, 3.714286));
    }


    @Test
    public void testSolution3() {
        ClosestBinarySearchTreeValue.Solution_3 sol = new ClosestBinarySearchTreeValue().new Solution_3();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        List<Integer> res = sol.closestKValues(root, 3.714286, 2);
        assertEquals(2, res.size());
        assertTrue(res.contains(3));
        assertTrue(res.contains(4));
    }

}
