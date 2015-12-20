package binary_tree_longest_consecutive_sequence;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeLongestConsecutiveSequence {
    /*
        Binary Tree Longest Consecutive Sequence
        https://segmentfault.com/a/1190000003957798
        Difficulty: Medium
     */
    public class Solution {
        public int longestConsecutive(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return findLongest(root, 0, root.val - 1);
        }

        private int findLongest(TreeNode root, int length, int preVal) {
            if (root == null) {
                return length;
            }
            // Check if it is consecutive
            int currLen = preVal + 1 == root.val ? length + 1 : 1;

            return Math.max(currLen, Math.max(findLongest(root.left, currLen, root.val), findLongest(root.right, currLen, root.val)));
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreeLongestConsecutiveSequence().new Solution();
        }
    }
}
