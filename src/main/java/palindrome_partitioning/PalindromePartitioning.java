package palindrome_partitioning;

import java.util.*;

public class PalindromePartitioning {

    public class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new LinkedList<List<String>>();
            if (s == null || s.length() == 0){
                return result;
            }
            boolean[][] isP = new boolean[s.length()][s.length()];
            calIsP(isP, s);
            findCut(isP, result, new LinkedList<String>(), s, 0);
            return result;
        }

        private void calIsP(boolean[][] isP, String s){
            for (int k = 1; k <= s.length(); k ++){
                for (int i = 0; i < s.length() - k + 1; i ++){
                    if (k == 1)
                        isP[i][i+k-1] = true;
                    else if (k == 2)
                        isP[i][i+k-1] = (s.charAt(i) == s.charAt(i + k - 1));
                    else{
                        if (s.charAt(i) != s.charAt(i + k - 1))
                            isP[i][i+k-1] = false;
                        else
                            isP[i][i+k-1] = isP[i+1][i+k-2];
                    }
                }
            }
        }

        private void findCut(boolean[][] isP, List<List<String>> result, List<String> current, String s, int start){
            for (int i = start; i < s.length(); i ++){
                if (isP[start][i] == true){
                    if (i + 1 == s.length()){
                        List<String> solution = new LinkedList<String>(current);
                        solution.add(s.substring(start, i + 1));
                        result.add(solution);
                    }
                    else{
                        current.add(s.substring(start, i + 1));
                        findCut(isP, result, current, s, i + 1);
                        current.remove(current.size() - 1);
                    }
                }
            }
        }

        // Palindrome Partitioning II
        public int minCut(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            boolean[][] isPalindrome = new boolean[s.length()][s.length()];
            int[] cuts = new int[s.length() + 1];
            cuts[0] = -1;
            for (int i = 0; i < s.length(); i++) {
                cuts[i + 1] = i;
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j)
                            && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
                        isPalindrome[j][i] = true;
                        cuts[i + 1] = Math.min(cuts[i + 1], cuts[j] + 1);
                    }
                }
            }
            return cuts[s.length()];
        }
    }

    public static class UnitTest {

    }
}
