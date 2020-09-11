package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinaryTreeInorderTraversal {

    @Test
    public void test1() {
        BinaryTreeInorderTraversal.Solution sol = new BinaryTreeInorderTraversal().new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = sol.inorderTraversal(root);
        assertEquals(3, res.size());
        assertEquals(1, res.get(0));
        assertEquals(3, res.get(0));
        assertEquals(2, res.get(0));
    }

}
