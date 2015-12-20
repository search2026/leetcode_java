package binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    public class Solution {
        private void search(TreeNode root, int level,
                            List<List<Integer>> ans) {
            if (root == null) {
                return;
            }
            if (level >= ans.size()) {
                ans.add(new ArrayList<Integer>());
            }
            ans.get(level).add(root.val);
            search(root.left, level + 1, ans);
            search(root.right, level + 1, ans);
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            search(root, 0, ans);
            return ans;
        }

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            search(root, 0, ans);
            Collections.reverse(ans);
            return ans;
        }
    }

    public static class UnitTest {

    }
}
