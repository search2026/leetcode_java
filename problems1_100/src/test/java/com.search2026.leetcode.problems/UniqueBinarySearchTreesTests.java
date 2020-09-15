package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UniqueBinarySearchTreesTests {

    @Test
    public void testSolution() {
        UniqueBinarySearchTrees.Solution sol = new UniqueBinarySearchTrees().new Solution();
        assertEquals(5, sol.numTrees(3));
    }

    @Test
    public void testSolution2() {
        UniqueBinarySearchTrees.Solution_2 sol = new UniqueBinarySearchTrees().new Solution_2();
        assertEquals(5, sol.numTrees(3));
    }

    @Test
    public void testSolution3() {
        UniqueBinarySearchTrees.Solution_3 sol = new UniqueBinarySearchTrees().new Solution_3();
        List<TreeNode> res = sol.generateTrees(3);
        assertEquals(5, res.size());
    }

}
