package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSameTree {

    @Test
    public void test1() {
        SameTree.Solution sol = new SameTree().new Solution();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root2.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root2.right = new TreeNode(3);
        assertTrue(sol.isSameTree(root1, root2));
    }

}
