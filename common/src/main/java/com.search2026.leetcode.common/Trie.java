package com.search2026.leetcode.common;

import java.util.Map;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isLeaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        return t != null && t.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (char c : str.toCharArray()) {
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }
}
