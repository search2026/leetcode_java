package serialize_and_deserialize_binary_tree;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializeandDeserializeBinaryTree {
    /*
        Serialize and Deserialize Binary Tree - BFS
        Leetcode #297
        https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
        Difficulty: Medium
     */
    public class Codec_1 {
        private static final String SPLITER = " ";
        private static final String NULLNODE = "#";

        public String serialize(TreeNode root) {
            if (root == null) return "";

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

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
            queue.offer(root);

            for (int i = 1; i < tokens.length; i++) {
                TreeNode curr = queue.poll();
                if (!tokens[i].equals(NULLNODE)) {
                    TreeNode left = new TreeNode(Integer.parseInt(tokens[i]));
                    curr.left = left;
                    queue.add(left);
                }
                i++;
                if (!tokens[i].equals(NULLNODE)) {
                    TreeNode right = new TreeNode(Integer.parseInt(tokens[i]));
                    curr.right = right;
                    queue.add(right);
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

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return NULLNODE;
            return "" + root.val + SPLITER + serialize(root.left) + SPLITER + serialize(root.right);
        }

        public TreeNode deserialize(String data) {
            return build(new Scanner(data));
        }

        private TreeNode build(Scanner sc) {
            if (!sc.hasNext()) return null;
            String token = sc.next();
            if (token.equals(NULLNODE)) return null;

            TreeNode root = new TreeNode(Integer.parseInt(token));
            root.left = build(sc);
            root.right = build(sc);

            return root;
        }
    }

    /*
      Serialize and Deserialize Binary Tree - DFS
      Leetcode #297
      https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
      Difficulty: Medium
   */
    public class Codec_3 {
        private static final String SPLITER = " ";
        private static final String NULLNODE = "#";

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NULLNODE).append(SPLITER);
                return;
            }

            sb.append(node.val).append(SPLITER);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }

        private TreeNode buildTree(LinkedList<String> nodes) {
            String val = nodes.pop();
            if (val.equals(NULLNODE)) return null;

            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(SPLITER)));
            return buildTree(nodes);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Codec_1 sol = new SerializeandDeserializeBinaryTree().new Codec_1();
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
            assertEquals("1 3 # # 2 -2 # # #", sol.serialize(root));

            TreeNode deseralized = sol.deserialize(seralized);
            assertEquals(1, deseralized.val);
            assertEquals(3, deseralized.left.val);
            assertEquals(2, deseralized.right.val);
            assertEquals(-2, deseralized.right.left.val);
        }

        @Test
        public void test3() {
            Codec_3 sol = new SerializeandDeserializeBinaryTree().new Codec_3();
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
