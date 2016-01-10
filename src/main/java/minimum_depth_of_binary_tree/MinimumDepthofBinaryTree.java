package minimum_depth_of_binary_tree;

import common.TreeNode;

public class MinimumDepthofBinaryTree {

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

    }
}
