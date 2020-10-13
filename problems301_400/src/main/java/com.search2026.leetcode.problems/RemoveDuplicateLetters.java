package com.search2026.leetcode.problems;

public class RemoveDuplicateLetters {

    /*
        Remove Duplicate Letters
        Leetcode #316
        https://leetcode.com/problems/remove-duplicate-letters/
        Difficulty: Medium
     */
    public class Solution {
        public char START = (char)('a'-1);
        public String removeDuplicateLetters(String s){
            if(s.length() == 0) return s;

            //We use 128 is to avoid substraction
            //if we use 26, we have to substract 'a' from a char
            int[] count = new int[128];
            char[] prev = new char[128];
            boolean[] assigned = new boolean[128];
            char c;
            char end = START;

            for(int i=0; i<s.length(); i++){
                c = s.charAt(i);
                count[c]++;
            }

            for(int i=0; i<s.length(); i++){
                c = s.charAt(i);
                count[c]--;
                if(assigned[c])
                    continue;

                while(end >= c && count[end]>0){
                    assigned[end] = false;
                    end = prev[end];
                }

                prev[c] = end;
                end = c;
                assigned[c] = true;
            }

            StringBuilder bd = new StringBuilder();
            while(end>START){
                bd.append(end);
                end = prev[end];
            }
            return bd.reverse().toString();
        }
    }


}
