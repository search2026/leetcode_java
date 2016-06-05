package word_search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Word Search II
        Leetcode #212
        https://leetcode.com/problems/word-search-ii/
        Difficulty: Medium
    */
    public class Solution_2 {
        Set<String> result = new HashSet<String>();
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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WordSearch().new Solution();
            assertTrue(true);
        }
    }
}
