package count_univalue_subtrees;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CountUnivalueSubtrees {
    /*
        Count Univalue Subtrees
        Leetcode #250
        https://leetcode.com/discuss/questions/oj/count-univalue-subtrees?sort=votes
        http://buttercola.blogspot.com/2015/09/leetcode-count-univalue-subtrees.html
        Difficulty: Medium
     */
    public class Solution {
        private boolean search(TreeNode root, ArrayList<Integer> sum) {
            if (root == null) return true;
            boolean left = search(root.left, sum);
            boolean right = search(root.right, sum);
            if (left && right && (root.left==null || root.val==root.left.val) && (root.right==null || root.val==root.right.val)) {
                sum.set(0, sum.get(0)+1);
                return true;
            }
            return false;
        }

        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) return 0;
            ArrayList<Integer> sum = new ArrayList<>();
            sum.add(0);
            search(root, sum);
            return sum.get(0);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CountUnivalueSubtrees().new Solution();
            assertTrue(true);
        }
    }
}

