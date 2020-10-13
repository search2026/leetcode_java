package com.search2026.leetcode.problems;

import java.util.*;

public class ReconstructItinerary {

    /*
        Reconstruct Itinerary
        Leetcode #332
        https://leetcode.com/problems/reconstruct-itinerary/
        Difficulty: Medium
     */
    public class Solution {
        private void search(LinkedList<String> res, String curr, Map<String, PriorityQueue<String>> adj) {
            while (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
                search(res, adj.get(curr).poll(), adj);
            }
            res.addFirst(curr);
        }

        public List<String> findItinerary(String[][] tickets) {
            if (tickets == null || tickets.length == 0) return new LinkedList<>();
            LinkedList<String> res = new LinkedList<>();
            Map<String, PriorityQueue<String>> adj = new HashMap<>();
            for (String[] ticket : tickets) {
                if (!adj.containsKey(ticket[0])) {
                    adj.put(ticket[0], new PriorityQueue<>());
                }
                adj.get(ticket[0]).offer(ticket[1]);
            }
            search(res, "JFK", adj);
            return res;
        }
    }

}
