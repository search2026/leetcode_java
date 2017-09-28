package word_search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordSearch {
    /*
        Word Search
        Leetcode #79
        https://leetcode.com/problems/word-search/
        Difficulty: Medium
    */
    public class Solution {
        private boolean search(char[][] board, int i, int j, String word, int start) {
            if (start == word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                return false;
            }
            if (board[i][j] == '*' || board[i][j] != word.charAt(start)) {
                return false;
            }
            char c = board[i][j];
            board[i][j] = '*';  //visited
            int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : dirs) {
                if (search(board, i + dir[0], j + dir[1], word, start + 1)) {
                    board[i][j] = c;
                    return true;
                }
            }
            board[i][j] = c;
            return false;
        }

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (search(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /*
        Word Search
        Leetcode #79
        https://leetcode.com/problems/word-search/
        Difficulty: Medium
    */
    public class Solution_2 {
        private boolean exist(char[][] board, int y, int x, char[] word, int i) {
            if (i == word.length) return true;
            if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
            if (board[y][x] != word[i]) return false;
            board[y][x] ^= 256;
            boolean exist = exist(board, y, x + 1, word, i + 1)
                    || exist(board, y, x - 1, word, i + 1)
                    || exist(board, y + 1, x, word, i + 1)
                    || exist(board, y - 1, x, word, i + 1);
            board[y][x] ^= 256;
            return exist;
        }

        public boolean exist(char[][] board, String word) {
            char[] w = word.toCharArray();
            for (int y = 0; y < board.length; y++) {
                for (int x = 0; x < board[y].length; x++) {
                    if (exist(board, y, x, w, 0)) return true;
                }
            }
            return false;
        }
    }

    /*
        Word Search II - Backtracking + Trie
        Leetcode #212
        https://leetcode.com/problems/word-search-ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        Set<String> result = new HashSet<>();
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public void search(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
            int m = board.length;
            int n = board[0].length;

            if (i < 0 || j < 0 || i >= m || j >= n) return;
            if (visited[i][j]) return;

            str = str + board[i][j];

            if (!trie.startsWith(str)) return;
            if (trie.search(str)) result.add(str);

            visited[i][j] = true;
            for (int[] dir : dirs) {
                search(board, visited, str, i + dir[0], j + dir[1], trie);
            }

            visited[i][j] = false;
        }

        public List<String> findWords(char[][] board, String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            int m = board.length;
            int n = board[0].length;

            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    search(board, visited, "", i, j, trie);
                }
            }

            return new ArrayList<String>(result);
        }

        //Trie Node
        class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public String item = "";
        }

        //Trie
        class Trie {
            public TrieNode root = new TrieNode();

            public void insert(String word) {
                TrieNode node = root;
                for (char c : word.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new TrieNode();
                    }
                    node = node.children[c - 'a'];
                }
                node.item = word;
            }

            public boolean search(String word) {
                TrieNode node = root;
                for (char c : word.toCharArray()) {
                    if (node.children[c - 'a'] == null)
                        return false;
                    node = node.children[c - 'a'];
                }
                return node.item.equals(word);
            }

            public boolean startsWith(String prefix) {
                TrieNode node = root;
                for (char c : prefix.toCharArray()) {
                    if (node.children[c - 'a'] == null)
                        return false;
                    node = node.children[c - 'a'];
                }
                return true;
            }
        }
    }


    /*
        Word Search II - Backtracking + Trie
        Leetcode #212
        https://leetcode.com/problems/word-search-ii/
        Difficulty: Medium
    */
    public class Solution_4 {
        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            String word;
        }

        public TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();
            for (String w : words) {
                TrieNode p = root;
                for (char c : w.toCharArray()) {
                    int i = c - 'a';
                    if (p.next[i] == null) p.next[i] = new TrieNode();
                    p = p.next[i];
                }
                p.word = w;
            }
            return root;
        }

        private void search(char[][] board, int i, int j, TrieNode p, List<String> res) {
            char c = board[i][j];
            if (c == '#' || p.next[c - 'a'] == null) return;
            p = p.next[c - 'a'];
            if (p.word != null) {   // found one
                res.add(p.word);
                p.word = null;     // de-duplicate
            }

            board[i][j] = '#';
            if (i > 0) search(board, i - 1, j, p, res);
            if (j > 0) search(board, i, j - 1, p, res);
            if (i < board.length - 1) search(board, i + 1, j, p, res);
            if (j < board[0].length - 1) search(board, i, j + 1, p, res);
            board[i][j] = c;
        }

        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            TrieNode root = buildTrie(words);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    search(board, i, j, root, res);
                }
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WordSearch().new Solution();
            char[][] board = new char[][]{
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
            };
            assertTrue(sol.exist(board, "ABCCED"));
            assertTrue(sol.exist(board, "SEE"));
            assertFalse(sol.exist(board, "ABCB"));
        }

        @Test
        public void test2() {
            Solution_2 sol = new WordSearch().new Solution_2();
            char[][] board = new char[][]{
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
            };
            assertTrue(sol.exist(board, "ABCCED"));
            assertTrue(sol.exist(board, "SEE"));
            assertFalse(sol.exist(board, "ABCB"));
        }

        @Test
        public void test3() {
            Solution_3 sol = new WordSearch().new Solution_3();
            char[][] board = new char[][]{
                    {'o', 'a', 'a', 'n'},
                    {'e', 't', 'a', 'e'},
                    {'i', 'h', 'k', 'r'},
                    {'i', 'f', 'l', 'v'}
            };
            String[] words = {"oath", "pea", "eat", "rain"};
            List<String> res = sol.findWords(board, words);
            assertEquals(2, res.size());
            assertTrue(res.contains("oath"));
            assertTrue(res.contains("eat"));
            assertFalse(res.contains("pea"));
            assertFalse(res.contains("rain"));
        }

        @Test
        public void test4() {
            Solution_4 sol = new WordSearch().new Solution_4();
            char[][] board = new char[][]{
                    {'o', 'a', 'a', 'n'},
                    {'e', 't', 'a', 'e'},
                    {'i', 'h', 'k', 'r'},
                    {'i', 'f', 'l', 'v'}
            };
            String[] words = {"oath", "pea", "eat", "rain"};
            List<String> res = sol.findWords(board, words);
            assertEquals(2, res.size());
            assertTrue(res.contains("oath"));
            assertTrue(res.contains("eat"));
            assertFalse(res.contains("pea"));
            assertFalse(res.contains("rain"));
        }
    }
}
