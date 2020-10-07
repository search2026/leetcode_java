package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

    /*
        Repeated DNA Sequences
        Leetcode #187
        https://leetcode.com/problems/repeated-dna-sequences/
        Difficulty: Medium
     */
    public class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> sequences = new HashSet<>();
            Set<String> res = new HashSet<>();
            for (int i = 0; i + 10 <= s.length(); i++) {
                String substring = s.substring(i, i + 10);
                if (sequences.contains(substring)) {
                    res.add(substring);
                } else {
                    sequences.add(substring);
                }
            }
            System.gc();
            return new ArrayList<>(res);
        }
    }

}
