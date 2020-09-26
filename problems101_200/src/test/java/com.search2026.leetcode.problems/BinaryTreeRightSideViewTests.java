package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeRightSideViewTests {

    @Test
    public void testSolution() {
        BinaryTreeRightSideView.Solution sol = new BinaryTreeRightSideView().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        List<Integer> res = sol.rightSideView(root);
        assertEquals(3, res.size());
        assertEquals(1, res.get(0));
        assertEquals(3, res.get(1));
        assertEquals(4, res.get(2));
    }

}
