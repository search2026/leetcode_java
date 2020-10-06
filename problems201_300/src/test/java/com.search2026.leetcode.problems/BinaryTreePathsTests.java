package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreePathsTests {

    @Test
    public void testSolution() {
        BinaryTreePaths.Solution sol = new BinaryTreePaths().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> res = sol.binaryTreePaths(root);
        assertEquals(2, res.size());
        assertEquals("1->2->5", res.get(0));
        assertEquals("1->3", res.get(1));
    }

}
