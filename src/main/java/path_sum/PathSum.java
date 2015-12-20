package path_sum;

import org.junit.Test;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return sum == root.val;
            }
            return hasPathSum(root.left, sum - root.val)
                    || hasPathSum(root.right, sum - root.val);
        }

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            if (root != null) {
                pathSum(root, sum, new ArrayList<Integer>(), ans);
            }
            return ans;
        }

        // Path Sum II
        private void pathSum(TreeNode root, int sum, ArrayList<Integer> nodes,
                             List<List<Integer>> ans) {
            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(nodes);
                    temp.add(root.val);
                    ans.add(temp);
                }
                return;
            }
            nodes.add(root.val);
            if (root.left != null) {
                pathSum(root.left, sum - root.val, nodes, ans);
            }
            if (root.right != null) {
                pathSum(root.right, sum - root.val, nodes, ans);
            }
            nodes.remove(nodes.size() - 1);
        }
    }

    public static class UnitTest {

        @Test
        public void test() {
            new PathSum().new Solution().hasPathSum(new TreeNode(1), 1);
        }
    }
}
