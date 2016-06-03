package binary_tree_paths;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BinaryTreePaths {
    /*
        Binary Tree Paths
        Leetcode #257
        https://leetcode.com/problems/binary-tree-paths/
        Difficulty: Easy
     */
    public class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> rslt = new ArrayList<String>();
            if (root == null) return rslt;
            helper(root, rslt, "");
            return rslt;
        }

        public void helper(TreeNode root, List<String> rslt, String item) {
            if (root.left == null && root.right == null) {
                if (item.length() == 0) {
                    rslt.add("" + root.val);
                } else {
                    rslt.add(item + "->" + root.val);
                }
                return;
            }
            if (root.left != null)
                helper(root.left, rslt, item.length()==0? ""+root.val : item+"->"+root.val);
            if (root.right != null)
                helper(root.right, rslt, item.length()==0? ""+root.val : item+"->"+root.val);

        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreePaths().new Solution();
            assertTrue(true);
        }
    }
}
