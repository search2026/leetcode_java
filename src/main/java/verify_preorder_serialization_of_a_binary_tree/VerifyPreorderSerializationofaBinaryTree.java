package verify_preorder_serialization_of_a_binary_tree;

import org.junit.Test;

import java.util.StringTokenizer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VerifyPreorderSerializationofaBinaryTree {
    /*
        Verify Preorder Serialization of a Binary Tree
        Leetcode #331
        https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
        Difficulty: Medium
     */
    public class Solution {
        public boolean isValidSerialization(String preorder) {
            if (preorder == null || preorder.length() == 0) return false;
            StringTokenizer tks = new StringTokenizer(preorder, ",");
            int c = 0;
            while (tks.hasMoreTokens()) {
                String cur = tks.nextToken();
                if (cur.equals("#")) {
                    c--;
                    if (c == -1 && tks.hasMoreTokens()) return false;
                } else c++;
            }
            return (c == -1);
        }
    }

    /*
        Verify Preorder Serialization of a Binary Tree
        Leetcode #331
        https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
        Difficulty: Medium
     */
    public class Solution_2 {
        public boolean isValidSerialization(String preorder) {
            if (preorder == null || preorder.length() == 0) return false;
            String[] tks = preorder.split(",");
            int diff = 1;
            for (String token: tks) {
                diff--;
                if (diff < 0) return false;
                if (!token.equals("#")) diff += 2;
            }
            return (diff == 0) && tks[tks.length - 1].equals("#");
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new VerifyPreorderSerializationofaBinaryTree().new Solution();
            assertTrue(sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
            assertFalse(sol.isValidSerialization("1,#"));
            assertFalse(sol.isValidSerialization("9,#,#,1"));
        }

        @Test
        public void test2() {
            Solution_2 sol = new VerifyPreorderSerializationofaBinaryTree().new Solution_2();
            assertTrue(sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
            assertFalse(sol.isValidSerialization("1,#"));
            assertFalse(sol.isValidSerialization("9,#,#,1"));
        }
    }
}

