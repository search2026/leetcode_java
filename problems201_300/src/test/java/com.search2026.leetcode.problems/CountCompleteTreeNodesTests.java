package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountCompleteTreeNodesTests {

    @Test
    public void test1() {
        CountCompleteTreeNodes.Solution sol = new CountCompleteTreeNodes().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        assertEquals(6, sol.countNodes(root));
    }

}
