package binary_tree_preorder_traversal;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreePreorderTraversal {
    /*
        Binary Tree Preorder Traversal - Using Stacks
        Leetcode #144
        https://leetcode.com/problems/binary-tree-preorder-traversal/
        Difficulty: Medium
    */
    public class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> rslt = new ArrayList<Integer>();
            if (root == null)
                return rslt;

            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            TreeNode p = root;

            while (!stack.isEmpty() || p != null) {
                if (p != null) {
                    stack.offerLast(p);
                    rslt.add(p.val);
                    p = p.left;
                } else {
                    p = stack.removeLast();
                    p = p.right;
                }
            }

            return rslt;
        }
    }

    /*
        Binary Tree Preorder Traversal - Morris Traversal
        Leetcode #144
        https://leetcode.com/problems/binary-tree-preorder-traversal/
        Difficulty: Medium
    */
    public class Solution_2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> rslt = new ArrayList<Integer>();
            TreeNode p = root;
            while (p != null) {
                if (p.left == null) {
                    rslt.add(p.val);
                    p = p.right;
                } else {
                    TreeNode temp = p.left;
                    while (temp.right != null && temp.right != p) {
                        temp = temp.right;
                    }
                    if (temp.right == null) {
                        rslt.add(p.val);
                        temp.right = p;
                        p = p.left;
                    } else {
                        temp.right = null;
                        p = p.right;
                    }
                }
            }
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreePreorderTraversal().new Solution();
            assertEquals(1, 1);
        }
    }
}
