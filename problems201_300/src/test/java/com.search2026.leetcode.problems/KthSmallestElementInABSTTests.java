package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KthSmallestElementInABSTTests {

    @Test
    public void testSolution() {
        KthSmallestElementInABST.Solution sol = new KthSmallestElementInABST().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        assertEquals(1, sol.kthSmallest(root, 1));
        assertEquals(2, sol.kthSmallest(root, 2));
    }

    @Test
    public void testSolution2() {
        KthSmallestElementInABST.Solution_2 sol = new KthSmallestElementInABST().new Solution_2();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        assertEquals(1, sol.kthSmallest(root, 1));
        assertEquals(2, sol.kthSmallest(root, 2));
    }

    @Test
    public void testSolution3() {
        KthSmallestElementInABST.Solution_3 sol = new KthSmallestElementInABST().new Solution_3();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        assertEquals(1, sol.kthSmallest(root, 1));
        assertEquals(2, sol.kthSmallest(root, 2));
    }

}
