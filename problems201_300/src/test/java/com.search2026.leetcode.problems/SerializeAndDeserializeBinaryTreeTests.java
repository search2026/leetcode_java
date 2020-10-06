package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializeAndDeserializeBinaryTreeTests {

    @Test
    public void testSolution() {
        SerializeAndDeserializeBinaryTree.Codec_1 sol = new SerializeAndDeserializeBinaryTree().new Codec_1();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(-2);

        String serialized = sol.serialize(root);
        assertEquals("1 3 2 # # -2 # # # ", sol.serialize(root));

        TreeNode deseralized = sol.deserialize(serialized);
        assertEquals(1, deseralized.val);
        assertEquals(3, deseralized.left.val);
        assertEquals(2, deseralized.right.val);
        assertEquals(-2, deseralized.right.left.val);
    }

    @Test
    public void testSolution2() {
        SerializeAndDeserializeBinaryTree.Codec_2 sol = new SerializeAndDeserializeBinaryTree().new Codec_2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(-2);

        String serialized = sol.serialize(root);
        assertEquals("1 3 # # 2 -2 # # #", sol.serialize(root));

        TreeNode deseralized = sol.deserialize(serialized);
        assertEquals(1, deseralized.val);
        assertEquals(3, deseralized.left.val);
        assertEquals(2, deseralized.right.val);
        assertEquals(-2, deseralized.right.left.val);
    }

    @Test
    public void testSolution3() {
        SerializeAndDeserializeBinaryTree.Codec_3 sol = new SerializeAndDeserializeBinaryTree().new Codec_3();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(-2);

        String serialized = sol.serialize(root);
        assertEquals("1 3 # # 2 -2 # # # ", sol.serialize(root));

        TreeNode deseralized = sol.deserialize(serialized);
        assertEquals(1, deseralized.val);
        assertEquals(3, deseralized.left.val);
        assertEquals(2, deseralized.right.val);
        assertEquals(-2, deseralized.right.left.val);
    }

}
