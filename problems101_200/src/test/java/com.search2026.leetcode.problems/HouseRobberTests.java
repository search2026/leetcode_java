package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseRobberTests {

    @Test
    public void testSolution() {
        HouseRobber.Solution sol = new HouseRobber().new Solution();
        int[] test1 = {5, 6, 3, 1};
        assertEquals(8, sol.rob(test1));
        int[] test2 = {6, 5, 0, 1, 0, 9};
        assertEquals(16, sol.rob(test2));
        int[] test3 = {5, 1, 1, 5};
        assertEquals(10, sol.rob(test3));
        int[] test4 = {3, 6, 4};
        assertEquals(7, sol.rob(test4));
        int[] test5 = {4, 10, 3, 1, 5};
        assertEquals(15, sol.rob(test5));
    }

    @Test
    public void testSolution2() {
        HouseRobber.Solution_2 sol = new HouseRobber().new Solution_2();
        int[] test1 = {5, 6, 3, 1};
        assertEquals(8, sol.rob(test1));
        int[] test2 = {6, 5, 0, 1, 0, 9};
        assertEquals(16, sol.rob(test2));
        int[] test3 = {5, 1, 1, 5};
        assertEquals(10, sol.rob(test3));
        int[] test4 = {3, 6, 4};
        assertEquals(7, sol.rob(test4));
        int[] test5 = {4, 10, 3, 1, 5};
        assertEquals(15, sol.rob(test5));
    }

    @Test
    public void testSolution3() {
        HouseRobber.Solution_3 sol = new HouseRobber().new Solution_3();
        int[] test1 = {5, 6, 3, 1};
        assertEquals(8, sol.rob(test1));
        int[] test2 = {6, 5, 0, 1, 0, 9};
        assertEquals(16, sol.rob(test2));
        int[] test3 = {5, 1, 1, 5};
        assertEquals(10, sol.rob(test3));
        int[] test4 = {3, 6, 4};
        assertEquals(7, sol.rob(test4));
        int[] test5 = {4, 10, 3, 1, 5};
        assertEquals(15, sol.rob(test5));
    }

    @Test
    public void testSolution4() {
        HouseRobber.Solution_4 sol = new HouseRobber().new Solution_4();
        int[] test1 = {5, 6, 3, 1};
        assertEquals(8, sol.rob(test1));
        int[] test2 = {6, 5, 0, 1, 0, 9};
        assertEquals(15, sol.rob(test2));
    }

    @Test
    public void testSolution5() {
        HouseRobber.Solution_5 sol = new HouseRobber().new Solution_5();
        int[] test1 = {5, 6, 3, 1};
        assertEquals(8, sol.rob(test1));
        int[] test2 = {6, 5, 0, 1, 0, 9};
        assertEquals(15, sol.rob(test2));
    }

    @Test
    public void testSolution6() {
        HouseRobber.Solution_6 sol = new HouseRobber().new Solution_6();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        assertEquals(7, sol.rob(root));

        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        assertEquals(9, sol.rob(root));
    }

    @Test
    public void testSolution7() {
        HouseRobber.Solution_7 sol = new HouseRobber().new Solution_7();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        assertEquals(7, sol.rob(root));

        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        assertEquals(9, sol.rob(root));
    }

}
