package reconstruct_itinerary;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class ReconstructItinerary {
    /*
        Reconstruct Itinerary
        https://leetcode.com/problems/reconstruct-itinerary/
        Difficulty: Medium
     */
    public class Solution {
        Map<String, PriorityQueue<String>> adj;

        public void search(String depart, List<String> rslt) {
            while (!adj.get(depart).isEmpty()) {
                String arrive = adj.get(depart).poll();
                search(arrive, rslt);
                rslt.add(arrive);
            }
        }

        public List<String> findItinerary(String[][] tickets) {
            adj = new HashMap<String, PriorityQueue<String>>();
            List<String> rslt = new ArrayList<String>();
            for (String[] ticket : tickets) {
                String depart = ticket[0];
                String arrive = ticket[1];
                adj.putIfAbsent(depart, new PriorityQueue<String>());
                adj.putIfAbsent(arrive, new PriorityQueue<String>());
                adj.get(depart).add(arrive);
            }
            search("JFK", rslt);
            rslt.add("JFK");
            Collections.reverse(rslt);
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
            assertArrayEquals(new String[]{"JFK", "MUC", "LHR", "SFO", "SJC"}, tmpArray
            );

            tickets = new String[][]{
                    new String[]{"JFK", "SFO"},
                    new String[]{"JFK", "ATL"},
                    new String[]{"SFO", "ATL"},
                    new String[]{"ATL", "JFK"},
                    new String[]{"ATL", "SFO"}
            };
            rslt = sol.findItinerary(tickets);
            tmpArray = new String[rslt.size()];
            assertArrayEquals(new String[]{"JFK","ATL","JFK","SFO","ATL","SFO"}, tmpArray
            );
        }
    }
}

