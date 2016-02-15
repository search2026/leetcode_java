package largest_bst_subtree;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestBSTSubtree {
    /*
        Largest BST Subtree - New Node Structure
        http://www.cnblogs.com/Dylan-Java-NYC/p/5187436.html
        Difficulty: Medium
     */
    public class Solution {
        private Node search(TreeNode root, int[] rslt) {
            Node cur = new Node();
            if (root == null) {
                cur.isBST = true;
                return cur;
            }
            Node left = search(root.left, rslt);
            Node right = search(root.right, rslt);
            if (left.isBST && root.val > left.max && right.isBST && root.val < right.min) {
                cur.isBST = true;
                cur.min = Math.min(root.val, left.min);
                cur.max = Math.max(root.val, right.max);
                cur.size = left.size + right.size + 1;
                if (cur.size > rslt[0]) {
                    rslt[0] = cur.size;
                }
            }
            return cur;
        }

        public int largestBSTSubtree(TreeNode root) {
            int[] rslt = {0};
            search(root, rslt);
            return rslt[0];
        }
    }

    class Node {
        boolean isBST;
        int min;
        int max;
        int size;

        public Node() {
            isBST = false;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            size = 0;
        }
    }


    /*
        Largest BST Subtree
        http://codingmelon.com/2016/02/13/largest-bst-subtree-leetcode-333/
        Difficulty: Medium
     */
    public class Solution_2 {
        private boolean search(TreeNode root, int[] min, int[] max, int[] rslt) {
            if (root == null) return true;

            int[] lMin = {Integer.MAX_VALUE};
            int[] lMax = {Integer.MIN_VALUE};
            int[] lSize = {0};
            boolean isLeftValid = search(root.left, lMin, lMax, lSize);

            int[] rMin = {Integer.MAX_VALUE};
            int[] rMax = {Integer.MIN_VALUE};
            int[] rSize = {0};
            boolean isRightValid = search(root.right, rMin, rMax, rSize);

            if (!isLeftValid || !isRightValid || root.val <= lMax[0] || root.val >= rMin[0]) {
                //rslt[0] = Math.max(lSize[0], rSize[0]);
                return false;
            }

            min[0] = Math.min(lMin[0], root.val);
            max[0] = Math.max(rMax[0], root.val);
            rslt[0] = lSize[0] + rSize[0] + 1;

            return true;
        }

        public int largestBSTSubtree(TreeNode root) {
            int[] rslt = {0};
            int[] min = {0};
            int[] max = {0};
            search(root, min, max, rslt);
            return rslt[0];
        }
    }
    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LargestBSTSubtree().new Solution();
            assertEquals(1, 1);
        }
    }
}

