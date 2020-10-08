package reconstruct_itinerary;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReconstructItinerary {
    /*
        Reconstruct Itinerary
        Leetcode #332
        https://leetcode.com/problems/reconstruct-itinerary/
        Difficulty: Medium
     */
    public class Solution {
        public void search(LinkedList<String> res, String curr, Map<String, PriorityQueue<String>> adj) {
            while (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
                search(res, adj.get(curr).poll(), adj);
            }
            res.addFirst(curr);
        }

        public List<String> findItinerary(String[][] tickets) {
            if (tickets == null || tickets.length == 0) return new LinkedList<String>();
            LinkedList<String> res = new LinkedList<String>();
            Map<String, PriorityQueue<String>> adj = new HashMap<String, PriorityQueue<String>>();
            for (String[] ticket : tickets) {
                if (!adj.containsKey(ticket[0])) {
                    adj.put(ticket[0], new PriorityQueue<String>());
                }
                adj.get(ticket[0]).offer(ticket[1]);
            }
            search(res, "JFK", adj);
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ReconstructItinerary().new Solution();
            String[][] tickets = new String[][]{
                    new String[]{"MUC", "LHR"},
                    new String[]{"JFK", "MUC"},
                    new String[]{"SFO", "SJC"},
                    new String[]{"LHR", "SFO"}
            };
            List<String> res = sol.findItinerary(tickets);
            String[] tmpArray = new String[res.size()];
            tmpArray = res.toArray(tmpArray);
            assertArrayEquals(new String[]{"JFK", "MUC", "LHR", "SFO", "SJC"}, tmpArray);

            tickets = new String[][]{
                    new String[]{"JFK", "SFO"},
                    new String[]{"JFK", "ATL"},
                    new String[]{"SFO", "ATL"},
                    new String[]{"ATL", "JFK"},
                    new String[]{"ATL", "SFO"}
            };
            res = sol.findItinerary(tickets);
            tmpArray = new String[res.size()];
            tmpArray = res.toArray(tmpArray);
            assertArrayEquals(new String[]{"JFK", "ATL", "JFK", "SFO", "ATL", "SFO"}, tmpArray);
        }
    }
}

