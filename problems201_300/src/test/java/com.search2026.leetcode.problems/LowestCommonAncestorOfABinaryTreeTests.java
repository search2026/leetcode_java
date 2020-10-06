package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowestCommonAncestorOfABinaryTreeTests {

    @Test
    public void testSolution() {
        TreeNode node_0 = new TreeNode(0);
        TreeNode node_1 = new TreeNode(0);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_8 = new TreeNode(8);
        TreeNode node_9 = new TreeNode(9);
        TreeNode root = node_3;
        root.left = node_5;
        root.right = node_1;
        root.left.left = node_6;
        root.left.right = node_2;
        root.left.right.left = node_7;
        root.left.right.left = node_4;
        root.right.left = node_0;
        root.right.right = node_8;

        LowestCommonAncestorOfABinaryTree.Solution sol = new LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode common = sol.lowestCommonAncestor(root, node_1, node_5);
        assertEquals(3, common.val);
        common = sol.lowestCommonAncestor(root, node_4, node_5);
        assertEquals(5, common.val);
    }

    @Test
    public void test2() {
        TreeNode node_0 = new TreeNode(0);
        TreeNode node_1 = new TreeNode(0);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_8 = new TreeNode(8);
        TreeNode node_9 = new TreeNode(9);
        TreeNode root = node_3;
        root.left = node_5;
        root.right = node_1;
        root.left.left = node_6;
        root.left.right = node_2;
        root.left.right.left = node_7;
        root.left.right.left = node_4;
        root.right.left = node_0;
        root.right.right = node_8;

        LowestCommonAncestorOfABinaryTree.Solution_2 sol = new LowestCommonAncestorOfABinaryTree().new Solution_2();
        TreeNode common = sol.lowestCommonAncestor(root, node_1, node_5);
        assertEquals(3, common.val);
        common = sol.lowestCommonAncestor(root, node_4, node_5);
        assertEquals(5, common.val);
    }

    @Test
    public void test3() {
        TreeNode node_0 = new TreeNode(0);
        TreeNode node_1 = new TreeNode(0);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_8 = new TreeNode(8);
        TreeNode node_9 = new TreeNode(9);
        TreeNode root = node_3;
        root.left = node_5;
        root.right = node_1;
        root.left.left = node_6;
        root.left.right = node_2;
        root.left.right.left = node_7;
        root.left.right.left = node_4;
        root.right.left = node_0;
        root.right.right = node_8;

        LowestCommonAncestorOfABinaryTree.Solution_3 sol = new LowestCommonAncestorOfABinaryTree().new Solution_3();
        TreeNode common = sol.lowestCommonAncestor(root, node_1, node_5);
        assertEquals(3, common.val);
        common = sol.lowestCommonAncestor(root, node_4, node_5);
        assertEquals(5, common.val);
    }

}
