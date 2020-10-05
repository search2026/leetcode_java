package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowestCommonAncestorOfABinarySearchTreeTests {

    @Test
    public void test1() {
        TreeNode node_0 = new TreeNode(0);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_8 = new TreeNode(8);
        TreeNode node_9 = new TreeNode(9);
        TreeNode root = node_6;
        root.left = node_2;
        root.right = node_8;
        root.left.left = node_0;
        root.left.right = node_4;
        root.left.right.left = node_3;
        root.left.right.left = node_5;
        root.right.left = node_7;
        root.right.right = node_9;

        LowestCommonAncestorOfABinarySearchTree.Solution sol =
                new LowestCommonAncestorOfABinarySearchTree().new Solution();
        TreeNode common = sol.lowestCommonAncestor(root, node_2, node_8);
        assertEquals(6, common.val);
        common = sol.lowestCommonAncestor(root, node_2, node_5);
        assertEquals(2, common.val);
    }

    @Test
    public void test2() {
        TreeNode node_0 = new TreeNode(0);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_8 = new TreeNode(8);
        TreeNode node_9 = new TreeNode(9);
        TreeNode root = node_6;
        root.left = node_2;
        root.right = node_8;
        root.left.left = node_0;
        root.left.right = node_4;
        root.left.right.left = node_3;
        root.left.right.left = node_5;
        root.right.left = node_7;
        root.right.right = node_9;

        LowestCommonAncestorOfABinarySearchTree.Solution_2 sol =
                new LowestCommonAncestorOfABinarySearchTree().new Solution_2();
        TreeNode common = sol.lowestCommonAncestor(root, node_2, node_8);
        assertEquals(6, common.val);
        common = sol.lowestCommonAncestor(root, node_2, node_5);
        assertEquals(2, common.val);
    }

}
