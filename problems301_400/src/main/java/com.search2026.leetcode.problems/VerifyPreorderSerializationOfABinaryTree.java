package com.search2026.leetcode.problems;

import java.util.StringTokenizer;

public class VerifyPreorderSerializationOfABinaryTree {

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

}
