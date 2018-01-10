package binary_tree_inorder_traversal;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeInorderTraversal {
    /*
        Binary Tree Inorder Traversal - Using Stacks
        Leetcode #94
        https://leetcode.com/problems/binary-tree-inorder-traversal/
        Difficulty: Medium
    */
    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> rslt = new ArrayList<Integer>();
            if (root == null) return rslt;

            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            TreeNode p = root;

            while (!stack.isEmpty() || p != null) {
                if (p != null) {
                    stack.offerLast(p);
                    p = p.left;
                } else {
                    p = stack.removeLast();
                    rslt.add(p.val);
                    p = p.right;
                }
            }

            return rslt;
        }
    }

    /*
        Binary Tree Inorder Traversal - Morris Traversal
        Leetcode #94
        https://leetcode.com/problems/binary-tree-inorder-traversal/
        Difficulty: Medium
    */
    public class Solution_2 {
        public List<Integer> inorderTraversal(TreeNode root) {
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
                        temp.right = p;
                        p = p.left;
                    } else {
                        rslt.add(p.val);
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
            Solution sol = new BinaryTreeInorderTraversal().new Solution();
            assertEquals(1, 1);
        }
    }
}
