package com.search2026.leetcode.problems;

import java.util.*;

public class PalindromePairs {

    /*
        Palindrome Pairs - HashMap
        Leetcode #336
        https://leetcode.com/problems/palindrome-pairs/
        Difficulty: Hard
     */
    public class Solution {
        private boolean isPalindrome(String s) {
            for (int i = 0; i < s.length() / 2; ++i)
                if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                    return false;
            return true;
        }

        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();
            if (words == null) return res;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) map.put(words[i], i);
            for (int i = 0; i < words.length; i++) {
                int left = 0, right = 0;
                while (left <= right) {
                    String s = words[i].substring(left, right);
                    Integer j = map.get(new StringBuilder(s).reverse().toString());
                    if (j != null && i != j && isPalindrome(words[i].substring(left == 0 ? right : 0, left == 0 ? words[i].length() : left)))
                        res.add(Arrays.asList(left == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
                    if (right < words[i].length()) right++;
                    else left++;
                }
            }
            return res;
        }
    }

    /*
        Palindrome Pairs - HashMap
        Leetcode #336
        https://leetcode.com/problems/palindrome-pairs/
        Difficulty: Hard
     */
    public class Solution_2 {
        private boolean isPalindrome(String s) {
            for (int i = 0; i < s.length() / 2; ++i)
                if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                    return false;
            return true;
        }

        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();
            if (words == null || words.length < 2) return res;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) map.put(words[i], i);
            // Case1: If s1 is a blank string, then for any string that is palindrome s2, s1+s2 and s2+s1 are palindrome.
            // Case 2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.
            // Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] , then s2+s1 is palindrome.
            // Case 4: Similar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome.
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j <= words[i].length(); j++) {
                    String s1 = words[i].substring(0, j), s2 = words[i].substring(j);
                    if (isPalindrome(s1)) {
                        String t = new StringBuilder(s2).reverse().toString();
                        if (map.getOrDefault(t, i) != i) res.add(Arrays.asList(map.get(t), i));
                    }
                    if (isPalindrome(s2) && !s2.isEmpty()) {
                        String t = new StringBuilder(s1).reverse().toString();
                        if (map.getOrDefault(t, i) != i) res.add(Arrays.asList(i, map.get(t)));
                    }
                }
            }
            return res;
        }
    }

    /*
        Palindrome Pairs - HashMap
        Leetcode #336
        https://leetcode.com/problems/palindrome-pairs/
        Difficulty: Hard
     */
    public class Solution_3 {
        private boolean isPalindrome(String s) {
            for (int i = 0; i < s.length() / 2; ++i)
                if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                    return false;
            return true;
        }

        private void addPair(Map<String, Integer> map, List<List<Integer>> res, String str1, String str2, int index, boolean reverse) {
            if (isPalindrome(str1)) {
                String str2rev = new StringBuilder(str2).reverse().toString();
                if (map.containsKey(str2rev) && map.get(str2rev) != index) {
                    List<Integer> list = new ArrayList<>();
                    if (!reverse) {
                        list.add(map.get(str2rev));
                        list.add(index);
                    } else {
                        list.add(index);
                        list.add(map.get(str2rev));
                    }
                    res.add(list);
                }
            }
        }

        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();
            if (words == null || words.length < 2) {
                return res;
            }
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < words.length; i++) {
                map.put(words[i], i);
            }
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j <= words[i].length(); j++) {
                    String str1 = words[i].substring(0, j);
                    String str2 = words[i].substring(j);
                    addPair(map, res, str1, str2, i, false);
                    if (str2.length() != 0) {
                        addPair(map, res, str2, str1, i, true);
                    }
                }
            }
            return res;
        }
    }

    /*
        Palindrome Pairs - Trie
        Leetcode #336
        https://leetcode.com/problems/palindrome-pairs/
        https://leetcode.com/discuss/91429/solution-with-structure-total-number-words-average-length
        Difficulty: Hard
     */
    public class Solution_4 {
        class TrieNode {
            TrieNode[] next;
            int index;
            List<Integer> list;

            TrieNode() {
                next = new TrieNode[26];
                index = -1;
                list = new ArrayList<>();
            }
        }

        private void addWord(TrieNode root, String word, int index) {
            for (int i = word.length() - 1; i >= 0; i--) {
                if (root.next[word.charAt(i) - 'a'] == null) {
                    root.next[word.charAt(i) - 'a'] = new TrieNode();
                }

                if (isPalindrome(word, 0, i)) {
                    root.list.add(index);
                }

                root = root.next[word.charAt(i) - 'a'];
            }

            root.list.add(index);
            root.index = index;
        }

        private boolean isPalindrome(String word, int i, int j) {
            while (i < j) {
                if (word.charAt(i++) != word.charAt(j--)) return false;
            }

            return true;
        }

        private void search(String[] words, int i, TrieNode root, List<List<Integer>> list) {
            for (int j = 0; j < words[i].length(); j++) {
                if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                    list.add(Arrays.asList(i, root.index));
                }

                root = root.next[words[i].charAt(j) - 'a'];
                if (root == null) return;
            }

            for (int j : root.list) {
                if (i == j) continue;
                list.add(Arrays.asList(i, j));
            }
        }

        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();

            TrieNode root = new TrieNode();
            for (int i = 0; i < words.length; i++) {
                addWord(root, words[i], i);
            }

            for (int i = 0; i < words.length; i++) {
                search(words, i, root, res);
            }

            return res;
        }
    }

}
