package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestUniqueBinarySearchTrees {

    @Test
    public void test1() {
        UniqueBinarySearchTrees.Solution sol = new UniqueBinarySearchTrees().new Solution();
        assertEquals(5, sol.numTrees(5));
    }

    @Test
    public void test2() {
        UniqueBinarySearchTrees.Solution_2 sol = new UniqueBinarySearchTrees().new Solution_2();
        assertEquals(5, sol.numTrees(5));
    }


    @Test
    public void test3() {
        UniqueBinarySearchTrees.Solution_3 sol = new UniqueBinarySearchTrees().new Solution_3();
        List<TreeNode> res = sol.generateTrees(3);
        assertEquals(5, res.size());
    }

}
