package serialize_and_deserialize_binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SerializeandDeserializeBinaryTree {
  /*
      Serialize and Deserialize Binary Tree - BFS
      Leetcode #297
      https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
      Difficulty: Medium
   */
  public class Codec {
    private static final String SPLITER = " ";
    private static final String NULLNODE = "#";

    public String serialize(TreeNode root) {
      if (root == null) return NULLNODE;

      StringBuilder sb = new StringBuilder();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
        TreeNode curr = queue.poll();
        if (curr != null) {
          sb.append(curr.val).append(SPLITER);
          queue.offer(curr.left);
          queue.offer(curr.right);
        } else {
          sb.append(NULLNODE).append(SPLITER);
        }
      }
      return sb.toString();
    }

    public TreeNode deserialize(String data) {
      if (data == null || data.length() == 0) return null;

      data = data.trim();
      String[] tokens = data.split(SPLITER);

      Queue<TreeNode> queue = new ArrayDeque<>();
      TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
      queue.offer(root);

      int idx = 1;
      while (!queue.isEmpty() && idx < tokens.length) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          // Left child
          TreeNode curr = queue.poll();
          if (!tokens[idx].equals(NULLNODE)) {
            curr.left = new TreeNode(Integer.parseInt(tokens[idx]));
            queue.offer(curr.left);
          } else {
            curr.left = null;
          }
          idx++;
          // Right child
          if (!tokens[idx].equals(NULLNODE)) {
            curr.right = new TreeNode(Integer.parseInt(tokens[idx]));
            queue.offer(curr.right);
          } else {
            curr.right = null;
          }
          idx++;
        }
      }
      return root;
    }
  }

  /*
      Serialize and Deserialize Binary Tree - DFS
      Leetcode #297
      https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
      Difficulty: Medium
   */
  public class Codec_2 {
    private static final String SPLITER = " ";
    private static final String NULLNODE = "#";

    private void buildString(TreeNode node, StringBuilder sb) {
      if (node == null) {
        sb.append(NULLNODE).append(SPLITER);
      } else {
        sb.append(node.val).append(SPLITER);
        buildString(node.left, sb);
        buildString(node.right, sb);
      }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      buildString(root, sb);
      return sb.toString();
    }

    private TreeNode buildTree(Deque<String> nodes) {
      String val = nodes.remove();
      if (val.equals(NULLNODE)) return null;
      else {
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
      }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      Deque<String> nodes = new LinkedList<>();
      nodes.addAll(Arrays.asList(data.split(SPLITER)));
      return buildTree(nodes);
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Codec sol = new SerializeandDeserializeBinaryTree().new Codec();
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(3);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(-2);

      String seralized = sol.serialize(root);
      assertEquals("1 3 2 # # -2 # # # ", sol.serialize(root));

      TreeNode deseralized = sol.deserialize(seralized);
      assertEquals(1, deseralized.val);
      assertEquals(3, deseralized.left.val);
      assertEquals(2, deseralized.right.val);
      assertEquals(-2, deseralized.right.left.val);
    }

    @Test
    public void test2() {
      Codec_2 sol = new SerializeandDeserializeBinaryTree().new Codec_2();
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(3);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(-2);

      String seralized = sol.serialize(root);
      assertEquals("1 3 # # 2 -2 # # # ", sol.serialize(root));

      TreeNode deseralized = sol.deserialize(seralized);
      assertEquals(1, deseralized.val);
      assertEquals(3, deseralized.left.val);
      assertEquals(2, deseralized.right.val);
      assertEquals(-2, deseralized.right.left.val);
    }
  }
}
