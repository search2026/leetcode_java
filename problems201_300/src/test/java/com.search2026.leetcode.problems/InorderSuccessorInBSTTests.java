package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeCellRenderer;

import static org.junit.jupiter.api.Assertions.*;

public class InorderSuccessorInBSTTests {

    @Test
    public void testSolution() {
        InorderSuccessorInBST.Solution sol = new InorderSuccessorInBST().new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode res = sol.inorderSuccessor(root, root.left);
        assertEquals(2, res.val);
    }

}
