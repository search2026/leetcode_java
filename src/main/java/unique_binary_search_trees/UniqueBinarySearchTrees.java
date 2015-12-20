package unique_binary_search_trees;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {

    public class Solution {
        public int numTrees1(int n) {
            // Catalan number;
            int c = 1;
            for (int i = 2; i <= n; i++) {
                c = c * 2 * (2 * i - 1) / (i + 1);
            }
            return c;
        }

        public int numTrees(int n) {
            int[] nums = new int[n + 1];
            nums[0] = 1;
            nums[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                int tmp = 0;
                for (int j = 0; j < i; j++) {
                    tmp += nums[j] * nums[i - j - 1];
                }
                nums[i] = tmp;
            }
            return nums[n];
        }
    }

    // unique binary search trees II
    public class SolutionII {
        public List<TreeNode> generateTreesRe(int l, int r) {
            ArrayList<TreeNode> res = new ArrayList<TreeNode>();
            if (l > r) {
                res.add(null);
                return res;
            }
            for (int k = l; k <= r; ++k) {
                List<TreeNode> leftTrees = generateTreesRe(l, k - 1);
                List<TreeNode> rightTrees = generateTreesRe(k + 1, r);
                for (int i = 0; i < leftTrees.size(); i++) {
                    for (int j = 0; j < rightTrees.size(); j++) {
                        TreeNode root = new TreeNode(k);
                        root.left = leftTrees.get(i);
                        root.right = rightTrees.get(j);
                        res.add(root);
                    }
                }
            }
            return res;
        }

        public List<TreeNode> generateTrees(int n) {
            if (n <= 0) return new ArrayList<TreeNode>();
            return generateTreesRe(1, n);
        }
    }
    public static class UnitTest {

    }
}
