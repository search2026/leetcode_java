package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountUnivalueSubtreesTests {

    @Test
    public void testSolution() {
        CountUnivalueSubtrees.Solution sol = new CountUnivalueSubtrees().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        assertEquals(4, sol.countUnivalSubtrees(root));
    }

}
