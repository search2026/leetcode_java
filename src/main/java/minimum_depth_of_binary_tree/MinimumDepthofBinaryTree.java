package minimum_depth_of_binary_tree;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumDepthofBinaryTree {
    /*
        Minimum Depth of Binary Tree
        https://leetcode.com/problems/minimum-depth-of-binary-tree/
        leetcode 111
        Difficulty: Easy
     */
    public class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;

            int l = minDepth(root.left);
            int r = minDepth(root.right);
            if (l == 0) return r + 1;
            if (r == 0) return l + 1;

            return Math.min(l, r) + 1;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MinimumDepthofBinaryTree().new Solution();
            assertEquals(3, 3);
        }
    }
}
