package com.search2026.leetcode.common;

import java.util.HashMap;
import java.util.Map;

/*
    Define a node class to be used in a trie data structure
 */
public class TrieNode {
    char c;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.c = c;
    }
}
