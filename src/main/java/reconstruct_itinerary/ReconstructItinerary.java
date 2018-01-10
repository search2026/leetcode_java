package reconstruct_itinerary;

import org.junit.Test;

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
        public void search(LinkedList<String> rslt, String cur, Map<String, PriorityQueue<String>> adj) {
            while (adj.containsKey(cur) && !adj.get(cur).isEmpty()) {
                search(rslt, adj.get(cur).poll(), adj);
            }
            rslt.addFirst(cur);
        }

        public List<String> findItinerary(String[][] tickets) {
            if (tickets == null || tickets.length == 0) return new LinkedList<String>();
            LinkedList<String> rslt = new LinkedList<String>();
            Map<String, PriorityQueue<String>> adj = new HashMap<String, PriorityQueue<String>>();
            for (String[] ticket : tickets) {
                if (!adj.containsKey(ticket[0])) {
                    adj.put(ticket[0], new PriorityQueue<String>());
                }
                adj.get(ticket[0]).offer(ticket[1]);
            }
            search(rslt, "JFK", adj);
            return rslt;
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
            List<String> rslt = sol.findItinerary(tickets);
            String[] tmpArray = new String[rslt.size()];
            tmpArray = rslt.toArray(tmpArray);
            assertArrayEquals(new String[]{"JFK", "MUC", "LHR", "SFO", "SJC"}, tmpArray);

            tickets = new String[][]{
                    new String[]{"JFK", "SFO"},
                    new String[]{"JFK", "ATL"},
                    new String[]{"SFO", "ATL"},
                    new String[]{"ATL", "JFK"},
                    new String[]{"ATL", "SFO"}
            };
            rslt = sol.findItinerary(tickets);
            tmpArray = new String[rslt.size()];
            tmpArray = rslt.toArray(tmpArray);
            assertArrayEquals(new String[]{"JFK", "ATL", "JFK", "SFO", "ATL", "SFO"}, tmpArray);
        }
    }
}

