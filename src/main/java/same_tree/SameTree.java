package same_tree;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SameTree {
    /*
        Same Tree
        https://leetcode.com/problems/same-tree/
        leetcode 100
        Difficulty: Easy
     */
    public class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == q) {
                return true;
            }
            if (p != null && q != null) {
                return p.val == q.val && isSameTree(p.left, q.left)
                        && isSameTree(p.right, q.right);
            }
            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SameTree().new Solution();
            assertEquals(7, 7);
        }
    }
}
