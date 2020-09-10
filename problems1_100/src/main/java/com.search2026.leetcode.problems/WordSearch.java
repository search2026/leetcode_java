package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {

    /*
        Word Search
        Leetcode #79
        https://leetcode.com/problems/word-search/
        Difficulty: Medium
    */
    public class Solution {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

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
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        private boolean search(char[][] board, int y, int x, char[] word, int i) {
            if (i == word.length) return true;
            if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
            if (board[y][x] != word[i]) return false;
            board[y][x] ^= 256;
            boolean res = true;
            for (int[] dir : dirs) {
                res = res || search(board, y + dir[0], x + dir[1], word, i + 1);
            }
            board[y][x] ^= 256;
            return res;
        }

        public boolean search(char[][] board, String word) {
            char[] w = word.toCharArray();
            for (int y = 0; y < board.length; y++) {
                for (int x = 0; x < board[y].length; x++) {
                    if (search(board, y, x, w, 0)) return true;
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
        Set<String> res = new HashSet<>();
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        private void search(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
            int m = board.length;
            int n = board[0].length;

            if (i < 0 || j < 0 || i >= m || j >= n) return;
            if (visited[i][j]) return;

            str = str + board[i][j];

            if (!trie.startsWith(str)) return;
            if (trie.search(str)) res.add(str);

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

            return new ArrayList<>(res);
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

}
