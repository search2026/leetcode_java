package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeLinkNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PopulatingNextRightPointersInEachNodeTests {

    @Test
    public void testSolution() {
        PopulatingNextRightPointersInEachNode.Solution sol = new PopulatingNextRightPointersInEachNode().new Solution();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        sol.connect(root);
        assertNull(root.next);
        assertEquals(3, root.left.next.val);
        assertNull(root.right.next);
    }

    @Test
    public void testSolution2() {
        PopulatingNextRightPointersInEachNode.Solution_2 sol = new PopulatingNextRightPointersInEachNode().new Solution_2();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        sol.connect(root);
        assertNull(root.next);
        assertEquals(3, root.left.next.val);
        assertNull(root.right.next);
    }

}
