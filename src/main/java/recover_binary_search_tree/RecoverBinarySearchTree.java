package recover_binary_search_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class RecoverBinarySearchTree {
    /*
        Recover Binary Search Tree
        Leetcode #99
        https://leetcode.com/problems/recover-binary-search-tree/
        Difficulty: Hard
     */
    public class Solution {
        public void recoverTree(TreeNode root) {
            TreeNode first = null;
            TreeNode second = null;
            TreeNode p = root;
            TreeNode pre = null;
            while (p != null) {
                if (p.left == null) {
                    if (pre != null && pre.val > p.val) {
                        if (first == null) {
                            first = pre;
                            second = p;
                        } else {
                            second = p;
                        }
                    }
                    pre = p;
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
                        if (pre != null && pre.val > p.val) {
                            if (first == null) {
                                first = pre;
                                second = p;
                            } else {
                                second = p;
                            }
                        }
                        temp.right = null;
                        pre = p;
                        p = p.right;
                    }
                }
            }
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    /*
        Recover Binary Search Tree
        https://leetcode.com/problems/recover-binary-search-tree/
        Difficulty: Hard
     */
    public class Solution_2 {
        public void recoverTree(TreeNode root) {
            if (root  == null) return;
            ArrayList<TreeNode> inorderlist = new ArrayList<TreeNode>();
            ArrayList<TreeNode> swap = new ArrayList<TreeNode>();
            helper(root, inorderlist, swap);
            int temp = swap.get(0).val;
            swap.get(0).val = swap.get(swap.size()-1).val;
            swap.get(swap.size()-1).val = temp;
        }

        public void helper(TreeNode root, ArrayList<TreeNode> inorderlist, ArrayList<TreeNode> swap) {
            if (root == null) return;
            helper(root.left, inorderlist, swap);
            if (inorderlist.size() != 0) {
                TreeNode pre = inorderlist.get(inorderlist.size()-1);
                if (pre.val > root.val) { //findRoot a case that has been swapped
                    swap.add(pre);
                    swap.add(root);
                }
            }
            inorderlist.add(root);
            helper(root.right, inorderlist, swap);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RecoverBinarySearchTree().new Solution();
            assertTrue(true);
        }
    }
}
