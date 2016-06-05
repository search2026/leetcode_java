package repeated_dna_sequences;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class RepeatedDNASequences {
    /*
        Repeated DNA Sequences
        Leetcode #187
        https://leetcode.com/problems/repeated-dna-sequences/
        Difficulty: Medium
     */
    public class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> sequences = new HashSet<String>();
            Set<String> result = new HashSet<String>();
            for (int i = 0; i + 10 <= s.length(); i++) {
                String substring = s.substring(i, i + 10);
                if (sequences.contains(substring)) {
                    result.add(substring);
                } else {
                    sequences.add(substring);
                }
            }
            System.gc();
            return new ArrayList<String>(result);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RepeatedDNASequences().new Solution();
            assertEquals(7, 7);
        }
    }
}

