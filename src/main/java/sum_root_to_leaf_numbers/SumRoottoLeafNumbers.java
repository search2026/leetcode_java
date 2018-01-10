package sum_root_to_leaf_numbers;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SumRoottoLeafNumbers {
    /*
        Sum Root to Leaf Numbers
        Leetcode #129
        https://leetcode.com/problems/sum-root-to-leaf-numbers/
        Difficulty: Medium
     */
    public class Solution {
        public int sumNumbers(TreeNode root) {
            return sumTree(root, 0);
        }

        private int sumTree(TreeNode root, int sum) {
            if (root == null)
                return 0;
            if (root.left == null && root.right == null)
                return sum * 10 + root.val;
            return sumTree(root.left, sum * 10 + root.val) + sumTree(root.right, sum * 10 + root.val);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SumRoottoLeafNumbers().new Solution();
            assertTrue(true);
        }
    }
}