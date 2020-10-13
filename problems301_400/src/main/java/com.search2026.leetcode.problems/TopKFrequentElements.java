package com.search2026.leetcode.problems;

import java.util.*;

public class TopKFrequentElements {

    /*
        Top K Frequent Elements - Bucket Sort
        Leetcode #347
        https://leetcode.com/problems/top-k-frequent-elements/
        Difficulty: Medium
     */
    public class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            if (k < 1) return res;

            int n = nums.length;

            Map<Integer, Integer> freqMap = new HashMap<>();

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

            for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
                if (bucket[pos] != null) {
                    res.addAll(bucket[pos]);
                }
            }
            return res;
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
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            if (k < 1) return res;

            HashMap<Integer, Integer> freqMap = new HashMap<>();
            for(int num: nums){
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Map.Entry<Integer, Integer>> pq =
                    new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
            pq.addAll(freqMap.entrySet());

            for(int i = 0; i < k; i++){
                res.add(pq.poll().getKey());
            }
            return res;
        }
    }

}
