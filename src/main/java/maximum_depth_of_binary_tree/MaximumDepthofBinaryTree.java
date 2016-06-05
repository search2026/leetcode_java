package maximum_depth_of_binary_tree;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumDepthofBinaryTree {
    /*
        Maximum Depth of Binary Tree
        Leetcode 104
        https://leetcode.com/problems/maximum-depth-of-binary-tree/
        Difficulty: Easy
     */
    public class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MaximumDepthofBinaryTree().new Solution();
            assertEquals(3, 3);
        }
    }
}
