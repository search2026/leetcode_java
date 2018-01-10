package unique_binary_search_trees;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UniqueBinarySearchTrees {
    /*
        Unique Binary Search Trees
        Leetcode #96
        https://leetcode.com/problems/unique-binary-search-trees/
        Difficulty: Medium
    */
    public class Solution {
        public int numTrees(int n) {
            long c = 1;
            for (int i = 2; i <= n; i++) {
                c = c * 2 * (2 * i - 1) / (i + 1);
            }
            return (int) c;
        }
    }

    /*
        Unique Binary Search Trees
        Leetcode #96
        https://leetcode.com/problems/unique-binary-search-trees/
        Difficulty: Medium
    */
    public class Solution_2 {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                int tmp = 0;
                for (int j = 0; j < i; j++) {
                    tmp += dp[j] * dp[i - j - 1];
                }
                dp[i] = tmp;
            }
            return dp[n];
        }
    }

    /*
        Unique Binary Search Trees II
        Leetcode #95
        https://leetcode.com/problems/unique-binary-search-trees-ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        public List<TreeNode> search(int left, int right) {
            ArrayList<TreeNode> rslt = new ArrayList<TreeNode>();
            if (left > right) {
                rslt.add(null);
                return rslt;
            }
            for (int k = left; k <= right; k++) {
                List<TreeNode> leftTrees = search(left, k - 1);
                List<TreeNode> rightTrees = search(k + 1, right);
                for (int i = 0; i < leftTrees.size(); i++) {
                    for (int j = 0; j < rightTrees.size(); j++) {
                        TreeNode root = new TreeNode(k);
                        root.left = leftTrees.get(i);
                        root.right = rightTrees.get(j);
                        rslt.add(root);
                    }
                }
            }
            return rslt;
        }

        public List<TreeNode> generateTrees(int n) {
            if (n <= 0) return new ArrayList<TreeNode>();
            return search(1, n);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new UniqueBinarySearchTrees().new Solution();
            assertTrue(true);
        }
    }
}
