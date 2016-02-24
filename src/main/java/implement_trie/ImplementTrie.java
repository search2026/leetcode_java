package implement_trie;

public class ImplementTrie {
    /*
        Implement Trie
        https://leetcode.com/problems/implement-trie-prefix-tree/
        Difficulty: Medium
     */
    class TrieNode {
        private TrieNode[] children = new TrieNode[26];

        private boolean end = false;

        private TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        private TrieNode getOrCreateChild(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
            }
            return children[c - 'a'];
        }

        public void insert(int start, String word) {
            if (start == word.length()) {
                end = true;
            } else {
                TrieNode child = getOrCreateChild(word.charAt(start));
                child.insert(start + 1, word);
            }
        }

        public boolean search(int start, String word, boolean prefixSearch) {
            if (start == word.length()) {
                return end || prefixSearch;
            }
            TrieNode child = getChild(word.charAt(start));
            if (child != null) {
                return child.search(start + 1, word, prefixSearch);
            }
            return false;
        }
    }

    public class Trie {
        private TrieNode root = new TrieNode();

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            root.insert(0, word);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return root.search(0, word, false);
        }

        /**
         * Returns if there is any word in the trie
         * that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return root.search(0, prefix, true);
        }
    }
}


//class TrieNode {
//    public boolean isWord;
//    public TrieNode[] children = new TrieNode[26];
//    public TrieNode() {}
//}
//
//public class Trie {
//    private TrieNode root;
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    public void insert(String word) {
//        TrieNode ws = root;
//        for(int i = 0; i < word.length(); i++){
//            char c = word.charAt(i);
//            if(ws.children[c - 'a'] == null){
//                ws.children[c - 'a'] = new TrieNode();
//            }
//            ws = ws.children[c - 'a'];
//        }
//        ws.isWord = true;
//    }
//
//    public boolean search(String word) {
//        TrieNode ws = root;
//        for(int i = 0; i < word.length(); i++){
//            char c = word.charAt(i);
//            if(ws.children[c - 'a'] == null) return false;
//            ws = ws.children[c - 'a'];
//        }
//        return ws.isWord;
//    }
//
//    public boolean startsWith(String prefix) {
//        TrieNode ws = root;
//        for(int i = 0; i < prefix.length(); i++){
//            char c = prefix.charAt(i);
//            if(ws.children[c - 'a'] == null) return false;
//            ws = ws.children[c - 'a'];
//        }
//        return true;
//    }
//}
