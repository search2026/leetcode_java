package binary_tree_paths;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    /*
        Binary Tree Paths
        https://leetcode.com/problems/binary-tree-paths/
        Difficulty: Easy
     */
    public class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            List<Integer> curr = new ArrayList<>();

            binaryTreePathsHelper(root, curr, result);

            return result;
        }

        private void binaryTreePathsHelper(TreeNode root, List<Integer> curr, List<String> result) {
            if (root == null) {
                return;
            }

            curr.add(root.val);

            // If is the leaf
            if (root.left == null && root.right == null) {
                StringBuffer sb = new StringBuffer();
                if (curr.size() == 1) {
                    sb.append(curr.get(0));
                    result.add(sb.toString());
                } else {
                    for (int i = 0; i < curr.size() - 1; i++) {
                        sb.append(curr.get(i));
                        sb.append("->");
                    }

                    sb.append(curr.get(curr.size() - 1));
                    result.add(sb.toString());
                }

                return;
            }

            if (root.left != null) {
                binaryTreePathsHelper(root.left, curr, result);
                curr.remove(curr.size() - 1);
            }

            if (root.right != null) {
                binaryTreePathsHelper(root.right, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static class UnitTest {

    }
}
