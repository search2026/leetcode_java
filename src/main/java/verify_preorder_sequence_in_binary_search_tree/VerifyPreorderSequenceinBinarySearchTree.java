package verify_preorder_sequence_in_binary_search_tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class VerifyPreorderSequenceinBinarySearchTree {
    /*
        Verify Preorder Sequence in Binary Search Tree
        Leetcode #255
        https://leetcode.com/discuss/questions/oj/verify-preorder-sequence-in-binary-search-tree?sort=votes
        http://buttercola.blogspot.com/2015/09/leetcode-verify-preorder-sequence-in.html
        Difficulty: Easy
     */
    public class Solution {
        public boolean verifyPreorder(int[] preorder) {
            if (preorder == null || preorder.length <= 1) {
                return true;
            }

            Stack<Integer> stack = new Stack<Integer>();
            List<Integer> list = new ArrayList<Integer>();

            for (int num : preorder) {
                if (!list.isEmpty() && num < list.get(list.size() - 1)) {
                    return false;
                }

                while (!stack.isEmpty() && num > stack.peek()) {
                    list.add(stack.pop());
                }

                stack.push(num);
            }

            return true;
        }
    }

    /*
        Verify Preorder Sequence in Binary Search Tree constant space
        Leetcode #255
        https://leetcode.com/discuss/questions/oj/verify-preorder-sequence-in-binary-search-tree?sort=votes
        http://buttercola.blogspot.com/2015/09/leetcode-verify-preorder-sequence-in.html
        Difficulty: Easy
   */
    public class Solution_2 {
        public boolean verifyPreorder(int[] preorder) {
            if (preorder == null || preorder.length <= 1) {
                return true;
            }

            Stack<Integer> stack = new Stack<Integer>();
            int max = Integer.MIN_VALUE;

            for (int num : preorder) {
                if (num < max) {
                    return false;
                }

                while (!stack.isEmpty() && num > stack.peek()) {
                    max = stack.pop();
                }

                stack.push(num);
            }

            return true;
        }
    }

    /*
        Verify Preorder Sequence in Binary Search Tree using one stack
        Leetcode #255
        https://leetcode.com/discuss/questions/oj/verify-preorder-sequence-in-binary-search-tree?sort=votes
        http://buttercola.blogspot.com/2015/09/leetcode-verify-preorder-sequence-in.html
        Difficulty: Easy
   */
    public class SolutionIII {
        public boolean verifyPreorder(int[] preorder) {
            if (preorder == null || preorder.length <= 1) {
                return true;
            }

            int i = -1;
            int max = Integer.MIN_VALUE;

            for (int num : preorder) {
                if (num < max) {
                    return false;
                }

                while (i >= 0 && num > preorder[i]) {
                    max = preorder[i];
                    i--;
                }

                i++;
                preorder[i] = num;
            }

            return true;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new VerifyPreorderSequenceinBinarySearchTree().new Solution();
            assertTrue(true);
        }
    }
}
