package binary_search_tree_iterator;

import java.util.ArrayDeque;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BinarySearchTreeIterator {
    /*
        Binary Search Tree Iterator
        Leetcode #173
        https://leetcode.com/problems/binary-search-tree-iterator/
        Difficulty: Medium
     */
    public class BSTIterator {

        private ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();

        private TreeNode current = null;

        public BSTIterator(TreeNode root) {
            pushNode(root);
        }

        private void pushNode(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            if (current == null) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    current = stack.pop();
                    pushNode(current.right);
                }
            }
            return true;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (hasNext()) {
                int val = current.val;
                current = null;
                return val;
            } else {
                // Follow the contract of java.util.Iterator
                throw new java.util.NoSuchElementException();
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            BSTIterator sol = new BinarySearchTreeIterator().new BSTIterator(new TreeNode(1));
            assertTrue(true);
        }
    }
}

