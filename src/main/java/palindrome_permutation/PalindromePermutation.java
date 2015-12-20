package palindrome_permutation;

import java.util.*;

public class PalindromePermutation {
    // Palindrome Permutation
    // http://buttercola.blogspot.com/2015/08/leetcode-palindrome-permutation.html
    // Difficulty: Easy
    public class Solution {
        public boolean canPermutePalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return true;
            }

            Map<Character, Integer> map = new HashMap<Character, Integer>();

            for (int i = 0; i < s.length(); i++) {
                char letter = s.charAt(i);

                if (map.containsKey(letter)) {
                    int count = map.get(letter) + 1;
                    map.put(letter, count);
                } else {
                    map.put(letter, 1);
                }
            }

            int tolerance = 0;
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                if ((int) pair.getValue() % 2 != 0) {
                    tolerance++;
                }
            }

            if (s.length() % 2 == 0) {
                return tolerance == 0;
            } else {
                return tolerance == 1;
            }
        }
    }

    // Palindrome Permutation II
    // http://buttercola.blogspot.com/2015/09/leetcode-palindrome-permutation-ii.html
    // Difficulty: Medium
    public class SolutionII {
        public List<String> generatePalindromes(String s) {
            List<String> result = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return result;
            }

            // Step 1: determine if the string s is palindrome permutated
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            if (!isPalindromePermutation(s, map)) {
                return result;
            }

            // Step 2: form the left half of the seed string
            StringBuffer sb = new StringBuffer();
            char middle = '\0';

            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                char key = (char) pair.getKey();
                int val = (int) pair.getValue();
                while (val > 1) {
                    sb.append(key);
                    val -= 2;
                }

                if (val == 1) {
                    middle = key;
                }
            }

            // Step 3: gnerate the permutations of the string
            permutation(sb.toString().toCharArray(), 0, result);
            List<String> result2 = new ArrayList<>();

            // Step 4: append the right half of the string
            for (String str : result) {
                StringBuffer tmp = new StringBuffer(str);
                if (middle != '\0') {
                    tmp.append(middle);
                }

                for (int i = str.length() - 1; i >= 0; i--) {
                    tmp.append(str.charAt(i));
                }
                result2.add(tmp.toString());
            }

            return result2;
        }

        private boolean isPalindromePermutation(String s, Map<Character, Integer> map) {
            int tolerance = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    int val = map.get(c);
                    map.put(c, val + 1);
                } else {
                    map.put(c, 1);
                }
            }

            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                int val = (int) pair.getValue();
                if (val % 2 == 1) {
                    tolerance++;
                }
            }

            if (tolerance <= 1) {
                return true;
            } else {
                return false;
            }
        }

        private void permutation(char[] s, int start, List<String> result) {
            if (start >= s.length) {
                result.add(new String(s));
                return;
            }

            for (int i = start; i < s.length; i++) {
                if (!containsDuplicate(s, start, i)) {
                    swap(s, i, start);
                    permutation(s, start + 1, result);
                    swap(s, i, start);
                }
            }
        }

        private void swap(char[] s, int i, int j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        private boolean containsDuplicate(char[] s, int start, int end) {
            for (int i = start; i < end; i++) {
                if (s[i] == s[end]) {
                    return true;
                }
            }

            return false;
        }
    }

    public static class UnitTest {

    }
}
