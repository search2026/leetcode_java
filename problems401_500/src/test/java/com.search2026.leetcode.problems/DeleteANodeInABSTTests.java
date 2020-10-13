package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeCellRenderer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteANodeInABSTTests {

    @Test
    public void testSolution() {
        DeleteANodeInABST.Solution sol = new DeleteANodeInABST().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TreeNode res = sol.deleteNode(root, 3);
        assertEquals(5, root.val);
        assertEquals(4, root.left.val);
        assertEquals(6, root.right.val);
    }

    @Test
    public void testSolution2() {
        DeleteANodeInABST.Solution_2 sol = new DeleteANodeInABST().new Solution_2();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TreeNode res = sol.deleteNode(root, 3);
        assertEquals(5, root.val);
        assertEquals(4, root.left.val);
        assertEquals(6, root.right.val);
    }

}
