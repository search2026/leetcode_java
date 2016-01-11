package binary_tree_zigzag_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BinaryTreeZigzagLevelOrderTraversal {
    /*
        Binary Tree Zigzag Level Order Traversal
        https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            if (root == null) return rslt;
            LinkedList<TreeNode> stack1 = new LinkedList<TreeNode>();
            LinkedList<TreeNode> stack2 = new LinkedList<TreeNode>();
            stack1.push(root);
            int level = 0;
            while (!stack1.isEmpty()) {
                ArrayList<Integer> item = new ArrayList<Integer>();
                while (!stack1.isEmpty()) {
                    root = stack1.pop();
                    item.add(root.val);
                    if (level % 2 == 0) {
                        if (root.left != null) stack2.push(root.left);
                        if (root.right != null) stack2.push(root.right);
                    }
                    else {
                        if (root.right != null) stack2.push(root.right);
                        if (root.left != null) stack2.push(root.left);
                    }
                }
                rslt.add(new ArrayList<Integer>(item));
                stack1 = stack2;
                stack2 = new LinkedList<TreeNode>();
                level++;
            }
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
            assertTrue(true);
        }
    }
}
