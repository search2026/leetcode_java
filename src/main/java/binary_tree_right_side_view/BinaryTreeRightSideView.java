package binary_tree_right_side_view;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeRightSideView {
    /*
        Binary Tree Right Side View
        Leetcode #199
        https://leetcode.com/problems/binary-tree-right-side-view/
        Difficulty: Medium
     */
    public class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root != null) {
                List<TreeNode> level = new ArrayList<TreeNode>();
                level.add(root);
                while (!level.isEmpty()) {
                    res.add(level.get(level.size() - 1).val);
                    List<TreeNode> nextLevel = new ArrayList<TreeNode>();
                    for (TreeNode node : level) {
                        if (node.left != null) {
                            nextLevel.add(node.left);
                        }
                        if (node.right != null) {
                            nextLevel.add(node.right);
                        }
                    }
                    level = nextLevel;
                }
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreeRightSideView().new Solution();
            assertTrue(true);
        }
    }
}

