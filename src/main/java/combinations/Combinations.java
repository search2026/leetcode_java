package combinations;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Combinations {
    /*
        Combinations
        https://leetcode.com/problems/combinations/
        Difficulty: Medium
     */
    public class Solution {
        private void search(int start, int end, int k,
                ArrayDeque<Integer> queue, List<List<Integer>> rslt) {
            if (k == 0) {
                rslt.add(new ArrayList<Integer>(queue));
                return;
            }

            for (int i = start; i <= end - k + 1; i++) {
                queue.offerLast(i);
                search(i + 1, end, k - 1, queue, rslt);
                queue.removeLast();
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            search(1, n, k, new ArrayDeque<Integer>(), rslt);
            return rslt;
        }
    }

    public static class UnitTest {

    }
}
