package com.search2026.leetcode.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTrie {

    @Test
    public void testTrie() {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("wish");

        assertTrue(trie.search("hello"));
        assertFalse(trie.search("hell"));
        assertTrue(trie.startsWith("hell"));
        assertTrue(trie.search("world"));
        assertTrue(trie.search("world"));
    }

}
