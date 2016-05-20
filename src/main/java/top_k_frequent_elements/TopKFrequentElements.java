package top_k_frequent_elements;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TopKFrequentElements {
    /*
        Top K Frequent Elements - Bucket Sort
        Leetcode #347
        https://leetcode.com/problems/top-k-frequent-elements/
        Difficulty: Medium
     */
    public class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer> rslt = new ArrayList<>();
            if (nums == null || nums.length == 0) return rslt;
            if (k < 1) return rslt;

            int n = nums.length;

            Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            List<Integer>[] bucket = new ArrayList[n + 1];
            for (int key : freqMap.keySet()) {
                int freq = freqMap.get(key);
                if (bucket[freq] == null) {
                    bucket[freq] = new ArrayList<>();
                }
                bucket[freq].add(key);
            }

            for (int pos = bucket.length - 1; pos >= 0 && rslt.size() < k; pos--) {
                if (bucket[pos] != null) {
                    rslt.addAll(bucket[pos]);
                }
            }
            return rslt;
        }
    }

    /*
        Top K Frequent Elements - Heap
        Leetcode #347
        https://leetcode.com/problems/top-k-frequent-elements/
        Difficulty: Medium
     */
    public class Solution_2 {
        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer> rslt = new ArrayList<Integer>();
            if (nums == null || nums.length == 0) return rslt;
            if (k < 1) return rslt;

            HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
            for(int num: nums){
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Map.Entry<Integer, Integer>> pq =
                    new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
            pq.addAll(freqMap.entrySet());

            for(int i = 0; i < k; i++){
                rslt.add(pq.poll().getKey());
            }
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new TopKFrequentElements().new Solution();
            int[] testArray = {1,1,1,2,2,3};
            int[] expected = new int[]{1,2};
            List<Integer> rslt = sol.topKFrequent(testArray, 2);
            Integer[] rsltArray = new Integer[rslt.size()];
            rsltArray = rslt.toArray(rsltArray);
            assertEquals(expected.length, rsltArray.length);
            for (int i=0; i<expected.length; i++) {
                assertEquals(expected[i], (int)rsltArray[i]);
            }
        }

        @Test
        public void test2() {
            Solution_2 sol = new TopKFrequentElements().new Solution_2();
            int[] testArray = {1,1,1,2,2,3};
            int[] expected = new int[]{1,2};
            List<Integer> rslt = sol.topKFrequent(testArray, 2);
            Integer[] rsltArray = new Integer[rslt.size()];
            rsltArray = rslt.toArray(rsltArray);
            assertEquals(expected.length, rsltArray.length);
            for (int i=0; i<expected.length; i++) {
                assertEquals(expected[i], (int)rsltArray[i]);
            }
        }
    }
}

