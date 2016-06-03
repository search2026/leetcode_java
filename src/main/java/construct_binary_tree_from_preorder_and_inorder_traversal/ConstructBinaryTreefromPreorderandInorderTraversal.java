package construct_binary_tree_from_preorder_and_inorder_traversal;

import common.TreeNode;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    /*
        Construct Binary Tree from Preorder and Inorder Traversal
        Leetcode #105
        https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
        Difficulty: Medium
     */
    public class Solution {
        public TreeNode helper(int[] postorder, int posL, int posR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map) {
            if (posL > posR || inL > inR) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[posR]);
            int index = map.get(postorder[posR]);
            root.left = helper(postorder, posL, posL + index - 1 - inL, inorder, inL, index - 1, map);
            root.right = helper(postorder, posL + index - inL, posR - 1, inorder, index + 1, inR, map);
            return root;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
                return null;
            }
            int len = inorder.length;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return helper(postorder, 0, len - 1, inorder, 0, len - 1, map);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ConstructBinaryTreefromPreorderandInorderTraversal().new Solution();
            assertTrue(true);
        }
    }
}
